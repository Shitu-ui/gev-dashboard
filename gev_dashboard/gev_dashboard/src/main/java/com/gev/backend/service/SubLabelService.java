package com.gev.backend.service;

import com.gev.backend.io.entity.SubLabel;
import com.gev.backend.ui.model.request.SubLabelCreateRequest;
import com.gev.backend.ui.model.request.SubLabelUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubLabelService {
    
    List<SubLabel> getAllSubLabels(String labelPublicId);
    
    SubLabel getSubLabelById(Long id);
    
    SubLabel createSubLabel(SubLabelCreateRequest subLabelCreateRequest);
    
    SubLabel updateSubLabel(SubLabelUpdateRequest subLabelUpdateRequest);
    
    public SubLabel deleteSubLabel(String subLabelPublicId);
}
