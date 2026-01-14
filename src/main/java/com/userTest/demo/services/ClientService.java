package com.userTest.demo.services;

import com.userTest.demo.dto.ClientDto;
import com.userTest.demo.dto.FormClientDto;
import com.userTest.demo.entities.Client;
import com.userTest.demo.repositories.ClientRepository;
import com.userTest.demo.services.exceptions.DatabaseException;
import com.userTest.demo.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDto getById(Long id) {
        var client  = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDto(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(ClientDto::new);
    }

    @Transactional
    public ClientDto insert(FormClientDto dto) {
        Client client = new Client();
        copyDtoToEntity(dto, client);
        client = repository.save(client);
        return new ClientDto(client);
    }

    @Transactional
    public ClientDto update(Long id, FormClientDto dto) {
        try {
            Client client = repository.getReferenceById(id);
            copyDtoToEntity(dto, client);
            client = repository.save(client);
            return new ClientDto(client);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    private void copyDtoToEntity(FormClientDto dto, Client client) {
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());
        client.setChildren(dto.getChildren());
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if(repository.existsById(id)) {
            throw new ResourceNotFoundException("Id não encontrado");
        }

        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
}
