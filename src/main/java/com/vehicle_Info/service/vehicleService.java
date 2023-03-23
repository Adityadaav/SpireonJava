package com.vehicle_Info.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.vehicle_Info.entity.Vehicle;

public interface vehicleService {
	
	 // Save operation
	Vehicle createVehicle(Vehicle vehicle);
 
    // Read operation
    List<Vehicle> fetchVehicalList();
    
    //readbyID
    public Vehicle fetchVehicalList(Long id);
    
    // Update operation
    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails);
    
//    Vehicle updateVehical(Vehicle vehicle,Long vehicalId);
 
    // Delete operation
    public ResponseEntity<Vehicle> deleteVehicleById(Long vehicleId);
	

}
