package com.consultorio.domain.dto.mapper;


import com.consultorio.domain.dto.request.DentistaRequestDTO;
import com.consultorio.domain.dto.response.DentistaResponseDTO;
import com.consultorio.domain.entity.Dentista;

public class DentistaMapper {

    public static Dentista toEntity(DentistaRequestDTO dto) {
        Dentista dentista = new Dentista();
        dentista.setId(dto.getId());
        dentista.setNome(dto.getNome());
        dentista.setCro(dto.getCro());
        dentista.setEspecialidade(dto.getEspecialidade());
        dentista.setTelefone(dto.getTelefone());
        dentista.setEmail(dto.getEmail());
        dentista.setAtivo(true);
        return dentista;
    }

    public static DentistaResponseDTO toDTO(Dentista dentista) {
        DentistaResponseDTO dto = new DentistaResponseDTO();
        dto.setId(dentista.getId());
        dto.setNome(dentista.getNome());
        dto.setCro(dentista.getCro());
        dto.setEspecialidade(dentista.getEspecialidade());
        dto.setTelefone(dentista.getTelefone());
        dto.setEmail(dentista.getEmail());
        dto.setAtivo(dentista.getAtivo());
        return dto;
    }
}
