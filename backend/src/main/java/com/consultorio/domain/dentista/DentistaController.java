package com.consultorio.domain.dentista;

import com.consultorio.domain.dentista.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dentistas")
@CrossOrigin(origins = "*")
public class DentistaController {

    private final DentistaService service;

    public DentistaController(DentistaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DentistaResponseDTO> criar(@RequestBody DentistaRequestDTO dto){
        return ResponseEntity.ok(service.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<DentistaResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistaResponseDTO> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DentistaResponseDTO> atualizar(@PathVariable Long id, @RequestBody DentistaRequestDTO dto){
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
