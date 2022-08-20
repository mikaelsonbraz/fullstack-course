package com.mikaelsonbraz.serviceOrder.controller;

import com.mikaelsonbraz.serviceOrder.domain.person.Technician;
import com.mikaelsonbraz.serviceOrder.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/technicians")
public class TechnicianController {

    @Autowired
    TechnicianService technicianService;

    @GetMapping("/{id}")
    public ResponseEntity<Technician> findByID(@PathVariable Integer id){
        return ResponseEntity.ok().body(technicianService.findById(id));
    }
}
