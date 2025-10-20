package com.consultorio.domain.ficha_medica.dto;

import com.consultorio.domain.ficha_medica.FichaMedica;
import com.consultorio.domain.paciente.Paciente;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FichaMedicaMapper {

    public static FichaMedica toEntity(FichaMedicaRequestDTO dto, Paciente paciente) {
        FichaMedica f = new FichaMedica();

        f.setPaciente(paciente);
        f.setQueixaPrincipal(dto.getQueixaPrincipal());

        // Anamnese
        f.setTomandoMedicamento(dto.isTomandoMedicamento());
        f.setMedicamentosPosologia(dto.getMedicamentosPosologia());
        f.setTemAlergia(dto.isTemAlergia());
        f.setTipoAlergia(dto.getTipoAlergia());
        f.setPressao(dto.getPressao());
        f.setProblemaCardiaco(dto.isProblemaCardiaco());
        f.setTipoProblemaCardiaco(dto.getTipoProblemaCardiaco());
        f.setFaltaAr(dto.isFaltaAr());
        f.setDiabetes(dto.isDiabetes());
        f.setSangramento(dto.getSangramento());
        f.setCicatrizacao(dto.getCicatrizacao());
        f.setCirurgia(dto.isCirurgia());
        f.setGestante(dto.isGestante());
        f.setSemanasGestacao(dto.getSemanasGestacao());
        f.setProblemasSaude(dto.getProblemasSaude());
        f.setReacaoAnestesia(dto.isReacaoAnestesia());
        f.setTipoReacaoAnestesia(dto.getTipoReacaoAnestesia());
        f.setUltimoTratamentoDentario(dto.getUltimoTratamentoDentario());
        f.setDorDentesGengiva(dto.isDorDentesGengiva());
        f.setGengivaSangra(dto.isGengivaSangra());
        f.setGengivaSangraHigiene(dto.isGengivaSangraHigiene());
        f.setGengivaSangraAsVezes(dto.isGengivaSangraAsVezes());
        f.setGostoRuimBocaSeca(dto.isGostoRuimBocaSeca());
        f.setEscovacaoDiaria(dto.getEscovacaoDiaria());
        f.setUsaFioDental(dto.isUsaFioDental());
        f.setUsaFioDentalDiariamente(dto.isUsaFioDentalDiariamente());
        f.setDorEstaloMaxilarOuvido(dto.isDorEstaloMaxilarOuvido());
        f.setRangeDentes(dto.isRangeDentes());
        f.setFeridaBolhaFaceLabios(dto.isFeridaBolhaFaceLabios());
        f.setFuma(dto.isFuma());
        f.setQuantidadeFumo(dto.getQuantidadeFumo());

        // Queixa 1
        f.setLocalizacaoQueixa1(dto.getLocalizacaoQueixa1());
        f.setQualidadeQueixa1(dto.getQualidadeQueixa1());
        f.setDuracaoQueixa1(dto.getDuracaoQueixa1());
        f.setInicioQueixa1(dto.getInicioQueixa1());
        f.setIntensidadeQueixa1(dto.getIntensidadeQueixa1());
        f.setFrequenciaQueixa1(dto.getFrequenciaQueixa1());
        f.setPioraSintomasQueixa1(dto.getPioraSintomasQueixa1());
        f.setMelhoraSintomasQueixa1(dto.getMelhoraSintomasQueixa1());
        f.setHorarioPiorDorQueixa1(dto.getHorarioPiorDorQueixa1());
        f.setAcordaPorDorQueixa1(dto.isAcordaPorDorQueixa1());
        f.setAcordaComDorQueixa1(dto.isAcordaComDorQueixa1());
        f.setEventosRelacionadosQueixa1(dto.getEventosRelacionadosQueixa1());
        f.setProcurouProfissionalQueixa1(dto.isProcurouProfissionalQueixa1());
        f.setProfissionalProcuradoQueixa1(dto.getProfissionalProcuradoQueixa1());
        f.setNumeroTratamentosQueixa1(dto.getNumeroTratamentosQueixa1());
        f.setAtividadesAfetadasQueixa1(dto.getAtividadesAfetadasQueixa1());
        f.setSenteDorAgoraQueixa1(dto.isSenteDorAgoraQueixa1());
        f.setEscalaDorQueixa1(dto.getEscalaDorQueixa1());

        // Queixa 2
        f.setLocalizacaoQueixa2(dto.getLocalizacaoQueixa2());
        f.setQualidadeQueixa2(dto.getQualidadeQueixa2());
        f.setDuracaoQueixa2(dto.getDuracaoQueixa2());
        f.setInicioQueixa2(dto.getInicioQueixa2());
        f.setIntensidadeQueixa2(dto.getIntensidadeQueixa2());
        f.setFrequenciaQueixa2(dto.getFrequenciaQueixa2());
        f.setPioraSintomasQueixa2(dto.getPioraSintomasQueixa2());
        f.setMelhoraSintomasQueixa2(dto.getMelhoraSintomasQueixa2());
        f.setHorarioPiorDorQueixa2(dto.getHorarioPiorDorQueixa2());
        f.setAcordaPorDorQueixa2(dto.isAcordaPorDorQueixa2());
        f.setAcordaComDorQueixa2(dto.isAcordaComDorQueixa2());
        f.setEventosRelacionadosQueixa2(dto.getEventosRelacionadosQueixa2());
        f.setProcurouProfissionalQueixa2(dto.isProcurouProfissionalQueixa2());
        f.setProfissionalProcuradoQueixa2(dto.getProfissionalProcuradoQueixa2());
        f.setNumeroTratamentosQueixa2(dto.getNumeroTratamentosQueixa2());
        f.setAtividadesAfetadasQueixa2(dto.getAtividadesAfetadasQueixa2());
        f.setSenteDorAgoraQueixa2(dto.isSenteDorAgoraQueixa2());
        f.setEscalaDorQueixa2(dto.getEscalaDorQueixa2());

        // Historia
        f.setSaudeGeral(dto.getSaudeGeral());
        f.setSaudeOral(dto.getSaudeOral());
        f.setMulherGravida(dto.isMulherGravida());
        f.setSemanasGravidez(dto.getSemanasGravidez());
        f.setClimatério(dto.isClimatério());
        f.setMenopausa(dto.isMenopausa());
        f.setTratamentoMedico(dto.isTratamentoMedico());
        f.setTratamentosMedicos(dto.getTratamentosMedicos());
        f.setCondicoesMedicas(dto.getCondicoesMedicas());
        f.setCondicoesFamiliares(dto.isCondicoesFamiliares());
        f.setCondicoesFamiliaresDetalhes(dto.getCondicoesFamiliaresDetalhes());
        f.setMedicamentosAtuais(dto.getMedicamentosAtuais());
        f.setUsaChasFitoterapia(dto.isUsaChasFitoterapia());
        f.setChasFitoterapiaDetalhes(dto.getChasFitoterapiaDetalhes());
        f.setHistoriaMedica(dto.getHistoriaMedica());

        // Exame Clinico
        f.setAssimetriaFacial(dto.isAssimetriaFacial());
        f.setPrognatismo(dto.isPrognatismo());
        f.setRetrognatismo(dto.isRetrognatismo());
        f.setLaterognatismo(dto.getLaterognatismo());
        f.setDesdentadoTotal(dto.isDesdentadoTotal());
        f.setProtese(dto.isProtese());
        f.setPerdaDVO(dto.isPerdaDVO());
        f.setMordidaAberta(dto.getMordidaAberta());
        f.setMordidaCruzada(dto.getMordidaCruzada());
        f.setSobremordidaProfunda(dto.isSobremordidaProfunda());

        // Exame Físico
        f.setPeso(dto.getPeso());
        f.setAltura(dto.getAltura());
        f.setFrequenciaCardiaca(dto.getFrequenciaCardiaca());
        f.setPressaoArterial(dto.getPressaoArterial());
        f.setCondicoesDentarias(dto.getCondicoesDentarias());

        return f;
    }

    public static FichaMedicaResponseDTO toResponseDTO(FichaMedica f) {
        FichaMedicaResponseDTO dto = new FichaMedicaResponseDTO();
        dto.setId(f.getId());
        dto.setPacienteId(f.getPaciente() != null ? f.getPaciente().getId() : null);
        dto.setPacienteNome(f.getPaciente() != null ? f.getPaciente().getNome() : null);
        dto.setQueixaPrincipal(f.getQueixaPrincipal());
        dto.setDataCriacao(f.getDataCriacao());

        // Anamnese
        FichaMedicaResponseDTO.AnamneseDTO anamnese = new FichaMedicaResponseDTO.AnamneseDTO();
        anamnese.setTomandoMedicamento(f.isTomandoMedicamento());
        anamnese.setMedicamentosPosologia(f.getMedicamentosPosologia());
        anamnese.setTemAlergia(f.isTemAlergia());
        anamnese.setTipoAlergia(f.getTipoAlergia());
        anamnese.setPressao(f.getPressao());
        anamnese.setProblemaCardiaco(f.isProblemaCardiaco());
        anamnese.setTipoProblemaCardiaco(f.getTipoProblemaCardiaco());
        anamnese.setFaltaAr(f.isFaltaAr());
        anamnese.setDiabetes(f.isDiabetes());
        anamnese.setSangramento(f.getSangramento());
        anamnese.setCicatrizacao(f.getCicatrizacao());
        anamnese.setCirurgia(f.isCirurgia());
        anamnese.setGestante(f.isGestante());
        anamnese.setSemanasGestacao(f.getSemanasGestacao());
        anamnese.setProblemasSaude(f.getProblemasSaude());
        anamnese.setReacaoAnestesia(f.isReacaoAnestesia());
        anamnese.setTipoReacaoAnestesia(f.getTipoReacaoAnestesia());
        anamnese.setUltimoTratamentoDentario(f.getUltimoTratamentoDentario());
        anamnese.setDorDentesGengiva(f.isDorDentesGengiva());
        anamnese.setGengivaSangra(f.isGengivaSangra());
        anamnese.setGengivaSangraHigiene(f.isGengivaSangraHigiene());
        anamnese.setGengivaSangraAsVezes(f.isGengivaSangraAsVezes());
        anamnese.setGostoRuimBocaSeca(f.isGostoRuimBocaSeca());
        anamnese.setEscovacaoDiaria(f.getEscovacaoDiaria());
        anamnese.setUsaFioDental(f.isUsaFioDental());
        anamnese.setUsaFioDentalDiariamente(f.isUsaFioDentalDiariamente());
        anamnese.setDorEstaloMaxilarOuvido(f.isDorEstaloMaxilarOuvido());
        anamnese.setRangeDentes(f.isRangeDentes());
        anamnese.setFeridaBolhaFaceLabios(f.isFeridaBolhaFaceLabios());
        anamnese.setFuma(f.isFuma());
        anamnese.setQuantidadeFumo(f.getQuantidadeFumo());

        dto.setAnamnese(anamnese);

        // Queixa 1
        FichaMedicaResponseDTO.QueixaDTO q1 = new FichaMedicaResponseDTO.QueixaDTO();
        q1.setLocalizacao(f.getLocalizacaoQueixa1());
        q1.setQualidade(f.getQualidadeQueixa1());
        q1.setDuracao(f.getDuracaoQueixa1());
        q1.setInicio(f.getInicioQueixa1());
        q1.setIntensidade(f.getIntensidadeQueixa1());
        q1.setFrequencia(f.getFrequenciaQueixa1());
        q1.setPioraSintomas(f.getPioraSintomasQueixa1());
        q1.setMelhoraSintomas(f.getMelhoraSintomasQueixa1());
        q1.setHorarioPiorDor(f.getHorarioPiorDorQueixa1());
        q1.setAcordaPorDor(f.isAcordaPorDorQueixa1());
        q1.setAcordaComDor(f.isAcordaComDorQueixa1());
        q1.setEventosRelacionados(f.getEventosRelacionadosQueixa1());
        q1.setProcurouProfissional(f.isProcurouProfissionalQueixa1());
        q1.setProfissionalProcurado(f.getProfissionalProcuradoQueixa1());
        q1.setNumeroTratamentos(f.getNumeroTratamentosQueixa1());
        q1.setAtividadesAfetadas(f.getAtividadesAfetadasQueixa1());
        q1.setSenteDorAgora(f.isSenteDorAgoraQueixa1());
        q1.setEscalaDor(f.getEscalaDorQueixa1());
        dto.setQueixa1(q1);

        // Queixa 2
        FichaMedicaResponseDTO.QueixaDTO q2 = new FichaMedicaResponseDTO.QueixaDTO();
        q2.setLocalizacao(f.getLocalizacaoQueixa2());
        q2.setQualidade(f.getQualidadeQueixa2());
        q2.setDuracao(f.getDuracaoQueixa2());
        q2.setInicio(f.getInicioQueixa2());
        q2.setIntensidade(f.getIntensidadeQueixa2());
        q2.setFrequencia(f.getFrequenciaQueixa2());
        q2.setPioraSintomas(f.getPioraSintomasQueixa2());
        q2.setMelhoraSintomas(f.getMelhoraSintomasQueixa2());
        q2.setHorarioPiorDor(f.getHorarioPiorDorQueixa2());
        q2.setAcordaPorDor(f.isAcordaPorDorQueixa2());
        q2.setAcordaComDor(f.isAcordaComDorQueixa2());
        q2.setEventosRelacionados(f.getEventosRelacionadosQueixa2());
        q2.setProcurouProfissional(f.isProcurouProfissionalQueixa2());
        q2.setProfissionalProcurado(f.getProfissionalProcuradoQueixa2());
        q2.setNumeroTratamentos(f.getNumeroTratamentosQueixa2());
        q2.setAtividadesAfetadas(f.getAtividadesAfetadasQueixa2());
        q2.setSenteDorAgora(f.isSenteDorAgoraQueixa2());
        q2.setEscalaDor(f.getEscalaDorQueixa2());
        dto.setQueixa2(q2);

        // Historia
        FichaMedicaResponseDTO.HistoriaDTO history = new FichaMedicaResponseDTO.HistoriaDTO();
        history.setSaudeGeral(f.getSaudeGeral());
        history.setSaudeOral(f.getSaudeOral());
        history.setMulherGravida(f.isMulherGravida());
        history.setSemanasGravidez(f.getSemanasGravidez());
        history.setClimatério(f.isClimatério());
        history.setMenopausa(f.isMenopausa());
        history.setTratamentoMedico(f.isTratamentoMedico());
        history.setTratamentosMedicos(f.getTratamentosMedicos());
        history.setCondicoesMedicas(f.getCondicoesMedicas());
        history.setCondicoesFamiliares(f.isCondicoesFamiliares());
        history.setCondicoesFamiliaresDetalhes(f.getCondicoesFamiliaresDetalhes());
        history.setMedicamentosAtuais(f.getMedicamentosAtuais());
        history.setUsaChasFitoterapia(f.isUsaChasFitoterapia());
        history.setChasFitoterapiaDetalhes(f.getChasFitoterapiaDetalhes());
        history.setHistoriaMedica(f.getHistoriaMedica());
        dto.setHistoria(history);

        // Exame Clinico
        FichaMedicaResponseDTO.ExameClinicoDTO exClinico = new FichaMedicaResponseDTO.ExameClinicoDTO();
        exClinico.setAssimetriaFacial(f.isAssimetriaFacial());
        exClinico.setPrognatismo(f.isPrognatismo());
        exClinico.setRetrognatismo(f.isRetrognatismo());
        exClinico.setLaterognatismo(f.getLaterognatismo());
        exClinico.setDesdentadoTotal(f.isDesdentadoTotal());
        exClinico.setProtese(f.isProtese());
        exClinico.setPerdaDVO(f.isPerdaDVO());
        exClinico.setMordidaAberta(f.getMordidaAberta());
        exClinico.setMordidaCruzada(f.getMordidaCruzada());
        exClinico.setSobremordidaProfunda(f.isSobremordidaProfunda());
        dto.setExameClinico(exClinico);

        // Exame Físico
        FichaMedicaResponseDTO.ExameFisicoDTO exFisico = new FichaMedicaResponseDTO.ExameFisicoDTO();
        exFisico.setPeso(f.getPeso());
        exFisico.setAltura(f.getAltura());
        exFisico.setFrequenciaCardiaca(f.getFrequenciaCardiaca());
        exFisico.setPressaoArterial(f.getPressaoArterial());
        exFisico.setCondicoesDentarias(f.getCondicoesDentarias());
        dto.setExameFisico(exFisico);

        return dto;
    }
}
