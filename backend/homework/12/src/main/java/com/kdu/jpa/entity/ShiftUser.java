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

    @ManyToOne(fetch = FetchType.EAGER)
    private Shift shiftId;

    @ManyToOne(fetch = FetchType.EAGER)
    private User userId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Tenant tenantId;

}
