package com.jesus.ApiRest.Controller;

import com.jesus.ApiRest.Entity.Local;
import com.jesus.ApiRest.Error.LocalNotFoundException;
import com.jesus.ApiRest.Service.LocalService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalController {
    
    @Autowired
    LocalService localService;
    
    @GetMapping("/findAllLocals")
    public List<Local> findAllLocal(){
        return localService.findAllLocals();
    }
    
    @GetMapping("/findLocalByNameWithJPQL/{name}")
    Optional<Local> findLocalByNameWithJPQL(@PathVariable String name){
        return localService.findLocalByNameWithJPQL(name); 
    }
    
    @GetMapping("/findByName/{name}")
    Optional<Local> findByName(@PathVariable String name){
        return localService.findByName(name);
    }
    
    @GetMapping("/findByNameIgnoreCase/{name}")
    Optional<Local> findByNameIgnoreCase(@PathVariable String name){
        return localService.findByNameIgnoreCase(name);
    }
    
    @GetMapping("/findLocalById/{id}")
    Local findLocalById(@PathVariable Long id) throws LocalNotFoundException{
        return localService.findLocalById(id); 
    }
    
    
    @PostMapping("/saveLocal")
    public Local saveLocal(@Valid @RequestBody Local local){
        return localService.saveLocal(local);
    }
    @PutMapping("/updateLocal/{id}")
    public Local updateLocal(@PathVariable Long id, @RequestBody Local local){
        return localService.updateLocal(id,local);
    }
    @DeleteMapping("/deleteLocal/{id}")
    public String deleteLocal(@PathVariable Long id){
        localService.deleteLocal(id);
        return "Successfully deleted";
    }
    
    
    
     
} 
