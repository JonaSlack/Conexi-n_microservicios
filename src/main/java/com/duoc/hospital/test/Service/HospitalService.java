package com.duoc.hospital.test.Service;
mport com.duoc.hospital.test.Dto.HospitalDTO;
import com.duoc.hospital.test.Model.Hospital;
import com.duoc.hospital.test.Repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HospitalService {

    private final HospitalRepository repository;

    public HospitalService(HospitalRepository repository) {
        this.repository = repository;
    }

    public HospitalDTO saveHospital(HospitalDTO dto) {
        Hospital h = repository.save(Hospital.builder()
                .nombre(dto.getNombre())
                .direccion(dto.getDireccion())
                .build());
        return HospitalDTO.builder().id(h.getId()).nombre(h.getNombre()).direccion(h.getDireccion()).build();
    }

    public List<HospitalDTO> getAllHospitals() {
        return repository.findAll().stream()
                .map(h -> HospitalDTO.builder().id(h.getId()).nombre(h.getNombre()).direccion(h.getDireccion()).build())
                .collect(Collectors.toList());
    }

    public HospitalDTO getHospitalById(Long id) {
        Hospital h = repository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));
        return HospitalDTO.builder().id(h.getId()).nombre(h.getNombre()).direccion(h.getDireccion()).build();
    }

    public HospitalDTO updateHospital(Long id, HospitalDTO dto) {
        Hospital h = repository.findById(id).orElseThrow(() -> new RuntimeException("No existe"));
        h.setNombre(dto.getNombre());
        h.setDireccion(dto.getDireccion());
        repository.save(h);
        return dto;
    }

    public boolean deleteHospital(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

