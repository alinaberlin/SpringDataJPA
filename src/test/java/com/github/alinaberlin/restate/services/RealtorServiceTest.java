package com.github.alinaberlin.restate.services;

import com.github.alinaberlin.restate.models.Realtor;
import com.github.alinaberlin.restate.repositories.RealtorRepository;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class RealtorServiceTest {


    @Mock
    private RealtorRepository mockRealtorRepository;

    private RealtorService realtorService;


    @AfterEach
    public void teardown(){
    }
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        realtorService = new RealtorService( mockRealtorRepository);
    }
    @Test
    void getAllRealtors() {
        List<Realtor> realtors  = Arrays.asList( new Realtor(1, "Alina", "alinagmail.com", "123455"),
                new Realtor(2, "Alina2", "alinagmail.com", "123455"));
       Mockito.when(mockRealtorRepository.findAll()).thenReturn(realtors);
        List<Realtor> result = realtorService.getAllRealtors();
        Assertions.assertEquals(realtors, result);

    }

    @Test
    void getRealtorById() {
        Realtor realtor = new Realtor(1, "Alina", "alinagmail.com", "123455");
        Mockito.when(mockRealtorRepository.findById(1L)).thenReturn(Optional.of(realtor));
        Realtor found  =realtorService.getRealtorById(1);
        Assertions.assertEquals( realtor, found);
    }

    @Test
    void saveRealtor() {
        Realtor realtor = new Realtor(1, "Alina", "alinagmail.com", "123455");
        Mockito.when(mockRealtorRepository.save(realtor)).thenReturn(realtor);
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
        Mockito.when(mockRealtorRepository.save(realtor)).thenReturn(realtor);
        Realtor result = realtorService.saveRealtor(realtor);
        Realtor realtor1 = new Realtor(1, "Ghetler", "alinagmail.com", "123455");
        Mockito.when(mockRealtorRepository.save(realtor1)).thenReturn(realtor1);
        Realtor result2= realtorService.updateRealtor(realtor1);
        Assertions.assertEquals(realtor1, result2);


    }
}