package com.mikaelsonbraz.serviceOrder.controller;

import com.mikaelsonbraz.serviceOrder.domain.person.Technician;
import com.mikaelsonbraz.serviceOrder.dto.person.TechnicianDTO;
import com.mikaelsonbraz.serviceOrder.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/technicians")
public class TechnicianController {

    @Autowired
    TechnicianService technicianService;

    @GetMapping("/{id}")
    public ResponseEntity<TechnicianDTO> findByID(@PathVariable Integer id){
        TechnicianDTO technicianDTO = new TechnicianDTO(technicianService.findById(id));
        return ResponseEntity.ok().body(technicianDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TechnicianDTO>> getAll(){
        List<TechnicianDTO> allTechnicians = new ArrayList<>();
        for(Technician x : technicianService.getAll()){
            allTechnicians.add(new TechnicianDTO(x));
        }
        return ResponseEntity.ok().body(allTechnicians);
    }

    @PostMapping
    public ResponseEntity<TechnicianDTO> create(@Valid @RequestBody TechnicianDTO technicianDTO){
        TechnicianDTO technicianDTOsaved = new TechnicianDTO(technicianService.create(technicianDTO));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(technicianDTOsaved.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnicianDTO> update(@PathVariable Integer id, @Valid @RequestBody TechnicianDTO technicianDTO){
        TechnicianDTO technicianDTOUpdated = new TechnicianDTO(technicianService.update(id, technicianDTO));

        return ResponseEntity.ok().body(technicianDTOUpdated);
    }
}
