package com.natanael.fincontrol.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


public class Transaction {
    private UUID id;
    private String description;
    private BigDecimal value;
    // private TypeTransaction; implementar Enum: Receita, Despesa
    private String Category;
    private LocalDate data;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

}
