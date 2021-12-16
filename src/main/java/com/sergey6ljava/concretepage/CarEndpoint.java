package com.sergey6ljava.concretepage;

import java.util.ArrayList;
import java.util.List;

import com.sergey6ljava.car.*;
import org.springframework.beans.BeanUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CarEndpoint {
    private static final String NAMESPACE_URI = "http://www.sergey6ljava.com/car";
//    @Autowired
    private final ICarService carService;

    public CarEndpoint(ICarService carService) {
        this.carService = carService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCarByIdRequest")
    @ResponsePayload
    public GetCarByIdResponse getCar(@RequestPayload GetCarByIdRequest request) {
        GetCarByIdResponse response = new GetCarByIdResponse();
        CarInfo carInfo = new CarInfo();
        BeanUtils.copyProperties(carService.getCarById(request.getCarId()), carInfo);
        response.setCarInfo(carInfo);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCarsRequest")
    @ResponsePayload
    public GetAllCarsResponse getAllCars() {
        GetAllCarsResponse response = new GetAllCarsResponse();
        List<CarInfo> carInfoList = new ArrayList<>();
        List<CarEntity> carList = carService.getAllCars();
        for (int i = 0; i < carList.size(); i++) {
            CarInfo ob = new CarInfo();
            BeanUtils.copyProperties(carList.get(i), ob);
            carInfoList.add(ob);
        }
        response.getCarInfo().addAll(carInfoList);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCarRequest")
    @ResponsePayload
    public AddCarResponse addCar(@RequestPayload AddCarRequest request) {
        AddCarResponse response = new AddCarResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        CarEntity car = new CarEntity();
        car.setComplectation(request.getComplectation());
        car.setEngine(request.getEngine());
        car.setModel(request.getModel());
        car.setName(request.getName());
        car.setPrice(request.getPrice());
        car.setQuantity(request.getQuantity());
        car.setYear(request.getYear());
        boolean flag = carService.addCar(car);
        if (flag == false) {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Content Already Available");
            response.setServiceStatus(serviceStatus);
        } else {
            CarInfo carInfo = new CarInfo();
            BeanUtils.copyProperties(car, carInfo);
            response.setCarInfo(carInfo);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Added Successfully");
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCarRequest")
    @ResponsePayload
    public UpdateCarResponse updateCar(@RequestPayload UpdateCarRequest request) {
        CarEntity car = new CarEntity();
        BeanUtils.copyProperties(request.getCarInfo(), car);
        carService.updateCar(car);
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatusCode("SUCCESS");
        serviceStatus.setMessage("Content Updated Successfully");
        UpdateCarResponse response = new UpdateCarResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCarRequest")
    @ResponsePayload
    public DeleteCarResponse deleteCar(@RequestPayload DeleteCarRequest request) {
        CarEntity car = carService.getCarById(request.getCarId());
        ServiceStatus serviceStatus = new ServiceStatus();
        if (car == null ) {
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Content Not Available");
        } else {
            carService.deleteCar(car);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Deleted Successfully");
        }
        DeleteCarResponse response = new DeleteCarResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }
}