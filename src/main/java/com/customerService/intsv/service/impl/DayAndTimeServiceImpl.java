package com.customerService.intsv.service.impl;

import com.customerService.intsv.repository.DayAndTimeRepository;
import com.customerService.intsv.service.DayAndTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayAndTimeServiceImpl implements DayAndTimeService {

    private final DayAndTimeRepository dayAndTimeRepository;

    @Autowired
    public DayAndTimeServiceImpl(DayAndTimeRepository dayAndTimeRepository) {
        this.dayAndTimeRepository = dayAndTimeRepository;
    }
}
