package com.consultorio.domain.agenda;

import com.consultorio.domain.agenda.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
@CrossOrigin(origins = "*")
public class AgendaController {

    private final AgendaService service;

    public AgendaController(AgendaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AgendaResponseDTO> agendar(@RequestBody AgendaRequestDTO dto){
        return ResponseEntity.ok(service.agendar(dto));
    }

    @GetMapping
    public ResponseEntity<List<AgendaResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendaResponseDTO> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<AgendaResponseDTO> atualizarStatus(@PathVariable Long id, @RequestParam String status){
        return ResponseEntity.ok(service.atualizarStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable Long id){
        service.cancelar(id);
        return ResponseEntity.noContent().build();
    }
}
