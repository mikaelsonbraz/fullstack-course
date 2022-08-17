package com.mikaelsonbraz.serviceOrder.domain.serviceOrder;

import com.mikaelsonbraz.serviceOrder.domain.person.Consumer;
import com.mikaelsonbraz.serviceOrder.domain.person.Technician;
import com.mikaelsonbraz.serviceOrder.domain.serviceOrder.enums.PriorityLevel;
import com.mikaelsonbraz.serviceOrder.domain.serviceOrder.enums.Status;

import java.time.LocalDateTime;
import java.util.Objects;

public class ServiceOrder {

    private Integer id;
    private LocalDateTime openingDate;
    private LocalDateTime closingDate;
    private Integer priorityLevel;
    private String comments;
    private Integer status;
    private Technician technician;
    private Consumer consumer;

    public ServiceOrder() {
        //colar essa logica de negocio dentro da camada service posteriormente
        this.setOpeningDate(LocalDateTime.now());
        this.setPriorityLevel(PriorityLevel.LOW);
        this.setStatus(Status.TO_DO);
    }

    public ServiceOrder(Integer id, PriorityLevel priority, String comments, Status status, Technician technician, Consumer consumer) {
        this.id = id;
        //colar essa logica de negocio dentro da camada service posteriormente
        this.setOpeningDate(LocalDateTime.now());
        this.priorityLevel = (priority == null) ? 0 : priority.getCode();
        this.comments = comments;
        this.status = (status == null) ? 0 : status.getCode();
        this.technician = technician;
        this.consumer = consumer;
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

    public PriorityLevel getPriorityLevel() {
        return PriorityLevel.toEnum(this.priorityLevel);
    }

    public void setPriorityLevel(PriorityLevel priorityLevel) {
        this.priorityLevel = priorityLevel.getCode();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Status getStatus() {
        return Status.toEnum(this.status);
    }

    public void setStatus(Status status) {
        this.status = status.getCode();
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceOrder that = (ServiceOrder) o;
        return Objects.equals(id, that.id) && Objects.equals(openingDate, that.openingDate) && Objects.equals(closingDate, that.closingDate) && Objects.equals(priorityLevel, that.priorityLevel) && Objects.equals(comments, that.comments) && status == that.status && Objects.equals(technician, that.technician) && Objects.equals(consumer, that.consumer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, openingDate, closingDate, priorityLevel, comments, status, technician, consumer);
    }
}
