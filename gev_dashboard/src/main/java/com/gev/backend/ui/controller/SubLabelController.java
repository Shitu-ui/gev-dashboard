package com.gev.backend.ui.controller;

import com.gev.backend.ui.model.request.SubLabelCreateRequest;
import com.gev.backend.ui.model.request.SubLabelUpdateRequest;
import com.gev.backend.io.entity.SubLabel;
import com.gev.backend.service.SubLabelService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sub-labels")
public class SubLabelController {

	private final SubLabelService subLabelService;

	@Autowired
	public SubLabelController(SubLabelService subLabelService) {
		this.subLabelService = subLabelService;
	}

	@GetMapping
	public ResponseEntity<List<SubLabel>> getAllSubLabels() {
		return new ResponseEntity<>(subLabelService.getAllSubLabels(), HttpStatus.OK);
	}
	@PostMapping("/createSubLabel")
	public ResponseEntity<?> createSubLabel(@Valid @RequestBody @NotNull SubLabelCreateRequest subLabelCreateRequest) {
		return new ResponseEntity<>(subLabelService.createSubLabel(subLabelCreateRequest), HttpStatus.CREATED);
	}

	@PutMapping("/updateSubLabel")
	public ResponseEntity<?> updateSubLabel(@Valid @RequestBody @NotNull SubLabelUpdateRequest subLabelUpdateRequest) {
		return new ResponseEntity(subLabelService.updateSubLabel(subLabelUpdateRequest), HttpStatus.OK);
	}

	@DeleteMapping("/{subLabelPublicId}")
	public ResponseEntity<?> deleteSubLabel(@PathVariable("id") @NotNull String subLabelPublicId) {
		return new ResponseEntity<>(subLabelService.deleteSubLabel(subLabelPublicId), HttpStatus.OK);

	}
}
