package com.vehicle_Info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle_Info.entity.Vehicle;
import com.vehicle_Info.serviceImpl.VehicleServiceImpl;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
	
	
	@Autowired
	private VehicleServiceImpl vehicleServiceImpl;
	
	@PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleServiceImpl.createVehicle(vehicle);
    }
	
	@GetMapping
    public List<Vehicle> getAllVehicles() {
    return vehicleServiceImpl.fetchVehicalList();
        
    }
	
	@GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
	return vehicleServiceImpl.fetchVehicalList(id);
		       
    }
    
    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicleDetails) {
//        Vehicle updatedVehicle = 
    	return vehicleServiceImpl.updateVehicle(id, vehicleDetails);
    	
     //   return ResponseEntity.ok(updatedVehicle);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable Long id) {
    	
        return vehicleServiceImpl.deleteVehicleById(id);
    }

}
