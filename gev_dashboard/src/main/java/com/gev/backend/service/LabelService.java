package com.gev.backend.service;


import com.gev.backend.ui.model.request.LabelCreateRequest;
import com.gev.backend.ui.model.response.LabelCreateResponse;
import com.gev.backend.ui.model.request.LabelUpdateRequest;
import com.gev.backend.ui.model.response.LabelUpdateResponse;
import com.gev.backend.io.entity.Label;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LabelService {


    List<Label> getAllLabels();

    LabelCreateResponse createLabel( LabelCreateRequest labelCreateRequest);
     LabelUpdateResponse updateLabel(LabelUpdateRequest labelUpdateRequest);
     boolean existsLabel(String labelName);
     Label deleteLabel(String labelPublicId);

}