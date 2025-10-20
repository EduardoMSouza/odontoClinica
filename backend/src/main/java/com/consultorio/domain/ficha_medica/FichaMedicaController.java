package com.consultorio.domain.ficha_medica;

import com.consultorio.domain.ficha_medica.dto.FichaMedicaRequestDTO;
import com.consultorio.domain.ficha_medica.dto.FichaMedicaResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fichas-medicas")
@RequiredArgsConstructor
@Tag(name = "Fichas Médicas", description = "API para gerenciamento de fichas médicas")
public class FichaMedicaController {

    private final FichaMedicaService fichaMedicaService;

    @PostMapping
    @Operation(summary = "Criar uma nova ficha médica")
    public ResponseEntity<FichaMedicaResponseDTO> criar(@Valid @RequestBody FichaMedicaRequestDTO dto) {
        FichaMedicaResponseDTO response = fichaMedicaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar ficha médica por ID")
    public ResponseEntity<FichaMedicaResponseDTO> buscarPorId(@PathVariable Long id) {
        FichaMedicaResponseDTO response = fichaMedicaService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/paciente/{pacienteId}")
    @Operation(summary = "Listar fichas médicas por paciente")
    public ResponseEntity<List<FichaMedicaResponseDTO>> buscarPorPaciente(@PathVariable Long pacienteId) {
        List<FichaMedicaResponseDTO> response = fichaMedicaService.buscarPorPacienteId(pacienteId);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "Listar todas as fichas médicas")
    public ResponseEntity<List<FichaMedicaResponseDTO>> listarTodas() {
        List<FichaMedicaResponseDTO> response = fichaMedicaService.listarTodas();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar ficha médica")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        fichaMedicaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}