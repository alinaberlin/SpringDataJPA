package com.github.alinaberlin.restate.services;

import com.github.alinaberlin.restate.models.Realtor;
import com.github.alinaberlin.restate.repositories.RealtorRepository;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class RealtorServiceTest {

    @Autowired
    private RealtorService realtorService;

    @Autowired
    private RealtorRepository realtorRepository;

    @AfterEach
    public void teardown(){
        realtorRepository.deleteAll();
    }

    @Test
    void getAllRealtors() {
        List<Realtor> realtors  = Arrays.asList( new Realtor(1, "Alina", "alinagmail.com", "123455"),
                new Realtor(2, "Alina2", "alinagmail.com", "123455"));
       realtorRepository.saveAll(realtors);
        List<Realtor> result = realtorService.getAllRealtors();
        Assertions.assertEquals(realtors, result);

    }

    @Test
    void getRealtorById() {
        Realtor realtor = new Realtor(1, "Alina", "alinagmail.com", "123455");
        realtorService.saveRealtor(realtor);
        Realtor found  =realtorService.getRealtorById(1);
        Assertions.assertEquals( realtor, found);
    }

    @Test
    void saveRealtor() {
        Realtor realtor = new Realtor(1, "Alina", "alinagmail.com", "123455");
        Realtor result = realtorService.saveRealtor(realtor);
        Assertions.assertEquals(new Realtor(1, "Alina", "alinagmail.com", "123455"), result);
    }

    @Test
    void deleteRealtor() {
        Realtor realtor = new Realtor(1, "Alina", "alinagmail.com", "123455");
        Realtor result = realtorService.saveRealtor(realtor);
        realtorService.deleteRealtor(1);
        Realtor found  =realtorService.getRealtorById(1);
        Assertions.assertNull(found);

    }

    @Test
    void updateRealtor() {
        Realtor realtor = new Realtor(1, "Alina", "alinagmail.com", "123455");
        Realtor result = realtorService.saveRealtor(realtor);
        Realtor realtor1 = new Realtor(1, "Ghetler", "alinagmail.com", "123455");
        Realtor result2= realtorService.updateRealtor(realtor1);
        Assertions.assertEquals(realtor1, result2);


    }
}