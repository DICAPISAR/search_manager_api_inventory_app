package com.dicapisar.SearchManagerAPI.repository;

import com.dicapisar.SearchManagerAPI.models.Provider;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

    @Query("select p from Provider p where p.name like %:valueToSearch%")
    List<Provider> getListProviderThatContainsString(@Param("valueToSearch") String valueToSearch);
}
