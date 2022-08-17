package com.mikaelsonbraz.serviceOrder.domain.person;

import java.io.Serializable;

public class Consumer extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    public Consumer() {
    }

    public Consumer(Integer id, String name, String cpf, String phone) {
        super(id, name, cpf, phone);
    }
}
