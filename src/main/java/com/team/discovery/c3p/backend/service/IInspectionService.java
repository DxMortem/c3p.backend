package com.team.discovery.c3p.backend.service;

import com.team.discovery.c3p.backend.model.request.RequestInspection;
import com.team.discovery.c3p.backend.model.response.ResponseInspection;

public interface IInspectionService {

    String createInspection(final RequestInspection requestInspection);

    ResponseInspection finishInspection(final String inspectionId, final RequestInspection requestInspection);
}
