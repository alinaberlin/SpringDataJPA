package com.github.alinaberlin.restate.services;


import com.github.alinaberlin.restate.models.Property;
import com.github.alinaberlin.restate.models.Realtor;
import com.github.alinaberlin.restate.repositories.RealtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealtorService {
    private final RealtorRepository realtorRepository;
@Autowired
    public RealtorService(RealtorRepository realtorRepository) {
    this.realtorRepository = realtorRepository;

    }
    public List<Realtor> getAllRealtors(){
    return realtorRepository.findAll();
    }
    public Realtor getRealtorById(long id){
    return realtorRepository.findById(id).orElse(null);
    }
    public Realtor saveRealtor(Realtor realtor){
    return realtorRepository.save(realtor);
    }
    public void deleteRealtor(long id){
    realtorRepository.deleteById(id);
    }

    public Realtor updateRealtor(Realtor realtor) {
    return realtorRepository.save(realtor);
    }
}
