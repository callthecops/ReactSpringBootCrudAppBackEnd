package com.example.CarDatabase.controller;

import com.example.CarDatabase.model.Car;
import com.example.CarDatabase.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/submit")
    public void submitNewCar(@RequestPart("image")byte[] file, @RequestParam("mark") String mark,
                             @RequestParam("model")String model,@RequestParam("year")String year,
                             @RequestParam("fuel")String fuel,@RequestParam("price")String price){

        Car myCar = new Car(mark,model,year,fuel,price,file);
        carService.saveCar(myCar);

    }

}
