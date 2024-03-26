package com.fehrfab2.equipmentmanager;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fehrfab2.equipmentmanager.model.Equipment;
import com.fehrfab2.equipmentmanager.service.EquipmentService;

@RestController
@RequestMapping("/equipment")
public class EquipmentRessource {

    private final EquipmentService equipmentService;

    public EquipmentRessource(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Equipment>> getAllEquipments() {
        try {
            List<Equipment> equipments = equipmentService.findAllEquipments();
            return new ResponseEntity<List<Equipment>>(equipments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Equipment> findEquipmentById(@PathVariable("id") Long id) {
        Equipment equipment = equipmentService.findEquipmentById(id);
        return new ResponseEntity<>(equipment, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Equipment> addEquipment(@RequestBody Equipment equipment) {
        Equipment newEquipment = equipmentService.addEquipment(equipment);
        return new ResponseEntity<>(newEquipment, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Equipment> updateEquipment(@RequestBody Equipment equipment) {
        Equipment updateEquipment = equipmentService.updateEquipment(equipment);
        return new ResponseEntity<>(updateEquipment, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEquipment(@PathVariable("id") Long id) {
        equipmentService.deleteEquipmentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
