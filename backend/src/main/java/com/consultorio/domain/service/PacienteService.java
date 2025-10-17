package com.consultorio.domain.service;

import com.consultorio.domain.dto.request.PacienteRequestDTO;
import com.consultorio.domain.dto.response.PacienteResponseDTO;
import com.consultorio.domain.entity.Paciente;
import com.consultorio.domain.entity.ResponsavelTratamento;
import com.consultorio.domain.dto.mapper.PacienteMapper;
import com.consultorio.domain.repository.PacienteRepository;
import com.consultorio.domain.repository.ResponsavelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final ResponsavelRepository responsavelRepository;

    @Transactional
    public PacienteResponseDTO criarPaciente(PacienteRequestDTO dto) {
        // Validações
        if (pacienteRepository.existsByCpf(dto.getCpf())) {
            throw new IllegalArgumentException("Já existe um paciente com este CPF.");
        }
        if (pacienteRepository.existsByNumeroProntuario(dto.getNumeroProntuario())) {
            throw new IllegalArgumentException("Já existe um paciente com este número de prontuário.");
        }

        Paciente paciente = PacienteMapper.toEntity(dto);
        paciente.setDataCriacao(LocalDateTime.now());

        // Salva responsável primeiro se existir
        if (dto.getResponsavel() != null && paciente.getResponsavel() != null) {
            if (responsavelRepository.existsByCpf(paciente.getResponsavel().getCpf())) {
                throw new IllegalArgumentException("Já existe um responsável com este CPF.");
            }
            responsavelRepository.save(paciente.getResponsavel());
        }

        Paciente pacienteSalvo = pacienteRepository.save(paciente);
        return new PacienteResponseDTO(pacienteSalvo);
    }

    public List<PacienteResponseDTO> listarTodos() {
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteResponseDTO::new)
                .toList();
    }

    public PacienteResponseDTO buscarPorId(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado com ID: " + id));
        return new PacienteResponseDTO(paciente);
    }

    @Transactional
    public PacienteResponseDTO atualizarPaciente(Long id, PacienteRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado com ID: " + id));

        // Verifica se CPF foi alterado e se já existe
        if (!paciente.getCpf().equals(dto.getCpf()) && pacienteRepository.existsByCpf(dto.getCpf())) {
            throw new IllegalArgumentException("Já existe um paciente com este CPF.");
        }

        PacienteMapper.updateEntityFromDTO(dto, paciente);
        paciente.setDataAt(LocalDateTime.now());

        // Atualiza responsável se existir
        if (dto.getResponsavel() != null) {
            if (paciente.getResponsavel() == null) {
                ResponsavelTratamento responsavel = new ResponsavelTratamento();
                paciente.setResponsavel(responsavel);
            }
            // Atualiza dados do responsável
            ResponsavelTratamento responsavel = paciente.getResponsavel();
            responsavel.setNome(dto.getResponsavel().getNome());
            responsavel.setCpf(dto.getResponsavel().getCpf());
            responsavel.setNumeroRg(dto.getResponsavel().getNumeroRg());
            responsavel.setOrgaoExpedidor(dto.getResponsavel().getOrgaoExpedidor());
            responsavel.setEstadoCivil(dto.getResponsavel().getEstadoCivil());
            responsavel.setConjuge(dto.getResponsavel().getConjuge());
            responsavel.setNumeroRgConjuge(dto.getResponsavel().getNumeroRgConjuge());
            responsavel.setOrgaoExpedidorConjuge(dto.getResponsavel().getOrgaoExpedidorConjuge());
            responsavel.setCpfConjuge(dto.getResponsavel().getCpfConjuge());
        }

        Paciente pacienteAtualizado = pacienteRepository.save(paciente);
        return new PacienteResponseDTO(pacienteAtualizado);
    }

    @Transactional
    public void deletarPaciente(Long id) {
        if (!pacienteRepository.existsById(id)) {
            throw new IllegalArgumentException("Paciente não encontrado com ID: " + id);
        }
        pacienteRepository.deleteById(id);
    }

    public List<PacienteResponseDTO> buscarPorNome(String nome) {
        return pacienteRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(PacienteResponseDTO::new)
                .toList();
    }

    public PacienteResponseDTO buscarPorCpf(String cpf) {
        Paciente paciente = pacienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado com CPF: " + cpf));
        return new PacienteResponseDTO(paciente);
    }
}