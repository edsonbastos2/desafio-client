package com.userTest.demo.controllers;

import com.userTest.demo.dto.ClientDto;
import com.userTest.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping(value = "{id}")
    public ClientDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public Page<ClientDto> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
}
