// src/types/fichaMedica.types.ts (novo arquivo)
export interface FichaMedica {
    id: number;
    pacienteId: number;
    // Adicione campos conforme seu DTO, ex: alergias, historico, etc.
    alergias: string;
    historicoMedico: string;
    medicamentos: string;
}

export interface FichaMedicaRequest {
    pacienteId: number;
    alergias: string;
    historicoMedico: string;
    medicamentos: string;
}