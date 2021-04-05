package com.team.discovery.c3p.backend.model.c3p;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.team.discovery.c3p.backend.model.common.InspectionState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "inspection", schema = "c3p")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inspection {

    @Id
    @Column(name = "inspection_id", nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @OneToOne
    @JoinColumn(name = "client", referencedColumnName = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "employee", referencedColumnName = "employee_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "inspector", referencedColumnName = "employee_id")
    private Employee inspector;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "finish_date")
    private Date finishDate;

    @Column(name = "state")
    private String state;

    @Column(name = "novelty")
    private Boolean novelty;
}
