package com.gev.backend.service;

import com.gev.backend.ui.model.request.FormFrequencyUpdateRequest;
import com.gev.backend.ui.model.request.UpdateFormSubLabelRequest;
import com.gev.backend.ui.model.request.UserAccessDeleteRequest;
import com.gev.backend.ui.model.request.UserAccessUpdateRequest;

public interface FormService {
    
    void updateFormFrequency(FormFrequencyUpdateRequest formFrequencyUpdateRequest);
    
    void updateUserAccess(UserAccessUpdateRequest userAccessUpdateRequest);
    
    void deleteFormAccess(UserAccessDeleteRequest userAccessDeleteRequest);
    
    void updateFormSubLabel(UpdateFormSubLabelRequest updateFormSubLabelRequest);
//    public void addFormFields(AddFormFieldsRequest addFormFieldsRequest);
}
