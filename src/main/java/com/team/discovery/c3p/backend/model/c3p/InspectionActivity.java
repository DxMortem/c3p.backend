package com.team.discovery.c3p.backend.model.c3p;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "inspection_activity", schema = "c3p")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InspectionActivity {

    @Id
    @Column(name = "inspection_activity_id", nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @OneToOne
    @JoinColumn(name = "inspection_id", referencedColumnName = "inspection_id")
    private Inspection inspectionId;

    @OneToOne
    @JoinColumn(name = "activity_id", referencedColumnName = "activity_id")
    private Activity activityId;

    @Column(name = "improvement_action", nullable = false)
    private Boolean improvementAction;

    @Column(name = "comments", nullable = false)
    private String comments;
}
