package com.gev.backend.bl;

import com.gev.backend.io.entity.SubLabel;
import com.gev.backend.service.SubLabelService;
import com.gev.backend.ui.model.request.SubLabelCreateRequest;
import com.gev.backend.ui.model.request.SubLabelUpdateRequest;
import com.gev.backend.ui.model.response.SubLabelCreateResponse;
import com.gev.backend.ui.model.response.SubLabelUpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubLabelClassBusinessLogic {
    
    private final SubLabelService subLabelService;
    
    @Autowired
    public SubLabelClassBusinessLogic(SubLabelService subLabelService) {
        this.subLabelService = subLabelService;
    }
    
    public ResponseEntity<SubLabelCreateResponse> createSubLabel(SubLabelCreateRequest subLabelCreateRequest) {
        SubLabel subLabel = subLabelService.createSubLabel(subLabelCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SubLabelCreateResponse(subLabel));
    }
    
    public ResponseEntity<SubLabelUpdateResponse> updateSubLabel(SubLabelUpdateRequest subLabelUpdateRequest) {
        SubLabel subLabel = subLabelService.updateSubLabel(subLabelUpdateRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new SubLabelUpdateResponse(subLabel));
    }
    
    public List<SubLabel> getAllSubLabels(String labelPublicId) {
        return subLabelService.getAllSubLabels(labelPublicId);
    }
    
    public ResponseEntity<?> deleteSubLabel(String labelPublicId) {
        return new ResponseEntity<>(subLabelService.deleteSubLabel(labelPublicId), HttpStatus.OK);
    }
    
    
}
