package com.mikaelsonbraz.serviceOrder.domain.person;

import com.mikaelsonbraz.serviceOrder.domain.serviceOrder.ServiceOrder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Consumer extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "consumer")
    private List<ServiceOrder> requestOrderServiceList = new ArrayList<>();

    public Consumer() {
    }

    public Consumer(Integer id, String name, String cpf, String phone) {
        super(id, name, cpf, phone);
    }

    public List<ServiceOrder> getRequestOrderServiceList() {
        return requestOrderServiceList;
    }

    public void setRequestOrderServiceList(List<ServiceOrder> requestOrderServiceList) {
        this.requestOrderServiceList = requestOrderServiceList;
    }
}
