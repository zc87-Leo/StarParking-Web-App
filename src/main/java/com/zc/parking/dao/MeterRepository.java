package com.zc.parking.dao;

import com.zc.parking.po.Meter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeterRepository extends JpaRepository<Meter,Long>, JpaSpecificationExecutor<Meter> {


}
