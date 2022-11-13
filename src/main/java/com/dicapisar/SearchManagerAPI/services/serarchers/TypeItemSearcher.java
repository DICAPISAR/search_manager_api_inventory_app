package com.dicapisar.SearchManagerAPI.services.serarchers;

import com.dicapisar.SearchManagerAPI.dtos.ResultDTO;
import com.dicapisar.SearchManagerAPI.models.TypeItem;
import com.dicapisar.SearchManagerAPI.repository.TypeItemRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TypeItemSearcher implements Searcher{
    private TypeItemRepository typeItemRepository;

    @Override
    public String getName() {
        return "type_item";
    }

    @Override
    public List<ResultDTO> getResults(String valueToSearch) {
        List<TypeItem> itemList = typeItemRepository.getListTypeItemThatContainsString(valueToSearch);
        List<ResultDTO> resultDTOList = new ArrayList<>();
        itemList.forEach(typeItem -> resultDTOList.add(new ResultDTO(typeItem.getId(), typeItem.getName(), typeItem.getCreationDate(), typeItem.getUpdateDate())));
        return resultDTOList;
    }
}
