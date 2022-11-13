package com.dicapisar.SearchManagerAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "items")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ite_id")
    private Long id;

    @Column(name = "ite_name", nullable = false)
    private String name;

    @Column(name = "ite_creation_date")
    private LocalDateTime creationDate;

    @Column(name = "ite_update_date")
    private LocalDateTime updateDate;

}
