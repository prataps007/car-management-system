package com.carmanagement.Car.Management.System.service;

import com.carmanagement.Car.Management.System.entity.Car;
import com.carmanagement.Car.Management.System.exception.ResourceNotFoundException;
import com.carmanagement.Car.Management.System.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    // get cars with or without filters
    public Page<Car> getAllCarsWithFilters(String name, String model, Integer year, String color, String fuelType, Pageable pageable) {
        return carRepository.findAllWithFilters(name, model, year, color, fuelType, pageable);
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    // update car
    public Car updateCar(Long id, Car carDetails) {
        Car car = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car","car id", id));

        // Update only if a field is provided
        if (carDetails.getName() != null && !carDetails.getName().isEmpty()) {
            car.setName(carDetails.getName());
        }
        if (carDetails.getModel() != null && !carDetails.getModel().isEmpty()) {
            car.setModel(carDetails.getModel());
        }
        if (carDetails.getYear() > 0) {
            car.setYear(carDetails.getYear());
        }
        if (carDetails.getPrice() > 0) {
            car.setPrice(carDetails.getPrice());
        }
        if (carDetails.getColor() != null && !carDetails.getColor().isEmpty()) {
            car.setColor(carDetails.getColor());
        }
        if (carDetails.getFuelType() != null && !carDetails.getFuelType().isEmpty()) {
            car.setFuelType(carDetails.getFuelType());
        }

        return carRepository.save(car);
    }


    // delete car
    public void deleteCar(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car","car id", id));
        carRepository.deleteById(id);
    }

}

