package com.mikaelsonbraz.serviceOrder.dto.person;

import com.mikaelsonbraz.serviceOrder.domain.person.Consumer;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ConsumerDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Name field is required!")
    private String name;
    @CPF
    @NotEmpty(message = "CPF field is required!")
    private String cpf;
    @NotEmpty(message = "Phone field is required!")
    private String phone;

    public ConsumerDTO() {
    }

    public ConsumerDTO(Consumer consumer) {
        this.id = consumer.getId();
        this.name = consumer.getName();
        this.cpf = consumer.getCpf();
        this.phone = consumer.getPhone();
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
