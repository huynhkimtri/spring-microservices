package com.spring.cloudmicroservices.projectservice.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    @Column(nullable = false, unique = true)
    private String projectCode;
    private String description;
    private Long cost;
    private Date startDate;
    private Date endDate;
    private Long projectLeaderId;
    private Long departmentId;
}
