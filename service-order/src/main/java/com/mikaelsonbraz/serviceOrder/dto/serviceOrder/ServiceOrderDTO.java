package com.mikaelsonbraz.serviceOrder.dto.serviceOrder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mikaelsonbraz.serviceOrder.domain.serviceOrder.ServiceOrder;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ServiceOrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime openingDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime closingDate;
    private Integer priorityLevel;
    private String comments;
    private Integer status;
    private Integer technician;
    private Integer consumer;

    public ServiceOrderDTO() {
    }

    public ServiceOrderDTO(ServiceOrder serviceOrder) {
        this.id = serviceOrder.getId();
        this.openingDate = serviceOrder.getOpeningDate();
        this.closingDate = serviceOrder.getClosingDate();
        this.priorityLevel = serviceOrder.getPriorityLevel().getCode();
        this.comments = serviceOrder.getComments();
        this.status = serviceOrder.getStatus().getCode();
        this.technician = serviceOrder.getTechnician().getId();
        this.consumer = serviceOrder.getConsumer().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
        this.openingDate = openingDate;
    }

    public LocalDateTime getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDateTime closingDate) {
        this.closingDate = closingDate;
    }

    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTechnician() {
        return technician;
    }

    public void setTechnician(Integer technician) {
        this.technician = technician;
    }

    public Integer getConsumer() {
        return consumer;
    }

    public void setConsumer(Integer consumer) {
        this.consumer = consumer;
    }
}
