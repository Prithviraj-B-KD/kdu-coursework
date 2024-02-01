package com.kdu.jpa.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name = "shifttable")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    private ShiftType shiftType;

    @Column(name="shift_name",length =128)
    private String name;

    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "time_start")
    private Timestamp timeStart;

    @Column(name = "time_end")
    private Timestamp timeEnd;

    @Column(name = "time_zone",length=32)
    private String timeZone;

//    @ManyToOne(fetch = FetchType.EAGER)
//    private Tenant tenant;
}
