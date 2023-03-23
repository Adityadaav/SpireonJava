package com.vehicle_Info.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicle_Info.entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository <Vehicle, Long> {

}
