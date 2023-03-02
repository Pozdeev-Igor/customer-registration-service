package com.customerService.intsv.service.impl;

import com.customerService.intsv.repository.ServiceTypeRepository;
import com.customerService.intsv.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    private final ServiceTypeRepository serviceTypeRepository;

    @Autowired
    public ServiceTypeServiceImpl(ServiceTypeRepository serviceTypeRepository) {
        this.serviceTypeRepository = serviceTypeRepository;
    }
}
