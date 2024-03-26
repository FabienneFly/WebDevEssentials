package com.fehrfab2.equipmentmanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fehrfab2.equipmentmanager.exception.EquipmentNotFoundException;
import com.fehrfab2.equipmentmanager.model.Equipment;
import com.fehrfab2.equipmentmanager.repo.EquipmentRepo;

import jakarta.transaction.Transactional;

@Service
public class EquipmentService {

    private final EquipmentRepo equipmentRepo;

    @Autowired
    public EquipmentService(EquipmentRepo equipmentRepo) {
        this.equipmentRepo = equipmentRepo;
    }

    public Equipment addEquipment(Equipment equipment) {
        equipment.setEquipmentCode(UUID.randomUUID().toString());
        return equipmentRepo.save(equipment);

    }

    public List<Equipment> findAllEquipments() {
        return equipmentRepo.findAll();
    }

    public Equipment updateEquipment(Equipment equipment) {
        return equipmentRepo.save(equipment);
    }

    public Equipment findEquipmentById(long id) {
        return equipmentRepo.findEquipmentById(id)
                .orElseThrow(() -> new EquipmentNotFoundException("Equipment by id " + id + " was not found"));
    }

    @Transactional
    public void deleteEquipmentById(long id) {
        equipmentRepo.deleteEquipmentById(id);

    }

}
