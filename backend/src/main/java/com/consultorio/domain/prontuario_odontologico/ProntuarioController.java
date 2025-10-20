package com.consultorio.domain.prontuario_odontologico;

import com.consultorio.domain.prontuario_odontologico.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prontuarios")
@CrossOrigin(origins = "*")
public class ProntuarioController {

    private final ProntuarioService service;

    public ProntuarioController(ProntuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProntuarioResponseDTO> criar(@RequestBody ProntuarioRequestDTO dto){
        return ResponseEntity.ok(service.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ProntuarioResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProntuarioResponseDTO> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
