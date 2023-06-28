package com.gev.backend.service.Impl;

import com.gev.backend.ui.model.request.SubLabelCreateRequest;
import com.gev.backend.ui.model.response.SubLabelCreateResponse;
import com.gev.backend.ui.model.request.SubLabelUpdateRequest;
import com.gev.backend.ui.model.response.SubLabelUpdateResponse;
import com.gev.backend.exceptions.LabelAlreadyExistsException;
import com.gev.backend.exceptions.LabelNotFoundException;
import com.gev.backend.io.entity.SubLabel;
import com.gev.backend.io.repository.SubLabelRepository;
import com.gev.backend.service.SubLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SubLabelServiceImpl implements SubLabelService {

    private SubLabelRepository subLabelRepository;

    @Autowired
    public SubLabelServiceImpl(SubLabelRepository subLabelRepository) {
        this.subLabelRepository = subLabelRepository;
    }

    public List<SubLabel> getAllSubLabels() {
        return subLabelRepository.findAll();
    }

    public SubLabel getSubLabelById(Long id) {
        return subLabelRepository.findById(id).orElse(null);
    }

    public SubLabelCreateResponse createSubLabel(SubLabelCreateRequest subLabelCreateRequest) {
        Optional<SubLabel> subLabelOptional = subLabelRepository.findBySubLabelName(subLabelCreateRequest.getSubLabelName());
        if (subLabelOptional.isPresent()) {
            if (subLabelOptional.get().getLabel().getLabelName().equals(subLabelCreateRequest.getLabel().getLabelName())) {
                throw new LabelAlreadyExistsException("Given sub-label name already exists in the provided label");
            }
        }
        SubLabel subLabel = new SubLabel();
        subLabel.setSubLabelName(subLabelCreateRequest.getSubLabelName());
        subLabel.setLabel(subLabelCreateRequest.getLabel());
        subLabel.setCreatedBy(subLabel.getCreatedBy());
        subLabel.setSubLabelPublicId(generateUniqueID());
        return new SubLabelCreateResponse(subLabelRepository.save(subLabel));
    }

    public SubLabelUpdateResponse updateSubLabel(SubLabelUpdateRequest subLabelUpdateRequest) {
        Optional<SubLabel> subLabelOptional = subLabelRepository.findBySubLabelPublicId(subLabelUpdateRequest.getSubLabelPublicId());
        if (!subLabelOptional.isPresent()) {
            throw new LabelNotFoundException("Sub-label with given id does not exist!");
        }
        SubLabel subLabel = subLabelOptional.get();
        subLabel.setSubLabelName(subLabelUpdateRequest.getSubLabelName());
        subLabel.setModifiedBy(subLabelUpdateRequest.getModifiedBy());
        return new SubLabelUpdateResponse(subLabelRepository.save(subLabel));
    }

    public boolean existsLabel(Integer publicId) {
        // Example: Assuming you have a labelRepository or labelDao to interact with the
        // database
        return subLabelRepository.existsBySubLabelPrivateId(publicId);
    }

    public String generateUniqueID() {
        String uniqueID = UUID.randomUUID().toString();
        // Check if the generated ID already exists in the database
        while (subLabelRepository.existsBySubLabelPublicId(uniqueID)) {
            uniqueID = UUID.randomUUID().toString();
        }
        return uniqueID;
    }

    public SubLabel deleteSubLabel(String subLabelPublicId) {
        Optional<SubLabel> subLabelOptional = subLabelRepository.findBySubLabelPublicId(subLabelPublicId);
        SubLabel subLabel = subLabelOptional.get();
        if (subLabelOptional.isEmpty()) {
            throw new LabelNotFoundException("Label with given id does not exist");
        }
        subLabelRepository.delete(subLabel);
        return subLabel;
    }
}
