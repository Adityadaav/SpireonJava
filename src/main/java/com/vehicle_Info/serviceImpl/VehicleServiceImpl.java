package com.vehicle_Info.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vehicle_Info.Repository.VehicleRepository;
import com.vehicle_Info.entity.Vehicle;
import com.vehicle_Info.service.vehicleService;

@Service
public class VehicleServiceImpl implements vehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	// create
	@Override
	public Vehicle createVehicle(Vehicle vehicle) {

		return vehicleRepository.save(vehicle);
	}

	// read
	@Override
	public List<Vehicle> fetchVehicalList() {

		return vehicleRepository.findAll();
	}

	// readBYId
	public Vehicle fetchVehicalList(Long id) {
        //
		return vehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id", id));
	}

	// update
	@Override
	public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) {
		Vehicle vehicle = vehicleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id", id));
		vehicle.setVin(vehicleDetails.getVin());
		vehicle.setYear(vehicleDetails.getYear());
		vehicle.setMake(vehicleDetails.getMake());
		vehicle.setModel(vehicleDetails.getModel());
		vehicle.setFuelTypePrimary(vehicleDetails.getFuelTypePrimary());
		vehicle.setManufacturer(vehicleDetails.getManufacturer());
		return vehicleRepository.save(vehicle);
	}

	// delete
	@Override
	 public ResponseEntity<Vehicle> deleteVehicleById(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id", vehicleId));
		vehicleRepository.delete(vehicle);
		return ResponseEntity.ok().build();
	}
}
