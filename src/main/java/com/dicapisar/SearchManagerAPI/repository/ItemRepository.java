package com.dicapisar.SearchManagerAPI.repository;

import com.dicapisar.SearchManagerAPI.models.Item;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("select i from Item i where i.name like %:valueToSearch%")
    List<Item> getListItemThatContainsString(@Param("valueToSearch") String valueToSearch);
}
