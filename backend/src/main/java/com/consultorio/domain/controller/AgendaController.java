package com.consultorio.domain.controller;

import com.consultorio.domain.dto.request.AgendaRequestDTO;
import com.consultorio.domain.dto.response.AgendaResponseDTO;
import com.consultorio.domain.service.AgendaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendas")
public class AgendaController {
    private final AgendaService service;

    public AgendaController(AgendaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendaResponseDTO criar(@RequestBody AgendaRequestDTO dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<AgendaResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public AgendaResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public AgendaResponseDTO atualizar(@PathVariable Long id, @RequestBody AgendaRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @PutMapping("/{id}/cancelar")
    public void cancelar(@PathVariable Long id) {
        service.cancelar(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}