package com.kdu.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "shift_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "shift_id")
    private Shift shiftId;

    @Column(name = "user_id")
    private User userId;

    @Column(name = "tenant_id")
    private Tenant tenantId;

}
