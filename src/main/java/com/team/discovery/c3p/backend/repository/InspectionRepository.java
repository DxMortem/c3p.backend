package com.team.discovery.c3p.backend.repository;

import com.team.discovery.c3p.backend.model.c3p.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionRepository extends JpaRepository<Inspection, Integer> {
}
