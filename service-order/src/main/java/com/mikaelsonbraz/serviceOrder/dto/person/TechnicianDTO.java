package com.mikaelsonbraz.serviceOrder.dto.person;

import com.mikaelsonbraz.serviceOrder.domain.person.Technician;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

public class TechnicianDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    @CPF
    private String cpf;
    private String phone;

    public TechnicianDTO() {
    }

    public TechnicianDTO(Technician technician) {
        this.id = technician.getId();
        this.name = technician.getName();
        this.cpf = technician.getCpf();
        this.phone = technician.getPhone();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
