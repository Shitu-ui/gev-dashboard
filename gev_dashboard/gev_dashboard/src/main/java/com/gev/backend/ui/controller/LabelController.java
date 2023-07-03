package com.gev.backend.ui.controller;

import com.gev.backend.bl.LabelClassBusinessLogic;
import com.gev.backend.io.entity.Label;
import com.gev.backend.ui.model.request.LabelCreateRequest;
import com.gev.backend.ui.model.request.LabelUpdateRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/labels")
/**
 * This controller handles the operations performed on label.
 */
public class LabelController {
    
    private final LabelClassBusinessLogic labelClassBusinessLogic;
    
    @Autowired
    public LabelController(LabelClassBusinessLogic labelClassBusinessLogic) {
        this.labelClassBusinessLogic = labelClassBusinessLogic;
    }
    
    /**
     * @return : Returns the list of labels
     */
    @GetMapping("/getLabels/{department}/{location}")
    public List<Label> getAllLabels(@PathVariable @NotNull  Integer department, @PathVariable @NotNull Integer location) {
        return labelClassBusinessLogic.getAllLabels(department, location);
    }
    
    /**
     * @param labelCreateRequest
     * @return : response entity containing the labelCreateResponse with Status CREATED.
     */
    @PostMapping("/createLabel")
    public ResponseEntity<?> createLabel(@Valid @RequestBody @NotNull LabelCreateRequest labelCreateRequest) {
        return labelClassBusinessLogic.createLabel(labelCreateRequest);
    }
    
    /**
     * @param labelUpdateRequest
     * @return : response entity containing the labelUpdateRequest with Status OK
     */
    @PutMapping("/updateLabel")
    public ResponseEntity<?> updateLabel(@Valid @RequestBody @NotNull LabelUpdateRequest labelUpdateRequest) {
        return labelClassBusinessLogic.updateLabel(labelUpdateRequest);
    }
    
    /**
     * @param labelPublicId
     * @return : Response entity with the status code OK
     */
    @DeleteMapping("/deleteLabel/{labelPublicId}")
    public ResponseEntity<?> deleteLabel(@PathVariable @NotNull String labelPublicId) {
        return labelClassBusinessLogic.deleteLabel(labelPublicId);
    }
}