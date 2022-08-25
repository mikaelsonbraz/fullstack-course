package com.mikaelsonbraz.serviceOrder.controller.serviceOrderController;

import com.mikaelsonbraz.serviceOrder.domain.serviceOrder.ServiceOrder;
import com.mikaelsonbraz.serviceOrder.dto.serviceOrder.ServiceOrderDTO;
import com.mikaelsonbraz.serviceOrder.service.serviceOrderService.ServiceOrderService;
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
@RequestMapping("/serviceorders")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOrderDTO> findById(@PathVariable Integer id){
        ServiceOrderDTO serviceOrderDTO = new ServiceOrderDTO(serviceOrderService.findById(id));
        return ResponseEntity.ok().body(serviceOrderDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ServiceOrderDTO>> getAll(){
        List<ServiceOrderDTO> allServiceOrders = new ArrayList<>();
        for(ServiceOrder x : serviceOrderService.getAll()){
            allServiceOrders.add(new ServiceOrderDTO(x));
        }
        return ResponseEntity.ok().body(allServiceOrders);
    }

    @PostMapping
    public ResponseEntity<ServiceOrderDTO> create(@Valid @RequestBody ServiceOrderDTO serviceOrderDTO){
        ServiceOrderDTO serviceOrderDTOsaved = new ServiceOrderDTO(serviceOrderService.create(serviceOrderDTO));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(serviceOrderDTOsaved.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<ServiceOrderDTO> update(@PathVariable Integer id, @Valid @RequestBody ServiceOrderDTO serviceOrderDTO){
        ServiceOrderDTO serviceOrderDTO1updated = new ServiceOrderDTO(serviceOrderService.update(id, serviceOrderDTO));

        return ResponseEntity.ok().body(serviceOrderDTO1updated);
    }
}
