package com.dicapisar.SearchManagerAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "types_item")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TypeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typ_ite_id")
    private Long id;

    @Column(name = "typ_ite_name", nullable = false)
    private String name;

    @Column(name = "typ_ite_creation_date")
    private LocalDateTime creationDate;

    @Column(name = "typ_ite_update_date")
    private LocalDateTime updateDate;

}
