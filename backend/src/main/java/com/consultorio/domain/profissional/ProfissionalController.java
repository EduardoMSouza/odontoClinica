package com.consultorio.domain.profissional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profissionais")
@CrossOrigin(origins = "*")
public class ProfissionalController {

    private final ProfissionalService service;

    public ProfissionalController(ProfissionalService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Profissional> criar(@RequestBody Profissional p){
        return ResponseEntity.ok(service.criar(p));
    }

    @GetMapping
    public ResponseEntity<List<Profissional>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profissional> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profissional> atualizar(@PathVariable Long id, @RequestBody Profissional payload){
        return ResponseEntity.ok(service.atualizar(id, payload));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
