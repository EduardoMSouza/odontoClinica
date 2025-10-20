package com.consultorio.domain.dentista.dto;

import com.consultorio.domain.dentista.Dentista;

public class DentistaMapper {

    public static Dentista toEntity(DentistaRequestDTO dto) {
        Dentista d = new Dentista();
        d.setNome(dto.getNome());
        d.setCro(dto.getCro());
        d.setEspecialidade(dto.getEspecialidade());
        d.setTelefone(dto.getTelefone());
        d.setEmail(dto.getEmail());
        d.setAtivo(dto.getAtivo() != null ? dto.getAtivo() : true);
        return d;
    }

    public static void update(DentistaRequestDTO dto, Dentista d){
        if(dto.getNome()!=null) d.setNome(dto.getNome());
        if(dto.getCro()!=null) d.setCro(dto.getCro());
        if(dto.getEspecialidade()!=null) d.setEspecialidade(dto.getEspecialidade());
        if(dto.getTelefone()!=null) d.setTelefone(dto.getTelefone());
        if(dto.getEmail()!=null) d.setEmail(dto.getEmail());
        if(dto.getAtivo()!=null) d.setAtivo(dto.getAtivo());
    }

    public static DentistaResponseDTO toDTO(Dentista d){
        DentistaResponseDTO dto = new DentistaResponseDTO();
        dto.setId(d.getId());
        dto.setNome(d.getNome());
        dto.setCro(d.getCro());
        dto.setEspecialidade(d.getEspecialidade());
        dto.setTelefone(d.getTelefone());
        dto.setEmail(d.getEmail());
        dto.setAtivo(d.getAtivo());
        return dto;
    }
}
