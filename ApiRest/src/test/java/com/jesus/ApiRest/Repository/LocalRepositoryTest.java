/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jesus.ApiRest.Repository;

import com.jesus.ApiRest.Entity.Local;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;



@DataJpaTest
public class LocalRepositoryTest {
    @Autowired
    LocalRepository localRepository;
    
    @Autowired
    TestEntityManager testEntityManager;
     
    // Crea un registro antes del test, para luego buscarlo
    @BeforeEach
    void setUp(){
        Local local =
                Local.builder()
                .name("Supermarket")
                .floor("Tercer piso")
                .code("Sup-010-3")
                .build();
        testEntityManager.persist(local);   
    }
    
    // busca el registro creado
    @Test
    public void findLocalByNameIgnoreCaseFound(){
        Optional<Local> local = localRepository.findByNameIgnoreCase("Supermarket");
        //se compara lo que se creo con lo que buscaba, por lo que el test sirve
        assertEquals(local.get().getName(),"Supermarket");
        System.out.println("local.get() = "+local.get());
                
    }
    
    @Test
    public void findLocalByNameIgnoreCaseNotFound(){
        Optional<Local> local = localRepository.findByNameIgnoreCase("Cinema");
        assertEquals(local,Optional.empty());
    }
    
}
