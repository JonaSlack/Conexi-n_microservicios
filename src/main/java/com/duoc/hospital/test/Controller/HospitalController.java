package com.duoc.hospital.test.Controller;



import com.duoc.hospital.test.Dto.HospitalDTO;
import com.duoc.hospital.test.Service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitals") // ESTA RUTA ES VITAL: Pacientes la busca así
public class HospitalController {

    private final HospitalService service;

    public HospitalController(HospitalService service) {
        this.service = service;
    }

    @PostMapping
    public HospitalDTO save(@RequestBody HospitalDTO dto) {
        return service.saveHospital(dto);
    }

    @GetMapping
    public List<HospitalDTO> getAll() {
        return service.getAllHospitals();
    }

    @GetMapping("/{id}")
    public HospitalDTO getById(@PathVariable Long id) {
        return service.getHospitalById(id);
    }

    @PutMapping("/{id}")
    public HospitalDTO update(@PathVariable Long id, @RequestBody HospitalDTO dto) {
        return service.updateHospital(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.deleteHospital(id) ? "Hospital eliminado" : "Error";
    }

}