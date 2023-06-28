package com.gev.backend.ui.controller;

import com.gev.backend.ui.model.request.LabelCreateRequest;
import com.gev.backend.ui.model.request.LabelUpdateRequest;
import com.gev.backend.io.entity.Label;
import com.gev.backend.service.LabelService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/labels")
public class LabelController {

    private final LabelService labelService;

    @Autowired
    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @GetMapping("/getLabels")
    public List<Label> getAllLabels() {
        return labelService.getAllLabels();
    }

    @PostMapping("/createLabel")
    public ResponseEntity<?> createLabel(@Valid @RequestBody @NotNull LabelCreateRequest labelCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(labelService.createLabel(labelCreateRequest));
    }

    @PutMapping("/updateLabel")
    public ResponseEntity<?> updateLabel(@Valid @RequestBody @NotNull LabelUpdateRequest labelUpdateRequest) {
        return new ResponseEntity<>(labelService.updateLabel(labelUpdateRequest), HttpStatus.OK);
    }

    @DeleteMapping("/deleteLabel/{labelPublicId}")
    public ResponseEntity<?> deleteLabel(@PathVariable String labelPublicId) {
            return new ResponseEntity<>(labelService.deleteLabel(labelPublicId), HttpStatus.OK);
    }
}