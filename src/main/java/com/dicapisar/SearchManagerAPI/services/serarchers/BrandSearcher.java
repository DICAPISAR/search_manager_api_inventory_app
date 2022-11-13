package com.dicapisar.SearchManagerAPI.services.serarchers;

import com.dicapisar.SearchManagerAPI.dtos.ResultDTO;
import com.dicapisar.SearchManagerAPI.models.Brand;
import com.dicapisar.SearchManagerAPI.repository.BrandRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BrandSearcher implements Searcher{
    private BrandRepository brandRepository;

    @Override
    public String getName() {
        return "brand";
    }

    @Override
    public List<ResultDTO> getResults(String valueToSearch) {
        List<Brand> brandList = brandRepository.getListBrandThatContainsString(valueToSearch);
        List<ResultDTO> resultDTOList = new ArrayList<>();
        brandList.forEach(brand -> resultDTOList.add(new ResultDTO(brand.getId(), brand.getName(), brand.getCreationDate(), brand.getUpdateDate())));
        return resultDTOList;
    }
}
