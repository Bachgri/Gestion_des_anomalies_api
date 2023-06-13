package com.rest.api.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
	
}
