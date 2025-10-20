package com.consultorio.domain.profissional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProfissionalService {

    private final ProfissionalRepository repo;

    public ProfissionalService(ProfissionalRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Profissional criar(Profissional p){ return repo.save(p); }

    public List<Profissional> listar(){ return repo.findAll(); }

    public Profissional buscar(Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Profissional não encontrado"));
    }

    @Transactional
    public Profissional atualizar(Long id, Profissional payload){
        Profissional p = buscar(id);
        if(payload.getNome()!=null) p.setNome(payload.getNome());
        if(payload.getCrosp()!=null) p.setCrosp(payload.getCrosp());
        if(payload.getEnderecoCompleto()!=null) p.setEnderecoCompleto(payload.getEnderecoCompleto());
        return repo.save(p);
    }

    @Transactional
    public void deletar(Long id){
        if(!repo.existsById(id)) throw new RuntimeException("Profissional não encontrado");
        repo.deleteById(id);
    }
}
