package com.dicapisar.SearchManagerAPI.services;

import com.dicapisar.SearchManagerAPI.dtos.ResultDTO;
import com.dicapisar.SearchManagerAPI.dtos.response.ResultResponseDTO;
import com.dicapisar.SearchManagerAPI.repository.BrandRepository;
import com.dicapisar.SearchManagerAPI.repository.ItemRepository;
import com.dicapisar.SearchManagerAPI.repository.ProviderRepository;
import com.dicapisar.SearchManagerAPI.repository.TypeItemRepository;
import com.dicapisar.SearchManagerAPI.services.serarchers.*;
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

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private TypeItemRepository typeItemRepository;

    private String brandSearcher = "brandSearcher";
    private String itemSearcher = "itemSearcher";
    private String providerSearcher = "providerSearcher";
    private String typeItemSearcher = "typeItemSearcher";

    private Map<String, Searcher> getSearchers() {
        Map<String, Searcher> searcherMap = new HashMap<>();

        searcherMap.put(brandSearcher, new BrandSearcher(brandRepository));
        searcherMap.put(itemSearcher, new ItemSearcher(itemRepository));
        searcherMap.put(providerSearcher, new ProviderSearcher(providerRepository));
        searcherMap.put(typeItemSearcher, new TypeItemSearcher(typeItemRepository));

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
