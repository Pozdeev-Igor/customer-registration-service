package com.customerService.intsv.service.impl;

import com.customerService.intsv.repository.BarberRepository;
import com.customerService.intsv.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarberServiceImpl implements BarberService {

    private final BarberRepository barberRepository;

    @Autowired
    public BarberServiceImpl(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }
}
