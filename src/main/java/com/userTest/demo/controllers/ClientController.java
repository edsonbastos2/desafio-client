package com.userTest.demo.controllers;

import com.userTest.demo.dto.ClientDto;
import com.userTest.demo.dto.FormClientDto;
import com.userTest.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping(value = "{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable Long id) {
        var dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDto>> findAll(Pageable pageable) {
        var result = service.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ClientDto> create(@RequestBody FormClientDto dto) {
        var result = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(uri).body(result);

    }

    @PutMapping(value = "{id}")
    public ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody FormClientDto dto) {
        var result = service.update(id, dto);
        return ResponseEntity.ok(result);
    }
}
