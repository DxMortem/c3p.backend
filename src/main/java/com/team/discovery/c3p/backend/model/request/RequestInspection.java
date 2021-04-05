package com.team.discovery.c3p.backend.model.request;

import java.util.List;

import lombok.Data;

@Data
public class RequestInspection {

    private int clientId;

    private int employeeId;

    private int inspectorId;

    private boolean withNovelty;

    private List<InspectionActivityRequest> inspectionActivityList;
}
