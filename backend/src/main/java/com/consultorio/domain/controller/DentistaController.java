package com.consultorio.domain.controller;

import com.consultorio.domain.dto.request.DentistaRequestDTO;
import com.consultorio.domain.dto.response.DentistaResponseDTO;
import com.consultorio.domain.service.DentistaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dentistas")
@Tag(name = "Dentistas", description = "API para gerenciamento de dentistas")
public class DentistaController {

    private final DentistaService service;

    public DentistaController(DentistaService service) {
        this.service = service;
    }

    @Operation(summary = "Criar um novo dentista", description = "Cadastra um novo dentista no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dentista criado com sucesso",
                    content = @Content(schema = @Schema(implementation = DentistaResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                    content = @Content)
    })
    @PostMapping
    public DentistaResponseDTO criar(@Valid @RequestBody DentistaRequestDTO dto) {
        return service.criar(dto);
    }

    @Operation(summary = "Listar todos os dentistas", description = "Retorna uma lista de todos os dentistas cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de dentistas retornada com sucesso",
                    content = @Content(schema = @Schema(implementation = DentistaResponseDTO.class)))
    })
    @GetMapping
    public List<DentistaResponseDTO> listar() {
        return service.listar();
    }

    @Operation(summary = "Buscar dentista por ID", description = "Retorna um dentista específico baseado no ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dentista encontrado com sucesso",
                    content = @Content(schema = @Schema(implementation = DentistaResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Dentista não encontrado",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public DentistaResponseDTO buscarPorId(
            @Parameter(description = "ID do dentista", example = "1", required = true)
            @PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Atualizar dentista", description = "Atualiza os dados de um dentista existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dentista atualizado com sucesso",
                    content = @Content(schema = @Schema(implementation = DentistaResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Dentista não encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public DentistaResponseDTO atualizar(
            @Parameter(description = "ID do dentista", example = "1", required = true)
            @PathVariable Long id,
            @Valid @RequestBody DentistaRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Inativar dentista", description = "Inativa um dentista (exclusão lógica)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dentista inativado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Dentista não encontrado",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public void inativar(
            @Parameter(description = "ID do dentista", example = "1", required = true)
            @PathVariable Long id) {
        service.inativar(id);
    }
}