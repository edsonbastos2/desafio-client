package com.userTest.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class FormClientDto {
    private Long id;

    @Size(min = 3, max = 80, message = "O nome deve ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo não pode ser vazio")
    private String name;

    @Size(min = 11)
    @NotBlank(message = "CPF não pode ser vazio")
    private String cpf;

    @Positive(message = "A renda deve ser positiva")
    private Double income;

    @PastOrPresent(message = "Não aceita datas futuras")
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
