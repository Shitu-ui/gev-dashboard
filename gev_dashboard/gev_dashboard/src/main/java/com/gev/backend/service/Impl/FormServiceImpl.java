package com.gev.backend.service.Impl;

import com.gev.backend.exceptions.ErrorMessages;
import com.gev.backend.io.entity.Form;
import com.gev.backend.io.entity.FormAccess;
import com.gev.backend.io.entity.Frequency;
import com.gev.backend.io.entity.SubLabel;
import com.gev.backend.io.repository.FormAccessRepository;
import com.gev.backend.io.repository.FormRepository;
import com.gev.backend.io.repository.FrequencyRepository;
import com.gev.backend.io.repository.SubLabelRepository;
import com.gev.backend.service.FormService;
import com.gev.backend.ui.model.request.FormFrequencyUpdateRequest;
import com.gev.backend.ui.model.request.UpdateFormSubLabelRequest;
import com.gev.backend.ui.model.request.UserAccessDeleteRequest;
import com.gev.backend.ui.model.request.UserAccessUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class FormServiceImpl implements FormService {
    
    private final FormAccessRepository formAccessRepository;
    
    private final FrequencyRepository frequencyRepository;
    
    private final SubLabelRepository subLabelRepository;
    
    private final FormRepository formRepository;
    
    @Autowired
    public FormServiceImpl(FormAccessRepository formAccessRepository, FrequencyRepository frequencyRepository, FormRepository formRepository, SubLabelRepository subLabelRepository) {
        this.formAccessRepository = formAccessRepository;
        this.frequencyRepository = frequencyRepository;
        this.formRepository = formRepository;
        this.subLabelRepository = subLabelRepository;
    }
    
    @Override
    public void updateFormFrequency(FormFrequencyUpdateRequest formFrequencyUpdateRequest) {
        String formAccessPublicId = formFrequencyUpdateRequest.getFormAccessPublicId();
        String frequencyPublicId = formFrequencyUpdateRequest.getFrequencyPublicId();
        Optional<FormAccess> formAccessOptional = formAccessRepository.findByFormAccessPublicId(formAccessPublicId);
        if (!formAccessOptional.isPresent())
            throw new RuntimeException(ErrorMessages.FORM_WITH_GIVEN_ID_DOES_NOT_EXISTS.getErrorMessage());
        Optional<Frequency> frequencyOptional = frequencyRepository.findByFrequencyPublicId(frequencyPublicId);
        if (!frequencyOptional.isPresent())
            throw new RuntimeException(ErrorMessages.FREQUENCY_WITH_GIVEN_ID_DOES_NOT_EXISTS.getErrorMessage());
        FormAccess formAccess = formAccessOptional.get();
        formAccess.setModifiedBy(formFrequencyUpdateRequest.getModifiedBy());
        formAccess.setFrequency(frequencyOptional.get());
        formAccessRepository.save(formAccess);
    }
    
    private void updateAccess(FormAccess formAccess, UserAccessUpdateRequest userAccessUpdateRequest) {
        formAccess.setDeleteAccess(userAccessUpdateRequest.getDeleteAccess());
        formAccess.setFillAccess(userAccessUpdateRequest.getFillAccess());
        formAccess.setUpdateAccess(userAccessUpdateRequest.getUpdateAccess());
    }
    
    @Override
    public void updateUserAccess(UserAccessUpdateRequest userAccessUpdateRequest) {
        String formAccessPublicId = userAccessUpdateRequest.getFormAccessPublicId();
        Optional<FormAccess> formAccessOptional = formAccessRepository.findByFormAccessPublicId(formAccessPublicId);
        if (!formAccessOptional.isPresent())
            throw new RuntimeException(ErrorMessages.FORM_WITH_GIVEN_ID_DOES_NOT_EXISTS.getErrorMessage());
        FormAccess formAccess = formAccessOptional.get();
        updateAccess(formAccess, userAccessUpdateRequest);
    }
    
    @Override
    public void deleteFormAccess(UserAccessDeleteRequest userAccessDeleteRequest) {
        String formAccessPublicId = userAccessDeleteRequest.getFormAccessPublicId();
        Optional<FormAccess> formAccessOptional = formAccessRepository.findByFormAccessPublicId(formAccessPublicId);
        if (!formAccessOptional.isPresent())
            throw new RuntimeException(ErrorMessages.FORM_WITH_GIVEN_ID_DOES_NOT_EXISTS.getErrorMessage());
        FormAccess formAccess = formAccessOptional.get();
        formAccess.setMarkForDelete(true);
        formAccess.setModifiedBy(userAccessDeleteRequest.getModifiedBy());
    }
    
    @Override
    public void updateFormSubLabel(UpdateFormSubLabelRequest updateFormSubLabelRequest) {
        String formPublicId = updateFormSubLabelRequest.getFormPublicId();
        Optional<Form> formOptional = formRepository.findByFormPublicId(formPublicId);
        if (!formOptional.isPresent())
            throw new RuntimeException(ErrorMessages.FORM_WITH_GIVEN_ID_DOES_NOT_EXISTS.getErrorMessage());
        Form form = formOptional.get();
        Integer subLabelId = updateFormSubLabelRequest.getSubLabelId();
        Optional<SubLabel> subLabelOptional = subLabelRepository.findBySubLabelId(subLabelId);
        if (!subLabelOptional.isPresent())
            throw new RuntimeException(ErrorMessages.PLEASE_PROVIDE_VALID_ID.getErrorMessage());
        form.setSubLabelId(subLabelId);
        form.setModifiedBy(updateFormSubLabelRequest.getModifiedBy());
    }
//    @Override
//    public void addFormFields(AddFormFieldsRequest addFormFieldsRequest){
//        String formPublicId = addFormFieldsRequest.getFormPublicId();
//
//    }
    
}
