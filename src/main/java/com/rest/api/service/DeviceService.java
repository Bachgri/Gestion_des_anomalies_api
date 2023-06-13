package com.rest.api.service;

import java.util.List;

import com.rest.api.entity.Device;

public interface DeviceService {
	public List<Device> getAll();
	public Device post(Device d);
	public Device put(Device d);
	public Device get(Long id);
	public Device delete(Device d);
}
