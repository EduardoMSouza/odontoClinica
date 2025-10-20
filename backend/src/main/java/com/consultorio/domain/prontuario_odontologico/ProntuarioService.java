package com.consultorio.domain.prontuario_odontologico;

import com.consultorio.domain.ficha_medica.FichaMedica;
import com.consultorio.domain.ficha_medica.FichaMedicaRepository;
import com.consultorio.domain.paciente.Paciente;
import com.consultorio.domain.paciente.PacienteRepository;
import com.consultorio.domain.prontuario_odontologico.dto.*;
import com.consultorio.domain.profissional.Profissional;
import com.consultorio.domain.profissional.ProfissionalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProntuarioService {

    private final ProntuarioRepository repo;
    private final PacienteRepository pacienteRepo;
    private final ProfissionalRepository profissionalRepo;
    private final FichaMedicaRepository fichaRepo;

    public ProntuarioService(ProntuarioRepository repo,
                             PacienteRepository pacienteRepo,
                             ProfissionalRepository profissionalRepo,
                             FichaMedicaRepository fichaRepo) {
        this.repo = repo;
        this.pacienteRepo = pacienteRepo;
        this.profissionalRepo = profissionalRepo;
        this.fichaRepo = fichaRepo;
    }

    @Transactional
    public ProntuarioResponseDTO criar(ProntuarioRequestDTO dto){
        Paciente p = pacienteRepo.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        Profissional prof = profissionalRepo.findById(dto.getProfissionalId())
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));

        ProntuarioOdontologico pr = new ProntuarioOdontologico();
        pr.setNumeroProntuario(dto.getNumeroProntuario());
        pr.setPaciente(p);
        pr.setProfissional(prof);

        if(dto.getFichaMedicaId()!=null){
            FichaMedica f = fichaRepo.findById(dto.getFichaMedicaId())
                    .orElseThrow(() -> new RuntimeException("Ficha médica não encontrada"));
            pr.setFichaMedica(f);
        }

        pr.setOpcaoTratamento(dto.getOpcaoTratamento());
        pr.setPropositosOpcao1(dto.getPropositosOpcao1());
        pr.setRiscosOpcao1(dto.getRiscosOpcao1());
        pr.setCustosOpcao1(dto.getCustosOpcao1());
        pr.setPropositosOpcao2(dto.getPropositosOpcao2());
        pr.setRiscosOpcao2(dto.getRiscosOpcao2());
        pr.setCustosOpcao2(dto.getCustosOpcao2());
        pr.setPropositosOpcao3(dto.getPropositosOpcao3());
        pr.setRiscosOpcao3(dto.getRiscosOpcao3());
        pr.setCustosOpcao3(dto.getCustosOpcao3());
        pr.setDataConsentimento(dto.getDataConsentimento());
        pr.setAssinaturaPaciente(dto.getAssinaturaPaciente());
        pr.setAssinaturaProfissional(dto.getAssinaturaProfissional());

        pr = repo.save(pr);

        return new ProntuarioResponseDTO(
                pr.getId(),
                pr.getNumeroProntuario(),
                p.getId(),
                p.getNome(),
                prof.getId(),
                prof.getNome(),
                pr.getFichaMedica()!=null ? pr.getFichaMedica().getId() : null,
                pr.getOpcaoTratamento()
        );
    }

    public List<ProntuarioResponseDTO> listar(){
        return repo.findAll().stream().map(pr -> new ProntuarioResponseDTO(
                pr.getId(),
                pr.getNumeroProntuario(),
                pr.getPaciente().getId(),
                pr.getPaciente().getNome(),
                pr.getProfissional().getId(),
                pr.getProfissional().getNome(),
                pr.getFichaMedica()!=null ? pr.getFichaMedica().getId() : null,
                pr.getOpcaoTratamento()
        )).toList();
    }

    public ProntuarioResponseDTO buscar(Long id){
        ProntuarioOdontologico pr = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuário não encontrado"));
        return new ProntuarioResponseDTO(
                pr.getId(),
                pr.getNumeroProntuario(),
                pr.getPaciente().getId(),
                pr.getPaciente().getNome(),
                pr.getProfissional().getId(),
                pr.getProfissional().getNome(),
                pr.getFichaMedica()!=null ? pr.getFichaMedica().getId() : null,
                pr.getOpcaoTratamento()
        );
    }

    @Transactional
    public void deletar(Long id){
        if(!repo.existsById(id)) throw new RuntimeException("Prontuário não encontrado");
        repo.deleteById(id);
    }
}
