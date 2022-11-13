package com.dicapisar.SearchManagerAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "brands")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bra_id")
    private Long id;

    @Column(name = "bra_name", nullable = false)
    private String name;

    @Column(name = "bra_creation_date")
    private LocalDateTime creationDate;

    @Column(name = "bra_update_date")
    private LocalDateTime updateDate;

}
