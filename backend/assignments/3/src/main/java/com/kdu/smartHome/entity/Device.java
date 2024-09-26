package com.kdu.smartHome.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Data
@Table(name = "devices")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String kickstonId;
    private String deviceUsername;
    private String devicePassword;
}
