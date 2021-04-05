package com.team.discovery.c3p.backend.service.impl;

import static java.util.Date.from;

import java.time.Instant;
import java.util.stream.Collectors;

import com.team.discovery.c3p.backend.model.c3p.Client;
import com.team.discovery.c3p.backend.model.c3p.Employee;
import com.team.discovery.c3p.backend.model.c3p.Inspection;
import com.team.discovery.c3p.backend.model.c3p.InspectionActivity;
import com.team.discovery.c3p.backend.model.common.InspectionState;
import com.team.discovery.c3p.backend.model.request.InspectionActivityRequest;
import com.team.discovery.c3p.backend.model.request.RequestInspection;
import com.team.discovery.c3p.backend.model.response.ResponseInspection;
import com.team.discovery.c3p.backend.repository.ActivityRepository;
import com.team.discovery.c3p.backend.repository.ClientRepository;
import com.team.discovery.c3p.backend.repository.EmployeeRepository;
import com.team.discovery.c3p.backend.repository.InspectionActivityRepository;
import com.team.discovery.c3p.backend.repository.InspectionRepository;
import com.team.discovery.c3p.backend.service.IInspectionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InspectionService implements IInspectionService {

    ClientRepository clientRepository;

    EmployeeRepository employeeRepository;

    InspectionRepository inspectionRepository;

    InspectionActivityRepository inspectionActivityRepository;

    ActivityRepository activityRepository;

    @Override
    public String createInspection(final RequestInspection requestInspection) {
        Client client = clientRepository.getOne(requestInspection.getClientId());
        Employee employee = employeeRepository.getOne(requestInspection.getEmployeeId());
        Employee inspector = employeeRepository.getOne(requestInspection.getInspectorId());
        Inspection inspection = Inspection.builder()
                .client(client)
                .employee(employee)
                .inspector(inspector)
                .startDate(from(Instant.now()))
                .state(InspectionState.IN_PROGRESS.getState())
                .build();
        inspection = inspectionRepository.save(inspection);
        return inspection.getId();
    }

    @Override
    public ResponseInspection finishInspection(final String inspectionId, final RequestInspection requestInspection) {
        Inspection inspection = inspectionRepository.getOne(inspectionId);
        inspection.setFinishDate(from(Instant.now()));
        inspection.setNovelty(requestInspection.isWithNovelty());
        inspection.setState(InspectionState.FINISHED.getState());
        inspectionRepository.save(inspection);

        requestInspection.getInspectionActivityList().forEach(inspectionActivity -> inspectionActivityRepository.save(InspectionActivity.builder()
                .inspectionId(inspection)
                .activityId(activityRepository.getOne(inspectionActivity.getActivityId()))
                .improvementAction(inspectionActivity.isImprovementAction())
                .comments(inspectionActivity.getComments())
                .build())
        );

        return ResponseInspection.builder()
                .inspectionId(inspectionId)
                .withNovelty(requestInspection.isWithNovelty())
                .withImprovementAction(requestInspection.getInspectionActivityList().stream().anyMatch(InspectionActivityRequest::isImprovementAction))
                .build();
    }
}
