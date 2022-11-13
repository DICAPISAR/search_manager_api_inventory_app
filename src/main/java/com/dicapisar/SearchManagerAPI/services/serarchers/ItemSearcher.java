package com.dicapisar.SearchManagerAPI.services.serarchers;

import com.dicapisar.SearchManagerAPI.dtos.ResultDTO;
import com.dicapisar.SearchManagerAPI.models.Item;
import com.dicapisar.SearchManagerAPI.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemSearcher implements Searcher{
    private ItemRepository itemRepository;

    @Override
    public String getName() {
        return "item";
    }

    @Override
    public List<ResultDTO> getResults(String valueToSearch) {
        List<Item> itemList = itemRepository.getListItemThatContainsString(valueToSearch);
        List<ResultDTO> resultDTOList = new ArrayList<>();
        itemList.forEach(item -> resultDTOList.add(new ResultDTO(item.getId(), item.getName(), item.getCreationDate(), item.getUpdateDate())));
        return resultDTOList;
    }
}
