package com.gev.backend.service;

import com.gev.backend.ui.model.request.SubLabelCreateRequest;
import com.gev.backend.ui.model.response.SubLabelCreateResponse;
import com.gev.backend.ui.model.request.SubLabelUpdateRequest;
import com.gev.backend.ui.model.response.SubLabelUpdateResponse;
import com.gev.backend.io.entity.SubLabel;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface SubLabelService {



     List<SubLabel> getAllSubLabels();

     SubLabel getSubLabelById(Long id) ;

     SubLabelCreateResponse createSubLabel(SubLabelCreateRequest subLabelCreateRequest);

     SubLabelUpdateResponse updateSubLabel(SubLabelUpdateRequest subLabelUpdateRequest);

     boolean existsLabel(Integer publicId);


    public SubLabel deleteSubLabel(String subLabelPublicId);
}
