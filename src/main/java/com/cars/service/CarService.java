package com.cars.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cars.models.Car;

@Service
public class CarService {
	public List<Car> getAllCars() {
		List<Car> CarList = new ArrayList<>();
		
		BufferedReader fileReader;
		try {
			fileReader = new BufferedReader(new FileReader("c:/carlist.txt"));
			String line = fileReader.readLine();
			while (line != null) {
				List<String> carDetails = Arrays.asList(line.split(";"));
				Car car = new Car(carDetails.get(0), carDetails.get(1), carDetails.get(2));
				CarList.add(car);
				line = fileReader.readLine();
			}
			fileReader.close();
		} catch(IOException exception) {
			exception.printStackTrace();
		}
		
		return CarList;
	}
	
	
	public List<Car> Search(String key, String criteria) {
		List<Car> CarList = getAllCars();
		List<Car> Reply = new ArrayList();

        criteria = criteria.toLowerCase();

        switch (criteria) {

            case "all":
                for (Car car : CarList) {
                    if (car.getBrand().contains(key) || car.getModel().contains(key) || car.getType().contains(key)) {
                        Reply.add(car);
                    }
                }
                break;
                
            case "model":
                for (Car car : CarList) {
                    if (car.getModel().contains(key)) {
                        Reply.add(car);
                    }
                }
                break;
                
            case "brand":
                for (Car car : CarList) {
                    if (car.getBrand().contains(key)) {
                        Reply.add(car);
                    }
                }
                break;
                
            case "type":
                for (Car car : CarList) {
                    if (car.getType().contains(key)) {
                        Reply.add(car);
                    }
                }
                break;
        }
        
        return Reply;
	}
        
}
