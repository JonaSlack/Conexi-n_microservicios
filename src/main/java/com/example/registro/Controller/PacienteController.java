package com.example.registro.Controller;

import com.duoc.paciente.test.Service.Pacienteservice;
import com.example.registro.Dto.PacienteDto;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final Pacienteservice service;

    public PacienteController(Pacienteservice service) {
        this.service = service;
    }

    @PostMapping
    public PacienteDto save(@RequestBody PacienteDto dto) {
        return service.save(dto);
    }

    @GetMapping
    public List<PacienteDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PacienteDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public PacienteDto update(@PathVariable Long id, @RequestBody PacienteDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id) ? "Eliminado" : "No encontrado";
    }


}