package com.gev.backend.ui.controller;

import com.gev.backend.bl.FormBusinessClassLogic;
import com.gev.backend.ui.model.request.FormFrequencyUpdateRequest;
import com.gev.backend.ui.model.request.UpdateFormSubLabelRequest;
import com.gev.backend.ui.model.request.UserAccessDeleteRequest;
import com.gev.backend.ui.model.request.UserAccessUpdateRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forms")
public class FormController {
    
    private final FormBusinessClassLogic formBusinessClassLogic;
    
    @Autowired
    public FormController(FormBusinessClassLogic formBusinessClassLogic) {
        this.formBusinessClassLogic = formBusinessClassLogic;
    }
    
    @PutMapping("/update-form-frequency")
    public ResponseEntity<?> updateFormFrequency(@Valid @RequestBody @NotNull FormFrequencyUpdateRequest formFrequencyUpdateRequest) {
        return formBusinessClassLogic.updateFormFrequency(formFrequencyUpdateRequest);
    }
    
    @PutMapping("/update-user-access")
    public ResponseEntity<?> updateUserAccess(@Valid @RequestBody @NotNull UserAccessUpdateRequest userAccessUpdateRequest) {
        return formBusinessClassLogic.updateUserAccess(userAccessUpdateRequest);
    }
    
    @PutMapping("/delete-form-access")
    public ResponseEntity<?> deleteFormAccess(@Valid @RequestBody @NotNull UserAccessDeleteRequest userAccessDeleteRequest) {
        return formBusinessClassLogic.deleteFormAccess(userAccessDeleteRequest);
    }
    
    @PutMapping("/update-form-sublabel")
    public ResponseEntity<?> updateSubLabel(@Valid @RequestBody @NotNull UpdateFormSubLabelRequest updateFormSubLabelRequest) {
        return formBusinessClassLogic.updateFormSubLabel(updateFormSubLabelRequest);
    }
//    @PutMapping("/add-form-fields")
//    public ResponseEntity<?>
}
