/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jesus.ApiRest.Service;

import com.jesus.ApiRest.Entity.Local;
import com.jesus.ApiRest.Error.LocalNotFoundException;
import java.util.List;
import java.util.Optional;

public interface LocalService {
    List<Local> findAllLocals();
    Local saveLocal(Local local);
    Local updateLocal(Long id, Local local);
    void deleteLocal(Long id);
    Optional<Local> findLocalByNameWithJPQL(String name);
    Optional<Local> findByName(String name);
    Optional<Local> findByNameIgnoreCase(String name);
    Local findLocalById(Long id) throws LocalNotFoundException;
}
