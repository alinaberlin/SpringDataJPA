package com.github.alinaberlin.restate.repositories;

import com.github.alinaberlin.restate.models.Property;
import com.github.alinaberlin.restate.models.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {


    // adding a search using @query annotation from https://www.baeldung.com/spring-data-jpa-null-parameters
    @Query("from Property where type = :type and " +
            "((:minArea is null or :maxArea is null) or area between :minArea and :maxArea) and " +
            "((:minPrice is null or :maxPrice is null) or price between :minPrice and :maxPrice)")
    List<Property> filterProperties(@Param("type") PropertyType type,
                                    @Param("minArea") Double minArea,
                                    @Param("maxArea") Double maxArea,
                                    @Param("minPrice") Double minPrice,
                                    @Param("maxPrice") Double maxPrice);

    List<Property> findByTypeAndAreaBetweenAndPriceBetween(PropertyType type, Double minArea, Double maxArea, Double minPrice, Double maxPrice);
}
