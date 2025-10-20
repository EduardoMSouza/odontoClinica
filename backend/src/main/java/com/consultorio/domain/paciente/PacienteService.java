package com.consultorio.domain.paciente;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repo;

    public PacienteService(PacienteRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public PacienteResponseDTO criar(PacienteRequestDTO dto){
        Paciente p = PacienteMapper.toEntity(dto);
        return PacienteMapper.toResponse(repo.save(p));
    }

    public List<PacienteResponseDTO> listar(){
        return repo.findAll().stream().map(PacienteMapper::toResponse).toList();
    }

    public PacienteResponseDTO buscar(Long id){
        Paciente p = repo.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        return PacienteMapper.toResponse(p);
    }

    @Transactional
    public PacienteResponseDTO atualizar(Long id, PacienteRequestDTO dto){
        Paciente p = repo.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        PacienteMapper.update(dto, p);
        return PacienteMapper.toResponse(repo.save(p));
    }

    @Transactional
    public void deletar(Long id){
        if(!repo.existsById(id)) throw new RuntimeException("Paciente não encontrado");
        repo.deleteById(id);
    }
}
