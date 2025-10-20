import React, { useState } from 'react';

import './Login.css';
import {useAuth} from "../../../context/AuthContext";

export const Login: React.FC = () => {
    const { login, isLoading } = useAuth();
    const [formData, setFormData] = useState({
        email: '',
        senha: ''
    });
    const [error, setError] = useState('');

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setFormData(prev => ({
            ...prev,
            [name]: value
        }));
        // Limpar erro quando usuário digitar
        if (error) setError('');
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();

        if (!formData.email || !formData.senha) {
            setError('Por favor, preencha todos os campos');
            return;
        }

        const success = await login(formData);
        if (!success) {
            setError('Email ou senha incorretos');
        }
    };

    return (
        <div className="login-container">
            <div className="login-box">
                <div className="login-header">
                    <h1>Sistema Consultório</h1>
                    <p>Faça login para acessar o sistema</p>
                </div>

                <form onSubmit={handleSubmit} className="login-form">
                    {error && <div className="login-error">{error}</div>}

                    <div className="form-group">
                        <label htmlFor="email">Email</label>
                        <input
                            type="email"
                            id="email"
                            name="email"
                            value={formData.email}
                            onChange={handleChange}
                            placeholder="seu@email.com"
                            disabled={isLoading}
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="senha">Senha</label>
                        <input
                            type="password"
                            id="senha"
                            name="senha"
                            value={formData.senha}
                            onChange={handleChange}
                            placeholder="Sua senha"
                            disabled={isLoading}
                        />
                    </div>

                    <button
                        type="submit"
                        disabled={isLoading}
                        className="login-button"
                    >
                        {isLoading ? 'Entrando...' : 'Entrar'}
                    </button>
                </form>

                <div className="login-demo">
                    <h3>Credenciais de Teste:</h3>
                    <p><strong>Admin:</strong> admin@consultorio.com / senha123</p>
                    <p><strong>Médico:</strong> medico@consultorio.com / senha123</p>
                    <p><strong>Secretaria:</strong> secretaria@consultorio.com / senha123</p>
                </div>
            </div>
        </div>
    );
};