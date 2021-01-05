package com.example.CarDatabase.controller;

import com.example.CarDatabase.model.Car;
import com.example.CarDatabase.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Communication SERVER-CLIENT is very important in REST application so we always have to send a response back to the
//client when a request has been processed.In order to do that we have 2 basic options.The first one is to have a
//RestController which sends back response statuses to the client.The second one is to have a basic Controller but
//return a ResponseEntity back from the method with a message and a response status.
//return new ResponseEntity<String>("SucceSSFULL", HttpStatus.OK);

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @CrossOrigin
    @PostMapping("/submit")
    public void submitNewCar(@RequestPart("image") byte[] file, @RequestParam("mark") String mark,
                             @RequestParam("model") String model, @RequestParam("year") String year,
                             @RequestParam("fuel") String fuel, @RequestParam("price") String price) {

        Car myCar = new Car(mark, model, year, fuel, price, file);
        carService.saveCar(myCar);
    }

    @CrossOrigin
    @GetMapping("/getCars")
    public List<Car> getAllCars() {
        List<Car> carList = carService.getCarList();

        return carList;
    }


}
