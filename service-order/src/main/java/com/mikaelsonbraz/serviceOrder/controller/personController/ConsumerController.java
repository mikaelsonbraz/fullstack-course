package com.mikaelsonbraz.serviceOrder.controller.personController;

import com.mikaelsonbraz.serviceOrder.domain.person.Consumer;
import com.mikaelsonbraz.serviceOrder.dto.person.ConsumerDTO;
import com.mikaelsonbraz.serviceOrder.service.personService.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/consumers")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/{id}")
    public ResponseEntity<ConsumerDTO> findById(@PathVariable Integer id) {
        ConsumerDTO consumerDTO = new ConsumerDTO(consumerService.findById(id));
        return ResponseEntity.ok().body(consumerDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ConsumerDTO>> getAll() {
        List<ConsumerDTO> allConsumers = new ArrayList<>();
        for (Consumer x : consumerService.getAll()) {
            allConsumers.add(new ConsumerDTO(x));
        }
        return ResponseEntity.ok().body(allConsumers);
    }

    @PostMapping
    public ResponseEntity<Consumer> create(@Valid @RequestBody ConsumerDTO consumerDTO) {
        ConsumerDTO consumerDTOsaved = new ConsumerDTO(consumerService.create(consumerDTO));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(consumerDTOsaved.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsumerDTO> update(@PathVariable Integer id, @Valid @RequestBody ConsumerDTO consumerDTO) {
        ConsumerDTO consumerDTOupdated = new ConsumerDTO(consumerService.update(id, consumerDTO));

        return ResponseEntity.ok().body(consumerDTOupdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        consumerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
