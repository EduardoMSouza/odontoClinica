package com.consultorio.domain.service;


import com.consultorio.domain.dto.request.ResponsavelRequestDTO;
import com.consultorio.domain.dto.response.ResponsavelResponseDTO;
import com.consultorio.domain.entity.ResponsavelTratamento;
import com.consultorio.domain.repository.PacienteRepository;
import com.consultorio.domain.repository.ResponsavelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResponsavelService {

    private final ResponsavelRepository responsavelRepository;
    private final PacienteRepository pacienteRepository;

    public ResponsavelResponseDTO buscarPorId(Long id) {
        ResponsavelTratamento responsavel = responsavelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Responsável não encontrado com ID: " + id));
        return new ResponsavelResponseDTO(responsavel);
    }

    public ResponsavelResponseDTO buscarPorCpf(String cpf) {
        ResponsavelTratamento responsavel = responsavelRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Responsável não encontrado com CPF: " + cpf));
        return new ResponsavelResponseDTO(responsavel);
    }

    public List<ResponsavelResponseDTO> listarTodos() {
        return responsavelRepository.findAll()
                .stream()
                .map(ResponsavelResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ResponsavelResponseDTO atualizarResponsavel(Long id, ResponsavelRequestDTO dto) {
        ResponsavelTratamento responsavel = responsavelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Responsável não encontrado com ID: " + id));

        // Atualiza dados
        responsavel.setNome(dto.getNome());
        responsavel.setCpf(dto.getCpf());
        responsavel.setNumeroRg(dto.getNumeroRg());
        responsavel.setOrgaoExpedidor(dto.getOrgaoExpedidor());
        responsavel.setEstadoCivil(dto.getEstadoCivil());
        responsavel.setConjuge(dto.getConjuge());
        responsavel.setNumeroRgConjuge(dto.getNumeroRgConjuge());
        responsavel.setOrgaoExpedidorConjuge(dto.getOrgaoExpedidorConjuge());
        responsavel.setCpfConjuge(dto.getCpfConjuge());

        ResponsavelTratamento responsavelAtualizado = responsavelRepository.save(responsavel);
        return new ResponsavelResponseDTO(responsavelAtualizado);
    }

    @Transactional
    public void deletarResponsavel(Long id) {
        // Verifica se existem pacientes vinculados a este responsável
        List<com.consultorio.domain.entity.Paciente> pacientes = pacienteRepository.findByResponsavelId(id);
        if (!pacientes.isEmpty()) {
            throw new IllegalStateException("Não é possível excluir o responsável pois existem pacientes vinculados a ele.");
        }

        if (!responsavelRepository.existsById(id)) {
            throw new IllegalArgumentException("Responsável não encontrado com ID: " + id);
        }
        responsavelRepository.deleteById(id);
    }
}