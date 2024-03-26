package com.fehrfab2.equipmentmanager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fehrfab2.equipmentmanager.model.Equipment;

public interface EquipmentRepo extends JpaRepository<Equipment, Long> {

    void deleteEquipmentById(Long id);

    Optional<Equipment> findEquipmentById(Long id);

}
