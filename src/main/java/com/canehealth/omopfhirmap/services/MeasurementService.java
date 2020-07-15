package com.canehealth.omopfhirmap.services;

import com.canehealth.omopfhirmap.repositories.MeasurementRepository;
import com.canehealth.omopfhirmap.models.Measurement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class MeasurementService extends BaseService<MeasurementRepository, Measurement>{

    @Autowired
    private MeasurementRepository measurementRepository;

    public List<Measurement> list(){
        return measurementRepository.findAll();
    }

    public List<Measurement> listByPerson(Integer personId){
        return measurementRepository.findByPersonId(personId);
    }

    public List<Measurement> listByPersonAndPeriod(Integer personId, Date start, Date end){
        return measurementRepository.findByPersonIdAndMeasurementDateBetween(personId, start, end);
    }
    
}