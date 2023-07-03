package com.gev.backend.service.Impl;

import com.gev.backend.exceptions.LabelAlreadyExistsException;
import com.gev.backend.exceptions.LabelNotFoundException;
import com.gev.backend.io.entity.Label;
import com.gev.backend.io.entity.SubLabel;
import com.gev.backend.io.repository.LabelRepository;
import com.gev.backend.io.repository.SubLabelRepository;
import com.gev.backend.service.SubLabelService;
import com.gev.backend.ui.model.request.SubLabelCreateRequest;
import com.gev.backend.ui.model.request.SubLabelUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class SubLabelServiceImpl implements SubLabelService {
    
    private final SubLabelRepository subLabelRepository;
    
    private final LabelRepository labelRepository;
    
    @Autowired
    public SubLabelServiceImpl(SubLabelRepository subLabelRepository, LabelRepository labelRepository) {
        this.subLabelRepository = subLabelRepository;
        this.labelRepository = labelRepository;
    }
    
    private String generateUniqueID() {
        String uniqueID = UUID.randomUUID().toString();
        // Check if the generated ID already exists in the database
        while (subLabelRepository.existsBySubLabelPublicId(uniqueID)) {
            uniqueID = UUID.randomUUID().toString();
        }
        return uniqueID;
    }
    
    private boolean isDeleted(SubLabel subLabel) {
        if (subLabel.isMarkForDelete()) {
            return true;
        }
        return false;
    }
    
    private boolean existsLabel(Integer publicId) {
        // Example: Assuming you have a labelRepository or labelDao to interact with the
        // database
        return subLabelRepository.existsBySubLabelPrivateId(publicId);
    }
    
    private boolean existsLabel(String labelName) {
        // Example: Assuming you have a labelRepository or labelDao to interact with the
        // database
        return subLabelRepository.existsBySubLabelName(labelName);
    }
    
    public List<SubLabel> getAllSubLabels(String labelPublicId) {
        List<SubLabel> subLabels = subLabelRepository.findAll();
        subLabels.removeIf(l -> l.isMarkForDelete() == true);
        subLabels.removeIf(l -> l.getLabel().getLabelPublicId() != labelPublicId);
        return subLabels;
    }
    
    public SubLabel getSubLabelById(Long id) {
        return subLabelRepository.findById(id).orElse(null);
    }
//    public SubLabel createSubLabel(SubLabelCreateRequest subLabelCreateRequest) {
//
//        Integer labelPrivateId = subLabelCreateRequest.getLabel().getLabelPrivateId();
//
////        Optional<SubLabel> subLabelOptional = subLabelRepository.findBySubLabelNameAndLabelPrivateId(subLabelCreateRequest.getSubLabelName(),
////                labelPrivateId);
////
////        if (subLabelOptional.isPresent()) {
//////            if (subLabelOptional.get().getLabel().getLabelName().equals(subLabelCreateRequest.getLabel().getLabelName())) {
////            if (subLabelOptional.get().getSubLabelName().equals(subLabelCreateRequest.getSubLabelName())) {
////                throw new LabelAlreadyExistsException("Given sub-label name already exists in the provided label");
////            }
////        }
//
//        SubLabel subLabel = new SubLabel();
//
//        String uniqueItemName = subLabelCreateRequest.getSubLabelName();
//        int count = 1;
//
//        //to handle the case of duplicate names, here we are appending the count number of how many times the current name has been added in the database.
//        while (checkSublabelExists(labelPrivateId, uniqueItemName)/*&& !Objects.equals(uniqueItemName, "Default")*/) {
//            if (Objects.equals(uniqueItemName, "Default"))
//                throw new LabelAlreadyExistsException("SubLabel with name already exists");
//            uniqueItemName = subLabelCreateRequest.getSubLabelName() + "(" + count + ")";
//            count++;
//        }
//
//        subLabel.setSubLabelName(uniqueItemName);
//        subLabel.setLabel(subLabelCreateRequest.getLabel());
//        subLabel.setCreatedBy(subLabelCreateRequest.getCreatedBy());
//        subLabel.setSubLabelPublicId(generateUniqueID());
//
//        SubLabel afterSaved = subLabelRepository.save(subLabel);
//        return afterSaved;
//    }
    
    public SubLabel createSubLabel(SubLabelCreateRequest subLabelCreateRequest) {
        String labelPublicId = subLabelCreateRequest.getLabel().getLabelPublicId();
        Optional<Label> optionalLabel = labelRepository.findByLabelPublicId(labelPublicId);
        if (!optionalLabel.isPresent()) throw new LabelNotFoundException("Label with given id does not exist");
        Integer labelPrivateId = labelRepository.getPrivateId(labelPublicId);
        String uniqueItemName = subLabelCreateRequest.getSubLabelName();
        int count = 1;
//        int check = subLabelRepository.existsByPrivateIdAndSublabelName(labelPrivateId, uniqueItemName);
        while (subLabelRepository.existsByPrivateIdAndSublabelName(labelPrivateId, uniqueItemName) == 1) {
            if (Objects.equals(uniqueItemName, "Default")) {
                throw new LabelAlreadyExistsException("SubLabel with name default already exists");
            }
            uniqueItemName = subLabelCreateRequest.getSubLabelName() + "(" + count + ")";
            count++;
        }
        SubLabel subLabel = new SubLabel();
        subLabel.setSubLabelName(uniqueItemName);
        subLabel.setLabel(subLabelCreateRequest.getLabel());
        subLabel.setCreatedBy(subLabelCreateRequest.getCreatedBy());
        subLabel.setSubLabelPublicId(generateUniqueID());
        SubLabel afterSaved = subLabelRepository.save(subLabel);
        return afterSaved;
    }
    
    public SubLabel updateSubLabel(SubLabelUpdateRequest subLabelUpdateRequest) {
        Optional<SubLabel> subLabelOptional = subLabelRepository.findBySubLabelPublicId(subLabelUpdateRequest.getSubLabelPublicId());
        if (!subLabelOptional.isPresent()) {
            throw new LabelNotFoundException("Sub-label with given id does not exist!");
        }
        SubLabel subLabel = subLabelOptional.get();
        if (isDeleted(subLabel)) {
            throw new LabelNotFoundException("Sub-label with given id does not exist");
        }
        subLabel.setSubLabelName(subLabelUpdateRequest.getSubLabelName());
        subLabel.setModifiedBy(subLabelUpdateRequest.getModifiedBy());
        return subLabelRepository.save(subLabel);
    }
    
    public SubLabel deleteSubLabel(String subLabelPublicId) {
        Optional<SubLabel> subLabelOptional = subLabelRepository.findBySubLabelPublicId(subLabelPublicId);
        SubLabel subLabel = subLabelOptional.get();
        if (subLabelOptional.isEmpty()) {
            throw new LabelNotFoundException("Label with given id does not exist");
        }
        if (isDeleted(subLabel)) {
            throw new LabelNotFoundException("Sub-label with given id does not exist");
        }
        subLabel.setMarkForDelete(true);
        return subLabelRepository.save(subLabel);
    }
}
