package com.mikaelsonbraz.serviceOrder.domain.person;

public class Technician extends Person{

    public Technician() {
    }

    public Technician(Integer id, String name, String cpf, String phone) {
        super(id, name, cpf, phone);
    }
}