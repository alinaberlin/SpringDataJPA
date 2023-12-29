package com.github.alinaberlin.restate.controllers;


import com.github.alinaberlin.restate.models.Realtor;
import com.github.alinaberlin.restate.services.RealtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realtors")
public class RealtorControler {
    private final RealtorService realtorService;

   @Autowired
    public RealtorControler(RealtorService realtorService) {
        this.realtorService = realtorService;
    }
    public ResponseEntity<List<Realtor>> getAllRealtors(){
       List<Realtor> realtors = realtorService.getAllRealtors();
       return new ResponseEntity<>(realtors, HttpStatus.OK);
    }
    public ResponseEntity<Realtor> getRealtorById(@PathVariable long id){
       Realtor realtor = realtorService.getRealtorById(id);
       if(realtor !=null){
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
    @PostMapping
    public ResponseEntity<Realtor> createRealtor(@RequestBody Realtor realtor){
       Realtor createdRealtor = realtorService.saveRealtor(realtor);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Realtor> updateRealtor(@PathVariable long id, @RequestBody Realtor realtor) {
        Realtor updatedRealtor = realtorService.updateRealtor(realtor);
        if(updatedRealtor !=null){
            return new ResponseEntity<>(updatedRealtor, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping
    public ResponseEntity<Realtor> deleteRealtor(@PathVariable long id){
       Realtor realtor = realtorService.getRealtorById(id);
       if(realtor == null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       realtorService.deleteRealtor(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
