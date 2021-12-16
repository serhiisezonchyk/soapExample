package com.sergey6ljava.concretepage;

import java.util.List;

public interface ICarService {
    List<CarEntity> getAllCars();
    CarEntity getCarById(int carId);
    boolean addCar(CarEntity car);
    void updateCar(CarEntity car);
    void deleteCar(CarEntity car);
}
