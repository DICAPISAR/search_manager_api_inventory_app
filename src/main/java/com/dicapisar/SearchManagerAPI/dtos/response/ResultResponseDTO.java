package com.dicapisar.SearchManagerAPI.dtos.response;

import com.dicapisar.SearchManagerAPI.dtos.ResultDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultResponseDTO {
    private Map<String, List<ResultDTO>> result;
}
