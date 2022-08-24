package com.mikaelsonbraz.serviceOrder.service.personService;

import com.mikaelsonbraz.serviceOrder.domain.person.Person;
import com.mikaelsonbraz.serviceOrder.dto.person.TechnicianDTO;
import com.mikaelsonbraz.serviceOrder.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    protected boolean duplicatedCPF(String cpf){
        return personRepository.existsByCpf(cpf);
    }

    protected Person findByCpf(String cpf){
        return personRepository.findByCpf(cpf);
    }
}
