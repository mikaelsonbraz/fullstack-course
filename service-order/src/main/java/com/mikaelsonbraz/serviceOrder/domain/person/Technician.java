package com.mikaelsonbraz.serviceOrder.domain.person;

import java.io.Serializable;

public class Technician extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    public Technician() {
    }

    public Technician(Integer id, String name, String cpf, String phone) {
        super(id, name, cpf, phone);
    }
}
