package com.jesus.ApiRest.Service;

import com.jesus.ApiRest.Entity.Local;
import com.jesus.ApiRest.Repository.LocalRepository;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class LocalServiceTest {
    
    @Autowired
    private LocalService localService;
    
    @MockBean
    private LocalRepository localRepository;
    @BeforeEach
    void setUp(){
        Local local = Local.builder()
                .id(1L)
                .name("PetShop")
                .floor("Second Floor")
                .code("Pet-050-2")
                .build();
        Mockito.when(localRepository.findByNameIgnoreCase("PetShop")).thenReturn(Optional.of(local));
    }
    
    @Test 
    @DisplayName("Prueba de obtencion de informacion de un local enviando un nombre valido")
    public void findByNameIgnoreCaseShouldFound(){
        String localName = "PetShop";
        Local local = localService.findByNameIgnoreCase(localName).get();
        assertEquals(localName,local.getName());
        System.out.println("local = "+ local);
        
    }
}
