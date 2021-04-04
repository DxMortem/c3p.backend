package com.team.discovery.c3p.backend.repository;

import com.team.discovery.c3p.backend.model.c3p.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
