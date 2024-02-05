package com.kdu.smartHome.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String houseName;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    Users admin;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Users> usersList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    List<Room> rooms = new ArrayList<>();


}
