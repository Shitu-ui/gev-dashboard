package com.gev.backend.service.Impl;

import com.gev.backend.exceptions.ErrorMessages;
import com.gev.backend.exceptions.LabelNotFoundException;
import com.gev.backend.io.entity.Label;
import com.gev.backend.io.repository.LabelRepository;
import com.gev.backend.service.LabelService;
import com.gev.backend.service.SubLabelService;
import com.gev.backend.ui.model.request.LabelCreateRequest;
import com.gev.backend.ui.model.request.LabelUpdateRequest;
import com.gev.backend.ui.model.request.SubLabelCreateRequest;
import com.gev.backend.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabelServiceImpl implements LabelService {
    
    private final LabelRepository labelRepository;
    
    private final SubLabelService subLabelService;
    
    @Autowired
    public LabelServiceImpl(LabelRepository labelRepository, SubLabelService subLabelService) {
        this.labelRepository = labelRepository;
        this.subLabelService = subLabelService;
    }
    
    private boolean isDeleted(Label label) {
        if (label.isMarkForDelete()) {
            return true;
        }
        return false;
    }
    
    private String generateUniqueID() {
        Utils utils = new Utils();
        return utils.generateRandomString(8);
    }
    
    public List<Label> getAllLabels(Integer department, Integer location) {
        List<Label> labels = labelRepository.findByLocationAndDepartment(location,department);
        labels.removeIf(l -> l.isMarkForDelete() == true);
        return labels;
    }
    
    public Label createLabel(LabelCreateRequest labelCreateRequest) {
        Integer location = labelCreateRequest.getLocation();
        Integer department = labelCreateRequest.getDepartment();
        Label label = new Label();
        String uniqueItemName = labelCreateRequest.getLabelName();
        int count = 1;
        //to handle the case of duplicate names, here we are appending the count number of how many times the current name has been added in the database.
        while (existsLabel(uniqueItemName, location, department) == 1) {
            uniqueItemName = labelCreateRequest.getLabelName() + "(" + count + ")";
            count++;
        }
        label.setLabelName(uniqueItemName);
        label.setDepartment(labelCreateRequest.getDepartment());
        label.setLocation(labelCreateRequest.getLocation());
        label.setCreatedBy(labelCreateRequest.getCreatedBy());
        label.setLabelPublicId(generateUniqueID());
        Label lbl = labelRepository.save(label);
        SubLabelCreateRequest subLabelCreateRequest = new SubLabelCreateRequest("Default", lbl, labelCreateRequest.getCreatedBy());
        subLabelService.createSubLabel(subLabelCreateRequest);
        return lbl;
        
    }
    
    public Label updateLabel(LabelUpdateRequest labelUpdateRequest) {
        Optional<Label> labelUpdateRequestOptional = labelRepository.findByLabelPublicId(labelUpdateRequest.getLabelPublicId());
        if (labelUpdateRequestOptional.isEmpty()) {
            throw new LabelNotFoundException(ErrorMessages.LABEL_WITH_GIVEN_ID_DOES_NOT_EXISTS.getErrorMessage());
        }
        Label label = labelUpdateRequestOptional.get();
        if (isDeleted(label)) {
            throw new LabelNotFoundException(ErrorMessages.LABEL_WITH_GIVEN_ID_DOES_NOT_EXISTS.getErrorMessage());
        }
        label.setModifiedBy(labelUpdateRequest.getModifiedBy());
        label.setLabelName(labelUpdateRequest.getLabelName());
        return labelRepository.save(label);
    }
    
    private Integer existsLabel(String labelName, Integer location, Integer department) {
        // Example: Assuming you have a labelRepository or labelDao to interact with the
        // database
        return labelRepository.existsByLabelNameLocationDepartment(labelName, location, department);
    }
    
    public Label deleteLabel(String labelPublicId) {
        Optional<Label> labelOptional = labelRepository.findByLabelPublicId(labelPublicId);
        if (!labelOptional.isPresent()) {
            throw new LabelNotFoundException(ErrorMessages.PLEASE_PROVIDE_VALID_ID.getErrorMessage());
        }
        Integer onlyDefaultSubLabelExists = labelRepository.checkOnlyDefaultSublabelExists(labelPublicId);
        if (onlyDefaultSubLabelExists == null || onlyDefaultSubLabelExists == 0) {
            throw new LabelNotFoundException(ErrorMessages.THIS_LABEL_HAS_SOME_SUB_LABELS.getErrorMessage());
        }
        Label label = labelOptional.get();
        if (isDeleted(label)) {
            throw new LabelNotFoundException(ErrorMessages.PLEASE_PROVIDE_VALID_ID.getErrorMessage());
        }
        label.setMarkForDelete(true);
        return labelRepository.save(label);
    }
    
}