package com.gev.backend.bl;

import com.gev.backend.service.FormService;
import com.gev.backend.ui.model.request.FormFrequencyUpdateRequest;
import com.gev.backend.ui.model.request.UpdateFormSubLabelRequest;
import com.gev.backend.ui.model.request.UserAccessDeleteRequest;
import com.gev.backend.ui.model.request.UserAccessUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class FormBusinessClassLogic {
    
    private final FormService formService;
    
    @Autowired
    public FormBusinessClassLogic(FormService formService) {
        this.formService = formService;
        
    }
    
    public ResponseEntity<?> updateFormFrequency(FormFrequencyUpdateRequest formFrequencyUpdateRequest) {
        formService.updateFormFrequency(formFrequencyUpdateRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Updated the form frequency successfully");
    }
    
    public ResponseEntity<?> updateUserAccess(UserAccessUpdateRequest userAccessUpdateRequest) {
        formService.updateUserAccess(userAccessUpdateRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Updated the user access successfully");
    }
    
    public ResponseEntity<?> deleteFormAccess(UserAccessDeleteRequest userAccessDeleteRequest) {
        formService.deleteFormAccess(userAccessDeleteRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted the form access information successfully");
    }
    
    public ResponseEntity<?> updateFormSubLabel(UpdateFormSubLabelRequest updateFormSubLabelRequest) {
        formService.updateFormSubLabel(updateFormSubLabelRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Updated the subLabel for the given form successfully");
        
        
    }
}
