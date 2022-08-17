package com.mikaelsonbraz.serviceOrder.domain;

public class Technician extends Person{

    public Technician() {
    }

    public Technician(Integer id, String name, String cpf, String phone) {
        super(id, name, cpf, phone);
    }
}
