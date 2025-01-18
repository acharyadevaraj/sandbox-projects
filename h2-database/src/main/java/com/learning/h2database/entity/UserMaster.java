package com.learning.h2database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USER_MASTER")
public class UserMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_MASTER_SEQ")
    @SequenceGenerator(name = "USER_MASTER_SEQ", sequenceName = "USER_MASTER_SEQ", allocationSize = 1)
    private long id;
    private String name;
    private String address;
    private String email;
    private long phone;
}
