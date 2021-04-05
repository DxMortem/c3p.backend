package com.team.discovery.c3p.backend.model.request;

import lombok.Data;

@Data
public class InspectionActivityRequest {
    private int activityId;
    private boolean improvementAction;
    private String comments;
}
