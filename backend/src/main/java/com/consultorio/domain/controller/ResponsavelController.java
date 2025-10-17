package com.consultorio.domain.controller;

import com.consultorio.domain.dto.request.ResponsavelRequestDTO;
import com.consultorio.domain.dto.response.ResponsavelResponseDTO;
import com.consultorio.domain.service.ResponsavelService;
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
@RequestMapping("/api/responsaveis")
@RequiredArgsConstructor
@Tag(name = "Responsáveis", description = "Operações para gerenciamento de responsáveis pelo tratamento")
public class ResponsavelController {

    private final ResponsavelService responsavelService;

    @Operation(
            summary = "Listar todos os responsáveis",
            description = "Retorna uma lista com todos os responsáveis cadastrados no sistema"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de responsáveis retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping
    public ResponseEntity<List<ResponsavelResponseDTO>> listar() {
        return ResponseEntity.ok(responsavelService.listarTodos());
    }

    @Operation(
            summary = "Buscar responsável por ID",
            description = "Retorna os dados completos de um responsável específico pelo seu ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Responsável encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Responsável não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ResponsavelResponseDTO> buscarPorId(
            @Parameter(description = "ID do responsável", example = "1", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(responsavelService.buscarPorId(id));
    }

    @Operation(
            summary = "Buscar responsável por CPF",
            description = "Busca um responsável específico pelo número do CPF"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Responsável encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Responsável não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/buscar/cpf")
    public ResponseEntity<ResponsavelResponseDTO> buscarPorCpf(
            @Parameter(description = "CPF do responsável", example = "987.654.321-00", required = true)
            @RequestParam String cpf) {
        return ResponseEntity.ok(responsavelService.buscarPorCpf(cpf));
    }

    @Operation(
            summary = "Atualizar responsável",
            description = "Atualiza os dados de um responsável existente"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Responsável atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Responsável não encontrado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ResponsavelResponseDTO> atualizar(
            @Parameter(description = "ID do responsável", example = "1", required = true)
            @PathVariable Long id,
            @Valid @RequestBody ResponsavelRequestDTO dto) {
        return ResponseEntity.ok(responsavelService.atualizarResponsavel(id, dto));
    }

    @Operation(
            summary = "Excluir responsável",
            description = "Remove um responsável do sistema. Só é possível excluir se não houver pacientes vinculados."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Responsável excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Responsável não encontrado"),
            @ApiResponse(responseCode = "400", description = "Não é possível excluir - existem pacientes vinculados"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do responsável", example = "1", required = true)
            @PathVariable Long id) {
        responsavelService.deletarResponsavel(id);
        return ResponseEntity.noContent().build();
    }
}