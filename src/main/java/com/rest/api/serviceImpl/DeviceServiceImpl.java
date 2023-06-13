package com.rest.api.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.api.entity.Device;
import com.rest.api.reposiroty.DeviceRepository;
import com.rest.api.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {

	DeviceRepository deviceRepository;
	
	
	public DeviceServiceImpl(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}

	@Override
	public List<Device> getAll() {
		return deviceRepository.findAll();
	}

	@Override
	public Device post(Device d) {
		return deviceRepository.save(d);
	}

	@Override
	public Device put(Device d) {
		Device dd = deviceRepository.findById(d.getId()).get();
		dd.copyTo(d);
		return deviceRepository.save(dd);
	}

	@Override
	public Device get(Long id) {
		return deviceRepository.findById(id).get();
	}

	@Override
	public Device delete(Device d) { 
		deviceRepository.delete(d);
		return d;
	}

}
