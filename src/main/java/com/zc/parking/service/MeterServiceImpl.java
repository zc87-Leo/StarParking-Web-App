package com.zc.parking.service;


import com.zc.parking.NotFoundException;
import com.zc.parking.dao.MeterRepository;
import com.zc.parking.po.Meter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MeterServiceImpl implements MeterService {
    @Autowired
    private MeterRepository meterRepository;

    @Transactional
    @Override
    public Meter findOne(Long id) {
        return meterRepository.findOne(id);
    }

    @Transactional
    @Override
    public Page<Meter> listMeter(Pageable pageable) {
        return meterRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Page<Meter> listAMeter(Pageable pageable, Meter meter) {

        return meterRepository.findAll(new Specification<Meter>() {
            @Override
            public Predicate toPredicate(Root<Meter> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if(meter.getLatitude()!= null){
                    predicates.add(cb.equal(root.<Double>get("latitude"),  meter.getLatitude()));
                }
                if(meter.getLongitude()!= null){
                    predicates.add(cb.equal(root.<Double>get("longitude"),  meter.getLongitude()));
                }
                if(meter.getStreet()!= null){
                    predicates.add(cb.equal(root.<String>get("street"),  meter.getStreet()));
                }
                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        },pageable);
    }

    @Override
    public Meter updateMeter(Meter meter) {

        return meterRepository.save(meter);
    }

}
