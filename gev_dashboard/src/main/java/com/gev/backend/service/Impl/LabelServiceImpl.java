package com.gev.backend.service.Impl;

import com.gev.backend.ui.model.request.LabelCreateRequest;
import com.gev.backend.ui.model.response.LabelCreateResponse;
import com.gev.backend.ui.model.request.LabelUpdateRequest;
import com.gev.backend.ui.model.response.LabelUpdateResponse;
import com.gev.backend.exceptions.ErrorMessages;
import com.gev.backend.exceptions.LabelNotFoundException;
import com.gev.backend.io.entity.Label;
import com.gev.backend.io.repository.LabelRepository;
import com.gev.backend.service.LabelService;
import com.gev.backend.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LabelServiceImpl implements LabelService {

    private LabelRepository labelRepository;
    @Autowired
    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }
    public List<Label> getAllLabels() {
        return labelRepository.findAll();
    }

    public LabelCreateResponse createLabel(LabelCreateRequest labelCreateRequest) {
        Label label = new Label();
        label.setLabelName(labelCreateRequest.getLabelName());
        label.setDepartment(labelCreateRequest.getDepartment());
        label.setLocation(labelCreateRequest.getLocation());
        label.setCreatedBy(labelCreateRequest.getCreatedBy());
        label.setLabelPublicId(generateUniqueID());
        if (existsLabel(label.getLabelName())) {
            if (label.getLabelName() != null) label.setLabelName(label.getLabelName() + " - copy");
        }
        Label savedlabel = labelRepository.save(label);
        return new LabelCreateResponse(savedlabel);
    }
    public LabelUpdateResponse updateLabel(LabelUpdateRequest labelUpdateRequest) {
        Optional<Label> labelUpdateRequestOptional = labelRepository.findByLabelPublicId(labelUpdateRequest.getLabelPublicId());
        if (labelUpdateRequestOptional.isEmpty()) {
            throw new LabelNotFoundException("Label with given Id does not exist");
        }
        Label label = labelUpdateRequestOptional.get();
        label.setModifiedBy(labelUpdateRequest.getModifiedBy());
        label.setLabelName(labelUpdateRequest.getLabelName());
        Label updatedLabel = labelRepository.save(label);
        return new LabelUpdateResponse(updatedLabel);
    }

    public boolean existsLabel(String labelName) {
        // Example: Assuming you have a labelRepository or labelDao to interact with the
        // database
        return labelRepository.existsByLabelName(labelName);
    }

    private String generateUniqueID() {
        Utils utils = new Utils();
        return utils.generateRandomString(8);
    }

    public Label deleteLabel(String labelPublicId) {
        Optional<Label> labelOptional = labelRepository.findByLabelPublicId(labelPublicId);
        if (!labelOptional.isPresent()) {
            throw new LabelNotFoundException(ErrorMessages.PLEASE_PROVIDE_LABEL_ID.getErrorMessage());
        }
        Label label = labelOptional.get();
        labelRepository.delete(label);
        return label;
    }
}