package com.mikaelsonbraz.serviceOrder.service;

import com.mikaelsonbraz.serviceOrder.domain.person.Consumer;
import com.mikaelsonbraz.serviceOrder.dto.person.ConsumerDTO;
import com.mikaelsonbraz.serviceOrder.repository.ConsumerRepository;
import com.mikaelsonbraz.serviceOrder.repository.PersonRepository;
import com.mikaelsonbraz.serviceOrder.service.exception.DuplicatedCpfExcecption;
import com.mikaelsonbraz.serviceOrder.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ConsumerService extends PersonService{

    @Autowired
    ConsumerRepository consumerRepository;

    public Consumer findById(Integer id){
        Optional<Consumer> consumer = consumerRepository.findById(id);
        return consumer.orElseThrow(() -> new ObjectNotFoundException(
                                                "Consumer not found! Id: " + id + ", Type: " + Consumer.class.getName()));
    }

    public List<Consumer> getAll(){
        return consumerRepository.findAll();
    }

    public Consumer create(ConsumerDTO consumerDTO){
        if(duplicatedCPF(consumerDTO.getCpf())){
            throw new DuplicatedCpfExcecption("Duplicated CPF! " + consumerDTO.getCpf());
        }
        return consumerRepository.save(new Consumer(null, consumerDTO.getName(), consumerDTO.getCpf(), consumerDTO.getPhone()));
    }

    public Consumer update(Integer id, ConsumerDTO consumerDTO){
        Consumer consumerToUpdate = findById(id);

        if(duplicatedCPF(consumerDTO.getCpf()) && !Objects.equals(findByCpf(consumerDTO.getCpf()).getId(), id)){
            throw new DuplicatedCpfExcecption("Duplicated CPF! " + consumerDTO.getCpf());
        }

        consumerToUpdate.setName(consumerDTO.getName());
        consumerToUpdate.setCpf(consumerDTO.getCpf());
        consumerToUpdate.setPhone(consumerDTO.getPhone());

        return consumerRepository.save(consumerToUpdate);
    }

    public void delete(@PathVariable Integer id){
        Consumer consumer = findById(id);
        if(consumer.getRequestOrderServiceList().size() > 0){
            throw new DataIntegrityViolationException("The id " + id + " consumer has service orders unfinished, dedlete method unavailable");
        }
        consumerRepository.delete(consumer);
    }
}
