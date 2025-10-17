package com.consultorio.domain.service;

import com.consultorio.domain.dto.request.FichaMedicaRequestDTO;
import com.consultorio.domain.dto.response.FichaMedicaResponseDTO;
import com.consultorio.domain.entity.FichaMedica;
import com.consultorio.domain.entity.Paciente;
import com.consultorio.domain.dto.mapper.FichaMedicaMapper;
import com.consultorio.domain.repository.FichaMedicaRepository;
import com.consultorio.domain.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FichaMedicaService {

    private final FichaMedicaRepository fichaMedicaRepository;
    private final PacienteRepository pacienteRepository;

    @Transactional
    public FichaMedicaResponseDTO criarFichaMedica(FichaMedicaRequestDTO dto) {
        // Valida se paciente existe
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado com ID: " + dto.getPacienteId()));

        FichaMedica fichaMedica = FichaMedicaMapper.toEntity(dto, paciente);
        fichaMedica.setDataCriacao(LocalDateTime.now());

        FichaMedica fichaSalva = fichaMedicaRepository.save(fichaMedica);
        return new FichaMedicaResponseDTO(fichaSalva);
    }

    public FichaMedicaResponseDTO buscarPorId(Long id) {
        FichaMedica fichaMedica = fichaMedicaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ficha médica não encontrada com ID: " + id));
        return new FichaMedicaResponseDTO(fichaMedica);
    }

    public List<FichaMedicaResponseDTO> buscarPorPacienteId(Long pacienteId) {
        // Valida se paciente existe
        if (!pacienteRepository.existsById(pacienteId)) {
            throw new IllegalArgumentException("Paciente não encontrado com ID: " + pacienteId);
        }

        return fichaMedicaRepository.findByPacienteId(pacienteId)
                .stream()
                .map(FichaMedicaResponseDTO::new)
                .toList();
    }

    public List<FichaMedicaResponseDTO> buscarPorNomePaciente(String nomePaciente) {
        return fichaMedicaRepository.findByPacienteNomeContaining(nomePaciente)
                .stream()
                .map(FichaMedicaResponseDTO::new)
                .toList();
    }

    @Transactional
    public FichaMedicaResponseDTO atualizarFichaMedica(Long id, FichaMedicaRequestDTO dto) {
        FichaMedica fichaMedica = fichaMedicaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ficha médica não encontrada com ID: " + id));

        // Valida se paciente foi alterado (não permitido)
        if (!fichaMedica.getPaciente().getId().equals(dto.getPacienteId())) {
            throw new IllegalArgumentException("Não é permitido alterar o paciente da ficha médica.");
        }

        FichaMedicaMapper.updateEntityFromDTO(dto, fichaMedica);
        FichaMedica fichaAtualizada = fichaMedicaRepository.save(fichaMedica);
        return new FichaMedicaResponseDTO(fichaAtualizada);
    }

    @Transactional
    public void deletarFichaMedica(Long id) {
        if (!fichaMedicaRepository.existsById(id)) {
            throw new IllegalArgumentException("Ficha médica não encontrada com ID: " + id);
        }
        fichaMedicaRepository.deleteById(id);
    }

    public boolean pacienteTemFichaMedica(Long pacienteId) {
        return fichaMedicaRepository.existsByPacienteId(pacienteId);
    }

    public long contarFichasPorPaciente(Long pacienteId) {
        return fichaMedicaRepository.countByPacienteId(pacienteId);
    }
}