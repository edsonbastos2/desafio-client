package com.userTest.demo.dto;

import java.time.LocalDate;

public class FormClientDto {
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private LocalDate birthDate;
    private Integer children;


    public FormClientDto() {
    }

    public FormClientDto(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public FormClientDto(ClientDto clientDto) {
        id = clientDto.getId();
        name = clientDto.getName();
        cpf = clientDto.getCpf();
        income = clientDto.getIncome();
        birthDate = clientDto.getBirthDate();
        children = clientDto.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
