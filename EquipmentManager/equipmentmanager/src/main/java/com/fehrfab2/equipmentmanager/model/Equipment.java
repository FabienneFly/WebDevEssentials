package com.fehrfab2.equipmentmanager.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Equipment implements Serializable {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int amount;
    @Column(nullable = false, updatable = false)
    private String equipmentCode;

    public Equipment(Long id, String name, String description, int amount, String equipmentCode) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.equipmentCode = equipmentCode;
    }

    public Equipment() {

    }

    public Long getId() {
        return id;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Equipment [id=" + id + ", name=" + name + ", description=" + description + ", amount=" + amount
                + ", equipmentCode=" + equipmentCode + "]";
    }

}
