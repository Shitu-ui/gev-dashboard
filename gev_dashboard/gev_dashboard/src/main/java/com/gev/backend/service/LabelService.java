package com.gev.backend.service;

import com.gev.backend.io.entity.Label;
import com.gev.backend.ui.model.request.LabelCreateRequest;
import com.gev.backend.ui.model.request.LabelUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LabelService {
    
    List<Label> getAllLabels(Integer department, Integer location);
    
    Label createLabel(LabelCreateRequest labelCreateRequest);
    
    Label updateLabel(LabelUpdateRequest labelUpdateRequest);
    
    Label deleteLabel(String labelPublicId);
    
}