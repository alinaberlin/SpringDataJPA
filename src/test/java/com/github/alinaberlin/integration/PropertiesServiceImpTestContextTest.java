package com.github.alinaberlin.integration;

import com.github.alinaberlin.SpringDataJpaApplication;
import com.github.alinaberlin.restate.models.Property;
import com.github.alinaberlin.restate.services.PropertyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = SpringDataJpaApplication.class)
@RunWith(SpringRunner.class)
public class PropertiesServiceImpTestContextTest {

    @Autowired
    private PropertyService propertyService;


    @Test
    public void shouldSaveProperty() {
        Property property = new Property();
         property = propertyService.saveProperty(property);

    }

}