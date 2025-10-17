package com.consultorio.domain.dto.mapper;

import com.consultorio.domain.dto.request.PacienteRequestDTO;
import com.consultorio.domain.entity.Paciente;
import com.consultorio.domain.entity.ResponsavelTratamento;

public class PacienteMapper {

    public static Paciente toEntity(PacienteRequestDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setCpf(dto.getCpf());
        paciente.setNumeroProntuario(dto.getNumeroProntuario());
        paciente.setNome(dto.getNome());
        paciente.setTelefone(dto.getTelefone());
        paciente.setNumeroRg(dto.getNumeroRg());
        paciente.setOrgaoExpedidorRg(dto.getOrgaoExpedidorRg());
        paciente.setDataNascimento(dto.getDataNascimento());
        paciente.setSexo(dto.getSexo());
        paciente.setNaturalidade(dto.getNaturalidade());
        paciente.setNacionalidade(dto.getNacionalidade());
        paciente.setEstadoCivil(dto.getEstadoCivil());
        paciente.setProfissao(dto.getProfissao());
        paciente.setEnderecoResidencial(dto.getEnderecoResidencial());
        paciente.setIndicadoPor(dto.getIndicadoPor());
        paciente.setConvenio(dto.getConvenio());
        paciente.setNumeroInscricao(dto.getNumeroInscricao());

        if (dto.getResponsavel() != null) {
            ResponsavelTratamento responsavel = new ResponsavelTratamento();
            responsavel.setNome(dto.getResponsavel().getNome());
            responsavel.setNumeroRg(dto.getResponsavel().getNumeroRg());
            responsavel.setOrgaoExpedidor(dto.getResponsavel().getOrgaoExpedidor());
            responsavel.setCpf(dto.getResponsavel().getCpf());
            responsavel.setEstadoCivil(dto.getResponsavel().getEstadoCivil());
            responsavel.setConjuge(dto.getResponsavel().getConjuge());
            responsavel.setNumeroRgConjuge(dto.getResponsavel().getNumeroRgConjuge());
            responsavel.setOrgaoExpedidorConjuge(dto.getResponsavel().getOrgaoExpedidorConjuge());
            responsavel.setCpfConjuge(dto.getResponsavel().getCpfConjuge());
            paciente.setResponsavel(responsavel);
        }

        return paciente;
    }

    public static void updateEntityFromDTO(PacienteRequestDTO dto, Paciente paciente) {
        paciente.setNome(dto.getNome());
        paciente.setTelefone(dto.getTelefone());
        paciente.setNumeroRg(dto.getNumeroRg());
        paciente.setOrgaoExpedidorRg(dto.getOrgaoExpedidorRg());
        paciente.setDataNascimento(dto.getDataNascimento());
        paciente.setSexo(dto.getSexo());
        paciente.setNaturalidade(dto.getNaturalidade());
        paciente.setNacionalidade(dto.getNacionalidade());
        paciente.setEstadoCivil(dto.getEstadoCivil());
        paciente.setProfissao(dto.getProfissao());
        paciente.setEnderecoResidencial(dto.getEnderecoResidencial());
        paciente.setIndicadoPor(dto.getIndicadoPor());
        paciente.setConvenio(dto.getConvenio());
        paciente.setNumeroInscricao(dto.getNumeroInscricao());
    }
}