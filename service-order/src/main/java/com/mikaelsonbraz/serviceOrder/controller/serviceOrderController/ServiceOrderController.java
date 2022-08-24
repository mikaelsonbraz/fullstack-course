package com.mikaelsonbraz.serviceOrder.controller.serviceOrderController;

import com.mikaelsonbraz.serviceOrder.domain.serviceOrder.ServiceOrder;
import com.mikaelsonbraz.serviceOrder.dto.serviceOrder.ServiceOrderDTO;
import com.mikaelsonbraz.serviceOrder.service.serviceOrderService.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
}
