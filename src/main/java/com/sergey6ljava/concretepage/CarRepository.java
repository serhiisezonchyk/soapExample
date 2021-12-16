package com.sergey6ljava.concretepage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<CarEntity, Integer> {
    CarEntity findByCarId(int carId);
}