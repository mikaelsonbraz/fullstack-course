package com.mikaelsonbraz.serviceOrder.domain.person;

import com.mikaelsonbraz.serviceOrder.domain.serviceOrder.ServiceOrder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Technician extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "technician")
    private List<ServiceOrder> serviceOrderList = new ArrayList<>();

    public Technician() {
    }

    public Technician(Integer id, String name, String cpf, String phone) {
        super(id, name, cpf, phone);
    }

    public List<ServiceOrder> getServiceOrderList() {
        return serviceOrderList;
    }

    public void setServiceOrderList(List<ServiceOrder> serviceOrderList) {
        this.serviceOrderList = serviceOrderList;
    }
}
