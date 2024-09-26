package com.kdu.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "shift_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "uq_name")
    private String uqName;

    private String description;
    private boolean active;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    private String timezone;

//    @ManyToOne(fetch = FetchType.EAGER)
//    private Tenant tenant;
}
