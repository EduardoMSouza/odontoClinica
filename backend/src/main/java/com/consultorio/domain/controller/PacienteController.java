package com.consultorio.domain.controller;

import com.consultorio.domain.dto.request.PacienteRequestDTO;
import com.consultorio.domain.dto.response.PacienteResponseDTO;
import com.consultorio.domain.service.PacienteService;
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
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
@Tag(name = "Pacientes", description = "Operações para gerenciamento de pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @Operation(
            summary = "Criar novo paciente",
            description = "Cria um novo paciente no sistema com todos os dados necessários incluindo responsável pelo tratamento"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Paciente criado com sucesso",
                    content = @Content(schema = @Schema(implementation = PacienteResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos ou CPF já cadastrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<PacienteResponseDTO> criar(@Valid @RequestBody PacienteRequestDTO dto) {
        return ResponseEntity.ok(pacienteService.criarPaciente(dto));
    }

    @Operation(
            summary = "Listar todos os pacientes",
            description = "Retorna uma lista com todos os pacientes cadastrados no sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de pacientes retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> listar() {
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    @Operation(
            summary = "Buscar paciente por ID",
            description = "Retorna os dados completos de um paciente específico pelo seu ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Paciente encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Paciente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> buscarPorId(
            @Parameter(description = "ID do paciente", example = "1", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    @Operation(
            summary = "Atualizar paciente",
            description = "Atualiza os dados de um paciente existente"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Paciente atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Paciente não encontrado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> atualizar(
            @Parameter(description = "ID do paciente", example = "1", required = true)
            @PathVariable Long id,
            @Valid @RequestBody PacienteRequestDTO dto) {
        return ResponseEntity.ok(pacienteService.atualizarPaciente(id, dto));
    }

    @Operation(
            summary = "Excluir paciente",
            description = "Remove um paciente do sistema. Atenção: Esta operação é irreversível."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Paciente excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Paciente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do paciente", example = "1", required = true)
            @PathVariable Long id) {
        pacienteService.deletarPaciente(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Buscar pacientes por nome",
            description = "Busca pacientes pelo nome (busca parcial case insensitive)"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/buscar/nome")
    public ResponseEntity<List<PacienteResponseDTO>> buscarPorNome(
            @Parameter(description = "Nome ou parte do nome do paciente", example = "João", required = true)
            @RequestParam String nome) {
        return ResponseEntity.ok(pacienteService.buscarPorNome(nome));
    }

    @Operation(
            summary = "Buscar paciente por CPF",
            description = "Busca um paciente específico pelo número do CPF"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Paciente encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Paciente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/buscar/cpf")
    public ResponseEntity<PacienteResponseDTO> buscarPorCpf(
            @Parameter(description = "CPF do paciente", example = "123.456.789-00", required = true)
            @RequestParam String cpf) {
        return ResponseEntity.ok(pacienteService.buscarPorCpf(cpf));
    }
}