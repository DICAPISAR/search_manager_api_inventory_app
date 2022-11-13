package com.dicapisar.SearchManagerAPI.services.serarchers;

import com.dicapisar.SearchManagerAPI.dtos.ResultDTO;
import com.dicapisar.SearchManagerAPI.models.Provider;
import com.dicapisar.SearchManagerAPI.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProviderSearcher implements Searcher{
    private ProviderRepository providerRepository;

    @Override
    public String getName() {
        return "provider";
    }

    @Override
    public List<ResultDTO> getResults(String valueToSearch) {
        List<Provider> itemList = providerRepository.getListProviderThatContainsString(valueToSearch);
        List<ResultDTO> resultDTOList = new ArrayList<>();
        itemList.forEach(provider -> resultDTOList.add(new ResultDTO(provider.getId(), provider.getName(), provider.getCreationDate(), provider.getUpdateDate())));
        return resultDTOList;
    }
}
