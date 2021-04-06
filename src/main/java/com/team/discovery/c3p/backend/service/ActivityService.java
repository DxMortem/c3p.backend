package com.team.discovery.c3p.backend.service;

import com.team.discovery.c3p.backend.model.c3p.Activity;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ActivityService {

    private final KieContainer kieContainer;

    @Autowired
    public ActivityService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public Activity getConjuntoActivity(Activity activity) {
        //get the stateful session
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.insert(activity);
        kieSession.fireAllRules();
        kieSession.dispose();
        return activity;
    }
}