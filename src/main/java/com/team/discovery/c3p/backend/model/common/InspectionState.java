package com.team.discovery.c3p.backend.model.common;

import lombok.Getter;

@Getter
public enum InspectionState {
    IN_PROGRESS("IN_PROGRESS"),
    FINISHED("FINISHED");

    private final String state;

    InspectionState(final String state){
        this.state = state;
    }
}
