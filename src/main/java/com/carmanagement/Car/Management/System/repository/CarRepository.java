package com.carmanagement.Car.Management.System.repository;

import com.carmanagement.Car.Management.System.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByNameContainingIgnoreCaseOrModelContainingIgnoreCaseOrYear(String name, String model, int year);


    //dynamic query to handle filters using optional parameters:
    @Query("SELECT c FROM Car c WHERE " +
            "(:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:model IS NULL OR LOWER(c.model) LIKE LOWER(CONCAT('%', :model, '%'))) AND " +
            "(:year IS NULL OR c.year = :year) AND " +
            "(:color IS NULL OR LOWER(c.color) LIKE LOWER(CONCAT('%', :color, '%'))) AND " +
            "(:fuelType IS NULL OR LOWER(c.fuelType) LIKE LOWER(CONCAT('%', :fuelType, '%')))")
    Page<Car> findAllWithFilters(@Param("name") String name,
                                 @Param("model") String model,
                                 @Param("year") Integer year,
                                 @Param("color") String color,
                                 @Param("fuelType") String fuelType,
                                 Pageable pageable);
}

