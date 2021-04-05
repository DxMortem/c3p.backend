package com.team.discovery.c3p.backend.controller;

import com.team.discovery.c3p.backend.model.request.RequestInspection;
import com.team.discovery.c3p.backend.model.response.ResponseInspection;
import com.team.discovery.c3p.backend.service.IInspectionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/inspection")
public class InspectionController {

    private final IInspectionService inspectionService;

    @PostMapping("/create")
    public ResponseEntity<String> createInspection(@RequestBody final RequestInspection requestInspection) {
        log.info("Creating Inspection for clientId {}, inspectorId {}",
                requestInspection.getClientId(), requestInspection.getInspectorId());
        return ResponseEntity.ok(inspectionService.createInspection(requestInspection));
    }

    @PutMapping("/{inspectionId}")
        public ResponseEntity<ResponseInspection> finishInspection(@PathVariable final String inspectionId, @RequestBody final RequestInspection requestInspection){
        log.info("Finishing Inspection id {}", inspectionId);
        return ResponseEntity.ok(inspectionService.finishInspection(inspectionId, requestInspection));
    }

}
