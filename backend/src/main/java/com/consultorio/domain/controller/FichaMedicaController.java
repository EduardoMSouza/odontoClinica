package com.consultorio.domain.controller;

import com.consultorio.domain.dto.request.FichaMedicaRequestDTO;
import com.consultorio.domain.dto.response.FichaMedicaResponseDTO;
import com.consultorio.domain.service.FichaMedicaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fichas-medicas")
@RequiredArgsConstructor
@Tag(name = "Fichas Médicas", description = "Operações para gerenciamento de fichas médicas dos pacientes")
public class FichaMedicaController {

    private final FichaMedicaService fichaMedicaService;

    @Operation(
            summary = "Criar nova ficha médica",
            description = "Cria uma nova ficha médica para um paciente existente"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ficha médica criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos ou paciente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping
    public ResponseEntity<FichaMedicaResponseDTO> criar(@Valid @RequestBody FichaMedicaRequestDTO dto) {
        return ResponseEntity.ok(fichaMedicaService.criarFichaMedica(dto));
    }

    @Operation(
            summary = "Buscar ficha médica por ID",
            description = "Retorna os dados completos de uma ficha médica específica"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ficha médica encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ficha médica não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<FichaMedicaResponseDTO> buscarPorId(
            @Parameter(description = "ID da ficha médica", example = "1", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(fichaMedicaService.buscarPorId(id));
    }

    @Operation(
            summary = "Buscar fichas médicas por paciente",
            description = "Retorna todas as fichas médicas de um paciente específico"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Fichas médicas encontradas com sucesso"),
            @ApiResponse(responseCode = "404", description = "Paciente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<FichaMedicaResponseDTO>> buscarPorPacienteId(
            @Parameter(description = "ID do paciente", example = "1", required = true)
            @PathVariable Long pacienteId) {
        return ResponseEntity.ok(fichaMedicaService.buscarPorPacienteId(pacienteId));
    }

    @Operation(
            summary = "Buscar fichas médicas por nome do paciente",
            description = "Busca fichas médicas pelo nome do paciente (busca parcial)"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/buscar/nome-paciente")
    public ResponseEntity<List<FichaMedicaResponseDTO>> buscarPorNomePaciente(
            @Parameter(description = "Nome ou parte do nome do paciente", example = "Maria", required = true)
            @RequestParam String nome) {
        return ResponseEntity.ok(fichaMedicaService.buscarPorNomePaciente(nome));
    }

    @Operation(
            summary = "Atualizar ficha médica",
            description = "Atualiza os dados de uma ficha médica existente"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ficha médica atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ficha médica não encontrada"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<FichaMedicaResponseDTO> atualizar(
            @Parameter(description = "ID da ficha médica", example = "1", required = true)
            @PathVariable Long id,
            @Valid @RequestBody FichaMedicaRequestDTO dto) {
        return ResponseEntity.ok(fichaMedicaService.atualizarFichaMedica(id, dto));
    }

    @Operation(
            summary = "Excluir ficha médica",
            description = "Remove uma ficha médica do sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Ficha médica excluída com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ficha médica não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID da ficha médica", example = "1", required = true)
            @PathVariable Long id) {
        fichaMedicaService.deletarFichaMedica(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Verificar se paciente tem ficha médica",
            description = "Verifica se um paciente possui pelo menos uma ficha médica cadastrada"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Verificação realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Paciente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/paciente/{pacienteId}/existe")
    public ResponseEntity<Boolean> pacienteTemFichaMedica(
            @Parameter(description = "ID do paciente", example = "1", required = true)
            @PathVariable Long pacienteId) {
        return ResponseEntity.ok(fichaMedicaService.pacienteTemFichaMedica(pacienteId));
    }

    @Operation(
            summary = "Contar fichas médicas do paciente",
            description = "Retorna a quantidade de fichas médicas que um paciente possui"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contagem realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Paciente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/paciente/{pacienteId}/quantidade")
    public ResponseEntity<Long> contarFichasPorPaciente(
            @Parameter(description = "ID do paciente", example = "1", required = true)
            @PathVariable Long pacienteId) {
        return ResponseEntity.ok(fichaMedicaService.contarFichasPorPaciente(pacienteId));
    }
}