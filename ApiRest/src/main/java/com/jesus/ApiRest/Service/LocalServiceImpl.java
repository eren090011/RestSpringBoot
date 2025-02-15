/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jesus.ApiRest.Service;

import com.jesus.ApiRest.Entity.Local;
import com.jesus.ApiRest.Error.LocalNotFoundException;
import com.jesus.ApiRest.Repository.LocalRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalServiceImpl implements LocalService{

    @Autowired
    LocalRepository localRepository;
    
    @Override
    public List<Local> findAllLocals() {
        return localRepository.findAll();
    }

    @Override
    public Local saveLocal(Local local) {
        return localRepository.save(local);
    }

    @Override
    public Local updateLocal(Long id, Local local) {
        Local localDb= localRepository.findById(id).get();
        if(Objects.nonNull(local.getCode()) && !"".equalsIgnoreCase(local.getCode())){
            localDb.setCode(local.getCode());
        }
        if(Objects.nonNull(local.getFloor()) && !"".equalsIgnoreCase(local.getFloor())){
            localDb.setFloor(local.getFloor());
        }
        if(Objects.nonNull(local.getName()) && !"".equalsIgnoreCase(local.getName())){
            localDb.setName(local.getName());
        }
        // como tiene el mismo id, en vez de guardarlo, actualiza
        return localRepository.save(localDb);
        
    }

    @Override
    public void deleteLocal(Long id) {
        localRepository.deleteById(id);
    }

    @Override
    public Optional<Local> findLocalByNameWithJPQL(String name) {
       return localRepository.findLocalByNameWithJPQL(name);
    }
    
    @Override
    public Optional<Local> findByName(String name) {
       return localRepository.findByName(name);
    }
    
    @Override
    public Optional<Local> findByNameIgnoreCase(String name) {
       return localRepository.findByNameIgnoreCase(name);
    }
    
    @Override
    public Local findLocalById(Long id)throws LocalNotFoundException{
        Optional<Local> local= localRepository.findById(id);
        if(!local.isPresent()){
           throw new LocalNotFoundException("Local is not available");
        }
        return local.get();
    }
    
}
