package com.gev.backend.bl;

import com.gev.backend.io.entity.Label;
import com.gev.backend.service.LabelService;
import com.gev.backend.ui.model.request.LabelCreateRequest;
import com.gev.backend.ui.model.request.LabelUpdateRequest;
import com.gev.backend.ui.model.response.LabelCreateResponse;
import com.gev.backend.ui.model.response.LabelUpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LabelClassBusinessLogic {
    
    private final LabelService labelService;
    
    @Autowired
    public LabelClassBusinessLogic(LabelService labelService) {
        this.labelService = labelService;
    }
    
    public ResponseEntity<LabelCreateResponse> createLabel(LabelCreateRequest labelCreateRequest) {
        Label labelCreated = labelService.createLabel(labelCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new LabelCreateResponse(labelCreated));
        
    }
    
    public ResponseEntity<LabelUpdateResponse> updateLabel(LabelUpdateRequest labelUpdateRequest) {
        Label labelUpdated = labelService.updateLabel(labelUpdateRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new LabelUpdateResponse(labelUpdated));
    }
    
    public List<Label> getAllLabels(Integer department, Integer location) {
        return labelService.getAllLabels(department, location);
    }
    
    public ResponseEntity<?> deleteLabel(String labelPublicId) {
        return new ResponseEntity<>(labelService.deleteLabel(labelPublicId), HttpStatus.OK);
    }
    
}
