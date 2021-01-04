package com.example.CarDatabase.service;

import com.example.CarDatabase.model.Car;
import com.example.CarDatabase.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;


    public void saveCar(Car car){
       carRepository.save(car);
    }

    public Car getCar(Long id){
        return carRepository.findById(id).orElse(null);
    }

    public List<Car> getCarList(){
        List<Car> carList = new ArrayList<>();
        Iterable<Car> iterable =  carRepository.findAll();
        for(Car car : iterable){
            carList.add(car);
        }
        return carList;
    }

    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }


}
