package com.dicapisar.SearchManagerAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contacts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "con_id")
    private Long id;

    @Column(name = "con_name", nullable = false)
    private String name;

    @Column(name = "con_creation_date")
    private LocalDateTime creationDate;

    @Column(name = "con_update_date")
    private LocalDateTime updateDate;

}
