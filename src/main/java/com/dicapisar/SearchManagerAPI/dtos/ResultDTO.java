package com.dicapisar.SearchManagerAPI.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultDTO {
    private Long id;
    private String name;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
}
