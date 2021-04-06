package com.team.discovery.c3p.backend.controller;

import com.team.discovery.c3p.backend.model.c3p.Activity;
import com.team.discovery.c3p.backend.model.request.RequestInspection;
import com.team.discovery.c3p.backend.model.response.ResponseInspection;
import com.team.discovery.c3p.backend.service.ActivityService;
import com.team.discovery.c3p.backend.service.IInspectionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/inspection")
public class InspectionController {

    private final IInspectionService inspectionService;
    private ActivityService activityService;

    public void JewelleryShopController(ActivityService activityService) {
        this.activityService = activityService;
    }

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

    @GetMapping("/getActivity/{conjunto}")
    public Activity getQuestions(@PathVariable(required = true) String conjunto) {
        Activity activity = new Activity();
        activity.setName(conjunto);
        activityService.getConjuntoActivity(activity);
        return activity;
    }
}
