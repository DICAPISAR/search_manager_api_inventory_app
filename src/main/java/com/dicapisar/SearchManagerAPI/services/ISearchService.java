package com.dicapisar.SearchManagerAPI.services;

import com.dicapisar.SearchManagerAPI.dtos.response.ResultResponseDTO;

public interface ISearchService {
   ResultResponseDTO getResult(String valueToSearch);
}
