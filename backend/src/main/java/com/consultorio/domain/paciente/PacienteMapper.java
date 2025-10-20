package com.consultorio.domain.paciente;

import com.consultorio.domain.paciente.Paciente;

public class PacienteMapper {

    public static Paciente toEntity(PacienteRequestDTO dto){
        Paciente p = new Paciente();
        p.setNome(dto.getNome());
        p.setRg(dto.getRg());
        p.setCpf(dto.getCpf());
        p.setDataNascimento(dto.getDataNascimento());
        p.setSexo(dto.getSexo());
        p.setNaturalidade(dto.getNaturalidade());
        p.setNacionalidade(dto.getNacionalidade());
        p.setEstadoCivil(dto.getEstadoCivil());
        p.setProfissao(dto.getProfissao());
        p.setTelefone(dto.getTelefone());
        p.setCelular(dto.getCelular());
        p.setEmail(dto.getEmail());
        p.setEnderecoResidencial(dto.getEnderecoResidencial());
        p.setEnderecoProfissional(dto.getEnderecoProfissional());
        p.setIndicadoPor(dto.getIndicadoPor());
        p.setConvenio(dto.getConvenio());
        p.setNumeroInscricaoConvenio(dto.getNumeroInscricaoConvenio());
        p.setCirurgiaoDentistaAnterior(dto.getCirurgiaoDentistaAnterior());
        p.setDataAtendimentoAnterior(dto.getDataAtendimentoAnterior());
        p.setResponsavelNome(dto.getResponsavelNome());
        p.setResponsavelRg(dto.getResponsavelRg());
        p.setResponsavelCpf(dto.getResponsavelCpf());
        p.setResponsavelTelefone(dto.getResponsavelTelefone());
        p.setResponsavelCelular(dto.getResponsavelCelular());
        p.setResponsavelEmail(dto.getResponsavelEmail());
        p.setResponsavelEstadoCivil(dto.getResponsavelEstadoCivil());
        p.setConjugeNome(dto.getConjugeNome());
        p.setConjugeRg(dto.getConjugeRg());
        p.setConjugeCpf(dto.getConjugeCpf());
        p.setConjugeTelefone(dto.getConjugeTelefone());
        p.setConjugeCelular(dto.getConjugeCelular());
        p.setConjugeEmail(dto.getConjugeEmail());
        return p;
    }

    public static void update(PacienteRequestDTO dto, Paciente p){
        if(dto.getNome()!=null) p.setNome(dto.getNome());
        if(dto.getRg()!=null) p.setRg(dto.getRg());
        if(dto.getCpf()!=null) p.setCpf(dto.getCpf());
        if(dto.getDataNascimento()!=null) p.setDataNascimento(dto.getDataNascimento());
        if(dto.getSexo()!=null) p.setSexo(dto.getSexo());
        if(dto.getNaturalidade()!=null) p.setNaturalidade(dto.getNaturalidade());
        if(dto.getNacionalidade()!=null) p.setNacionalidade(dto.getNacionalidade());
        if(dto.getEstadoCivil()!=null) p.setEstadoCivil(dto.getEstadoCivil());
        if(dto.getProfissao()!=null) p.setProfissao(dto.getProfissao());
        if(dto.getTelefone()!=null) p.setTelefone(dto.getTelefone());
        if(dto.getCelular()!=null) p.setCelular(dto.getCelular());
        if(dto.getEmail()!=null) p.setEmail(dto.getEmail());
        if(dto.getEnderecoResidencial()!=null) p.setEnderecoResidencial(dto.getEnderecoResidencial());
        if(dto.getEnderecoProfissional()!=null) p.setEnderecoProfissional(dto.getEnderecoProfissional());
        if(dto.getIndicadoPor()!=null) p.setIndicadoPor(dto.getIndicadoPor());
        if(dto.getConvenio()!=null) p.setConvenio(dto.getConvenio());
        if(dto.getNumeroInscricaoConvenio()!=null) p.setNumeroInscricaoConvenio(dto.getNumeroInscricaoConvenio());
        if(dto.getCirurgiaoDentistaAnterior()!=null) p.setCirurgiaoDentistaAnterior(dto.getCirurgiaoDentistaAnterior());
        if(dto.getDataAtendimentoAnterior()!=null) p.setDataAtendimentoAnterior(dto.getDataAtendimentoAnterior());
        if(dto.getResponsavelNome()!=null) p.setResponsavelNome(dto.getResponsavelNome());
        if(dto.getResponsavelRg()!=null) p.setResponsavelRg(dto.getResponsavelRg());
        if(dto.getResponsavelCpf()!=null) p.setResponsavelCpf(dto.getResponsavelCpf());
        if(dto.getResponsavelTelefone()!=null) p.setResponsavelTelefone(dto.getResponsavelTelefone());
        if(dto.getResponsavelCelular()!=null) p.setResponsavelCelular(dto.getResponsavelCelular());
        if(dto.getResponsavelEmail()!=null) p.setResponsavelEmail(dto.getResponsavelEmail());
        if(dto.getResponsavelEstadoCivil()!=null) p.setResponsavelEstadoCivil(dto.getResponsavelEstadoCivil());
        if(dto.getConjugeNome()!=null) p.setConjugeNome(dto.getConjugeNome());
        if(dto.getConjugeRg()!=null) p.setConjugeRg(dto.getConjugeRg());
        if(dto.getConjugeCpf()!=null) p.setConjugeCpf(dto.getConjugeCpf());
        if(dto.getConjugeTelefone()!=null) p.setConjugeTelefone(dto.getConjugeTelefone());
        if(dto.getConjugeCelular()!=null) p.setConjugeCelular(dto.getConjugeCelular());
        if(dto.getConjugeEmail()!=null) p.setConjugeEmail(dto.getConjugeEmail());
    }

    public static PacienteResponseDTO toResponse(Paciente p){
        return new PacienteResponseDTO(p.getId(), p.getNome(), p.getCpf(), p.getTelefone(), p.getEmail());
    }
}
