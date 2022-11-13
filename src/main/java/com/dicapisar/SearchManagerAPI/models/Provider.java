package com.dicapisar.SearchManagerAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "providers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private Long id;

    @Column(name = "pro_name", nullable = false)
    private String name;

    @Column(name = "pro_creation_date")
    private LocalDateTime creationDate;

    @Column(name = "pro_update_date")
    private LocalDateTime updateDate;

}
