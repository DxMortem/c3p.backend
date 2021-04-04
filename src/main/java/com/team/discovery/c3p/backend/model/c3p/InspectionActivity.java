package com.team.discovery.c3p.backend.model.c3p;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inspection_activity", schema = "c3p")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InspectionActivity {

    @Id
    @Column(name = "inspection_activity_id", nullable = false)
    private String id;

    @OneToOne
    @JoinColumn(name = "inspection_id", referencedColumnName = "inspection_id")
    private Inspection inspectionId;

    @OneToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "activity_id")
    private Activity activityId;

    @Column(name = "novelty", nullable = false)
    private Boolean novelty;

    @Column(name = "comments", nullable = false)
    private String comments;
}
