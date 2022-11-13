package com.dicapisar.SearchManagerAPI.repository;

import com.dicapisar.SearchManagerAPI.models.Brand;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    @Query("select b from Brand b where b.name like %:valueToSearch%")
    List<Brand> getListBrandThatContainsString(@Param("valueToSearch") String valueToSearch);
}
