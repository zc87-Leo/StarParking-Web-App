package com.zc.parking.service;

import com.zc.parking.po.Meter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MeterService {
    Meter findOne(Long id);

    Page<Meter> listMeter(Pageable pageable);

    Page<Meter> listAMeter(Pageable pageable,Meter meter);

    Meter updateMeter(Meter meter);



}
