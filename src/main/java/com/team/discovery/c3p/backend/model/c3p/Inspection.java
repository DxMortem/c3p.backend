package com.team.discovery.c3p.backend.model.c3p;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.team.discovery.c3p.backend.model.common.InspectionState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inspection", schema = "c3p")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inspection {

    @Id
    @Column(name = "inspection_id", nullable = false)
    private Integer id;

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
    private InspectionState state;

    @Column(name = "novelty")
    private Boolean novelty;
}
