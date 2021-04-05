package com.team.discovery.c3p.backend.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseInspection {
    private String inspectionId;

    private boolean withNovelty;

    private boolean withImprovementAction;

}
