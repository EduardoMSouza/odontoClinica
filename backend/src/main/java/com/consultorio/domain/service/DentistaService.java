package com.consultorio.domain.service;


import com.consultorio.domain.dto.request.DentistaRequestDTO;
import com.consultorio.domain.dto.response.DentistaResponseDTO;
import com.consultorio.domain.entity.Dentista;
import com.consultorio.domain.dto.mapper.DentistaMapper;
import com.consultorio.domain.repository.DentistaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DentistaService {

    private final DentistaRepository repository;

    public DentistaService(DentistaRepository repository) {
        this.repository = repository;
    }

    public DentistaResponseDTO criar(DentistaRequestDTO dto) {
        if (repository.existsByCro(dto.getCro())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um dentista com esse CRO!");
        }

        Dentista dentista = DentistaMapper.toEntity(dto);
        return DentistaMapper.toDTO(repository.save(dentista));
    }

    public List<DentistaResponseDTO> listar() {
        return repository.findAll().stream()
                .map(DentistaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DentistaResponseDTO buscarPorId(Long id) {
        Dentista dentista = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dentista não encontrado"));
        return DentistaMapper.toDTO(dentista);
    }

    public DentistaResponseDTO atualizar(Long id, DentistaRequestDTO dto) {
        Dentista dentista = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dentista não encontrado"));

        dentista.setNome(dto.getNome());
        dentista.setCro(dto.getCro());
        dentista.setEspecialidade(dto.getEspecialidade());
        dentista.setTelefone(dto.getTelefone());
        dentista.setEmail(dto.getEmail());

        return DentistaMapper.toDTO(repository.save(dentista));
    }

    public void inativar(Long id) {
        Dentista dentista = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dentista não encontrado"));
        dentista.setAtivo(false);
        repository.save(dentista);
    }
}
