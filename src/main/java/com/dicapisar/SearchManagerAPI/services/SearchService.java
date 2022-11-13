package com.dicapisar.SearchManagerAPI.services;

import com.dicapisar.SearchManagerAPI.dtos.ResultDTO;
import com.dicapisar.SearchManagerAPI.dtos.response.ResultResponseDTO;
import com.dicapisar.SearchManagerAPI.repository.BrandRepository;
import com.dicapisar.SearchManagerAPI.services.serarchers.BrandSearcher;
import com.dicapisar.SearchManagerAPI.services.serarchers.Searcher;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SearchService implements ISearchService{

    @Autowired
    private BrandRepository brandRepository;

    private String brandSearcher = "brandSearcher";

    private Map<String, Searcher> getSearchers() {
        Map<String, Searcher> searcherMap = new HashMap<>();
        searcherMap.put(brandSearcher, new BrandSearcher(brandRepository));

        return searcherMap;
    }


    public ResultResponseDTO getResult(String valueToSearch) {
        Map<String, Searcher> searcherMap = this.getSearchers();
        ResultResponseDTO resultResponseDTO = new ResultResponseDTO();
        Map<String, List<ResultDTO>> result = new HashMap<>();
        for (Map.Entry<String, Searcher> searcher : searcherMap.entrySet()) {
            String searcherName = searcher.getValue().getName();
            result.put(searcherName, searcher.getValue().getResults(valueToSearch));
        }
        resultResponseDTO.setResult(result);
        return resultResponseDTO;
    }

}
