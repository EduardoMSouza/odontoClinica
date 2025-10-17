// src/hooks/useFichaMedica.ts (novo arquivo)
import { useState, useEffect } from 'react';
import { fichaMedicaService } from './fichaMedicaService.ts';
import type {FichaMedica} from '../types/fichaMedica.types';

export const useFichasMedicas = (pacienteId?: number) => {
    const [fichas, setFichas] = useState<FichaMedica[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        if (pacienteId) {
            fichaMedicaService.listarPorPaciente(pacienteId).then(setFichas).catch(setError).finally(() => setLoading(false));
        }
    }, [pacienteId]);

    const refresh = () => {
        if (pacienteId) {
            setLoading(true);
            fichaMedicaService.listarPorPaciente(pacienteId).then(setFichas).catch(setError).finally(() => setLoading(false));
        }
    };

    return { fichas, loading, error, refresh };
};