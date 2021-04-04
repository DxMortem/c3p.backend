package com.team.discovery.c3p.backend.repository;

import com.team.discovery.c3p.backend.model.c3p.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
