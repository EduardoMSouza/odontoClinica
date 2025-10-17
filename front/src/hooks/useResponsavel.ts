// src/hooks/useResponsavel.ts (novo arquivo)
import { useState, useEffect } from 'react';
import { responsavelService } from './responsavelService.ts';
import type {Responsavel} from '../types/responsavel.types';

export const useResponsaveis = () => {
    const [responsaveis, setResponsaveis] = useState<Responsavel[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        responsavelService.listar().then(setResponsaveis).catch(setError).finally(() => setLoading(false));
    }, []);

    const refresh = () => {
        setLoading(true);
        responsavelService.listar().then(setResponsaveis).catch(setError).finally(() => setLoading(false));
    };

    return { responsaveis, loading, error, refresh };
};