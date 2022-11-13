package com.dicapisar.SearchManagerAPI.services.serarchers;

import com.dicapisar.SearchManagerAPI.dtos.ResultDTO;

import java.util.List;

public interface Searcher {
    String getName();
    List<ResultDTO> getResults(String valueToSearch);
}
