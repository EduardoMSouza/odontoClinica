package com.consultorio.domain.ficha_medica;

import com.consultorio.domain.ficha_medica.dto.FichaMedicaMapper;
import com.consultorio.domain.ficha_medica.dto.FichaMedicaRequestDTO;
import com.consultorio.domain.ficha_medica.dto.FichaMedicaResponseDTO;
import com.consultorio.domain.paciente.Paciente;
import com.consultorio.domain.paciente.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class FichaMedicaService {

    private final FichaMedicaRepository fichaMedicaRepository;
    private final PacienteRepository pacienteRepository;

    public FichaMedicaResponseDTO criar(FichaMedicaRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com ID: " + dto.getPacienteId()));

        FichaMedica fichaMedica = FichaMedicaMapper.toEntity(dto, paciente);
        FichaMedica salva = fichaMedicaRepository.save(fichaMedica);

        return FichaMedicaMapper.toResponseDTO(salva);
    }

    @Transactional(readOnly = true)
    public FichaMedicaResponseDTO buscarPorId(Long id) {
        FichaMedica fichaMedica = fichaMedicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ficha médica não encontrada com ID: " + id));
        return FichaMedicaMapper.toResponseDTO(fichaMedica);
    }

    @Transactional(readOnly = true)
    public List<FichaMedicaResponseDTO> buscarPorPacienteId(Long pacienteId) {
        // Verifica se paciente existe
        if (!pacienteRepository.existsById(pacienteId)) {
            throw new RuntimeException("Paciente não encontrado com ID: " + pacienteId);
        }

        return fichaMedicaRepository.findByPacienteId(pacienteId)
                .stream()
                .map(FichaMedicaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<FichaMedicaResponseDTO> listarTodas() {
        return fichaMedicaRepository.findAll()
                .stream()
                .map(FichaMedicaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public void deletar(Long id) {
        if (!fichaMedicaRepository.existsById(id)) {
            throw new RuntimeException("Ficha médica não encontrada com ID: " + id);
        }
        fichaMedicaRepository.deleteById(id);
    }
}