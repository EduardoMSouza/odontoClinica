package com.consultorio.domain.dto.mapper;

import com.consultorio.domain.dto.request.FichaMedicaRequestDTO;
import com.consultorio.domain.entity.FichaMedica;
import com.consultorio.domain.entity.Paciente;

public class FichaMedicaMapper {

    public static FichaMedica toEntity(FichaMedicaRequestDTO dto, Paciente paciente) {
        FichaMedica fichaMedica = new FichaMedica();
        fichaMedica.setPaciente(paciente);

        // Dados de saúde geral
        fichaMedica.setProblemasRespiratorios(dto.getProblemasRespiratorios());
        fichaMedica.setProblemasAlergicos(dto.getProblemasAlergicos());
        fichaMedica.setProblemasArticulares(dto.getProblemasArticulares());
        fichaMedica.setDiabetes(dto.getDiabetes());

        // Questionário de Saúde
        fichaMedica.setSofreDoenca(dto.getSofreDoenca());
        fichaMedica.setQuaisDoencas(dto.getQuaisDoencas());
        fichaMedica.setEmTratamentoMedico(dto.getEmTratamentoMedico());
        fichaMedica.setGravidez(dto.getGravidez());
        fichaMedica.setUsandoMedicacao(dto.getUsandoMedicacao());
        fichaMedica.setQuaisMedicamentos(dto.getQuaisMedicamentos());
        fichaMedica.setNomeMedicoAssistente(dto.getNomeMedicoAssistente());
        fichaMedica.setTelefoneMedicoAssistente(dto.getTelefoneMedicoAssistente());
        fichaMedica.setTeveAlergia(dto.getTeveAlergia());
        fichaMedica.setQuaisAlergias(dto.getQuaisAlergias());
        fichaMedica.setJaOperado(dto.getJaOperado());
        fichaMedica.setQuaisCirurgias(dto.getQuaisCirurgias());
        fichaMedica.setProblemasCicatrizacao(dto.getProblemasCicatrizacao());
        fichaMedica.setProblemasAnestesia(dto.getProblemasAnestesia());
        fichaMedica.setProblemasHemorragia(dto.getProblemasHemorragia());

        // Outras informações
        fichaMedica.setQueixaPrincipal(dto.getQueixaPrincipal());
        fichaMedica.setHabitos(dto.getHabitos());
        fichaMedica.setAntecedentesFamiliares(dto.getAntecedentesFamiliares());

        // Inspeção da boca e da face
        fichaMedica.setLingua(dto.getLingua());
        fichaMedica.setMucosa(dto.getMucosa());
        fichaMedica.setPalato(dto.getPalato());
        fichaMedica.setFace(dto.getFace());
        fichaMedica.setLabios(dto.getLabios());
        fichaMedica.setAlteracaoOclusao(dto.getAlteracaoOclusao());
        fichaMedica.setTipoAlteracaoOclusao(dto.getTipoAlteracaoOclusao());
        fichaMedica.setUsaProtese(dto.getUsaProtese());
        fichaMedica.setTipoProtese(dto.getTipoProtese());
        fichaMedica.setGengivas(dto.getGengivas());
        fichaMedica.setNariz(dto.getNariz());
        fichaMedica.setGanglios(dto.getGanglios());
        fichaMedica.setGlandulasSalivares(dto.getGlandulasSalivares());
        fichaMedica.setOutrasObservacoes(dto.getOutrasObservacoes());

        return fichaMedica;
    }

    public static void updateEntityFromDTO(FichaMedicaRequestDTO dto, FichaMedica fichaMedica) {
        // Atualiza todos os campos (mesmo do toEntity, mas sem paciente)
        fichaMedica.setProblemasRespiratorios(dto.getProblemasRespiratorios());
        fichaMedica.setProblemasAlergicos(dto.getProblemasAlergicos());
        fichaMedica.setProblemasArticulares(dto.getProblemasArticulares());
        fichaMedica.setDiabetes(dto.getDiabetes());
        fichaMedica.setSofreDoenca(dto.getSofreDoenca());
        fichaMedica.setQuaisDoencas(dto.getQuaisDoencas());
        fichaMedica.setEmTratamentoMedico(dto.getEmTratamentoMedico());
        fichaMedica.setGravidez(dto.getGravidez());
        fichaMedica.setUsandoMedicacao(dto.getUsandoMedicacao());
        fichaMedica.setQuaisMedicamentos(dto.getQuaisMedicamentos());
        fichaMedica.setNomeMedicoAssistente(dto.getNomeMedicoAssistente());
        fichaMedica.setTelefoneMedicoAssistente(dto.getTelefoneMedicoAssistente());
        fichaMedica.setTeveAlergia(dto.getTeveAlergia());
        fichaMedica.setQuaisAlergias(dto.getQuaisAlergias());
        fichaMedica.setJaOperado(dto.getJaOperado());
        fichaMedica.setQuaisCirurgias(dto.getQuaisCirurgias());
        fichaMedica.setProblemasCicatrizacao(dto.getProblemasCicatrizacao());
        fichaMedica.setProblemasAnestesia(dto.getProblemasAnestesia());
        fichaMedica.setProblemasHemorragia(dto.getProblemasHemorragia());
        fichaMedica.setQueixaPrincipal(dto.getQueixaPrincipal());
        fichaMedica.setHabitos(dto.getHabitos());
        fichaMedica.setAntecedentesFamiliares(dto.getAntecedentesFamiliares());
        fichaMedica.setLingua(dto.getLingua());
        fichaMedica.setMucosa(dto.getMucosa());
        fichaMedica.setPalato(dto.getPalato());
        fichaMedica.setFace(dto.getFace());
        fichaMedica.setLabios(dto.getLabios());
        fichaMedica.setAlteracaoOclusao(dto.getAlteracaoOclusao());
        fichaMedica.setTipoAlteracaoOclusao(dto.getTipoAlteracaoOclusao());
        fichaMedica.setUsaProtese(dto.getUsaProtese());
        fichaMedica.setTipoProtese(dto.getTipoProtese());
        fichaMedica.setGengivas(dto.getGengivas());
        fichaMedica.setNariz(dto.getNariz());
        fichaMedica.setGanglios(dto.getGanglios());
        fichaMedica.setGlandulasSalivares(dto.getGlandulasSalivares());
        fichaMedica.setOutrasObservacoes(dto.getOutrasObservacoes());
    }
}