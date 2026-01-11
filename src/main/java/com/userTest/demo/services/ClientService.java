package com.userTest.demo.services;

import com.userTest.demo.dto.ClientDto;
import com.userTest.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public ClientDto getById(Long id) {
        var client  = repository.findById(id).get();
        return new ClientDto(client);
    }

    public Page<ClientDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(ClientDto::new);
    }
}
