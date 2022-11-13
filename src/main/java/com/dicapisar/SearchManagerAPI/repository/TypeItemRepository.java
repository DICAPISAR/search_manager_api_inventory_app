package com.dicapisar.SearchManagerAPI.repository;

import com.dicapisar.SearchManagerAPI.models.TypeItem;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeItemRepository extends JpaRepository<TypeItem, Long> {

    @Query("select t from TypeItem t where t.name like %:valueToSearch%")
    List<TypeItem> getListTypeItemThatContainsString(@Param("valueToSearch") String valueToSearch);
}
