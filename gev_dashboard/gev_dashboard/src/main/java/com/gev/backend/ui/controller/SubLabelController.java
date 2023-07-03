package com.gev.backend.ui.controller;

import com.gev.backend.bl.SubLabelClassBusinessLogic;
import com.gev.backend.io.entity.SubLabel;
import com.gev.backend.ui.model.request.SubLabelCreateRequest;
import com.gev.backend.ui.model.request.SubLabelUpdateRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sub-labels")
/**
 * This controller handles the operations performed on SubLabel.
 */
public class SubLabelController {
    
    private final SubLabelClassBusinessLogic subLabelClassBusinessLogic;
    
    @Autowired
    public SubLabelController(SubLabelClassBusinessLogic subLabelClassBusinessLogic) {
        this.subLabelClassBusinessLogic = subLabelClassBusinessLogic;
    }
    
    /*
     *
     * @return : Response entity containing the list of all SubLabels
     */
    @GetMapping("/getSublabels/{labelPublicId")
    public List<SubLabel> getAllSubLabels(@PathVariable @NotNull String labelPublicId ) {
        return subLabelClassBusinessLogic.getAllSubLabels(labelPublicId);
    }
    
    /**
     * @param subLabelCreateRequest
     * @return : Response entity containing the subLabel created with status code CREATED
     */
    @PostMapping("/createSubLabel")
    public ResponseEntity<?> createSubLabel(@Valid @RequestBody @NotNull SubLabelCreateRequest subLabelCreateRequest) {
        return subLabelClassBusinessLogic.createSubLabel(subLabelCreateRequest);
    }
    
    /**
     * @param subLabelUpdateRequest
     * @return : Response entity containing the subLabel updated with status code 200
     */
    @PutMapping("/updateSubLabel")
    public ResponseEntity<?> updateSubLabel(@Valid @RequestBody @NotNull SubLabelUpdateRequest subLabelUpdateRequest) {
        return subLabelClassBusinessLogic.updateSubLabel(subLabelUpdateRequest);
    }
    
    /**
     * @param subLabelPublicId
     * @return : Response entity with status code 200.
     */
    @DeleteMapping("/deleteSubLabel/{subLabelPublicId}")
    public ResponseEntity<?> deleteSubLabel(@PathVariable @NotNull String subLabelPublicId) {
        return subLabelClassBusinessLogic.deleteSubLabel(subLabelPublicId);
    }
}
