package com.example.CarDatabase.controller;

import com.example.CarDatabase.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/cars")
public class CarController {

    @PostMapping("/submit")
    public void submitNewCar(@RequestParam("image")MultipartFile file, @RequestParam("mark") String mark,
                             @RequestParam("model")String model,@RequestParam("year")String year,
                             @RequestParam("fuel")String fuel,@RequestParam("price")String price){


        Car myCar = new Car(mark,model,year,fuel,price,file);
        System.out.println(myCar.getFuel());
        System.out.println(myCar.getMark());
        System.out.println(myCar.getModel());

    }

}
