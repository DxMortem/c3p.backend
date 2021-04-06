package com.team.discovery.c3p.backend.model.c3p;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activity", schema = "c3p")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    @Id
    @Column(name = "activity_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;
}
