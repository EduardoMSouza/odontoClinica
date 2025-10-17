// src/types/paciente.types.ts
export interface Paciente {
    id: number;
    nome: string;
    cpf: string;
    email?: string;
    telefone?: string;
    dataNascimento?: string;
}

export interface PacienteRequest {
    nome: string;
    cpf: string;
    email?: string;
    telefone?: string;
    dataNascimento?: string;
}