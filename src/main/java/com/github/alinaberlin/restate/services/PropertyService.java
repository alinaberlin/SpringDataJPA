package com.github.alinaberlin.restate.services;


import com.github.alinaberlin.restate.models.Property;
import com.github.alinaberlin.restate.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;
@Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }
    public List<Property> getAllProperties(){
        return propertyRepository.findAll();
    }
    public Property getPropertyById (long id){
        return propertyRepository.findById(id).orElse(null);
    }
    public Property saveProperty(Property property){
       return propertyRepository.save(property);
    }
    public Property updateProperty(Property property){
     return propertyRepository.save(property);
    }
    public boolean deleteProperty(long id){
        propertyRepository.deleteById(id);
        return true;
    }

}
