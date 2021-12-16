package com.sergey6ljava.concretepage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService implements ICarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public CarEntity getCarById(int carId) {
        CarEntity obj = carRepository.findByCarId(carId);
        return obj;
    }
    @Override
    public List<CarEntity> getAllCars(){
        return new ArrayList<>((Collection<? extends CarEntity>) carRepository.findAll());
    }
    @Override
    public synchronized boolean addCar(CarEntity car){
        carRepository.save(car);
        return true;

    }
    @Override
    public void updateCar(CarEntity car) {
        carRepository.save(car);
    }
    @Override
    public void deleteCar(CarEntity car) {
        carRepository.delete(car);
    }
}