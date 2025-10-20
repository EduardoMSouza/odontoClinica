"use client"

import DashboardLayout from "@/components/layout/DashboardLayout"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { UserPlus, Users } from "lucide-react"
import { useState, useEffect } from "react"
import { toast } from "sonner"
import axios from "axios"

interface Paciente {
    id: number
    nome: string
    cpf: string
    telefone: string
    email: string
}

export default function PacientesPage() {
    const [pacientes, setPacientes] = useState<Paciente[]>([])
    const [nome, setNome] = useState("")
    const [cpf, setCpf] = useState("")
    const [telefone, setTelefone] = useState("")
    const [email, setEmail] = useState("")

    useEffect(() => {
        carregarPacientes()
    }, [])

    const carregarPacientes = async () => {
        try {
            const res = await axios.get("http://localhost:8080/pacientes")
            setPacientes(res.data)
        } catch {
            toast.error("Erro ao carregar pacientes.")
        }
    }

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault()

        if (!nome || !cpf || !telefone) {
            toast.warning("Preencha os campos obrigatórios!")
            return
        }

        const novoPaciente = { nome, cpf, telefone, email }

        try {
            const res = await axios.post("http://localhost:8080/pacientes", novoPaciente)
            setPacientes((prev) => [...prev, res.data])
            toast.success("Paciente cadastrado com sucesso!")
            setNome("")
            setCpf("")
            setTelefone("")
            setEmail("")
        } catch {
            toast.error("Erro ao cadastrar paciente.")
        }
    }

    const excluirPaciente = async (id: number) => {
        if (!confirm("Deseja realmente excluir este paciente?")) return
        try {
            await axios.delete(`http://localhost:8080/pacientes/${id}`)
            setPacientes((prev) => prev.filter((p) => p.id !== id))
            toast.success("Paciente removido.")
        } catch {
            toast.error("Erro ao excluir paciente.")
        }
    }

    return (
        <DashboardLayout>
            <section className="space-y-6">
                <header className="flex items-center justify-between">
                    <h1 className="text-2xl font-bold text-blue-600 flex items-center gap-2">
                        <Users className="h-6 w-6" /> Pacientes
                    </h1>
                </header>

                {/* Formulário de novo paciente */}
                <Card>
                    <CardHeader>
                        <CardTitle className="text-blue-600 flex items-center gap-2">
                            <UserPlus className="h-5 w-5" /> Novo Paciente
                        </CardTitle>
                    </CardHeader>
                    <CardContent>
                        <form onSubmit={handleSubmit} className="grid grid-cols-1 md:grid-cols-2 gap-4">
                            <div>
                                <Label htmlFor="nome">Nome</Label>
                                <Input
                                    id="nome"
                                    placeholder="Nome completo"
                                    value={nome}
                                    onChange={(e) => setNome(e.target.value)}
                                />
                            </div>

                            <div>
                                <Label htmlFor="cpf">CPF</Label>
                                <Input
                                    id="cpf"
                                    placeholder="000.000.000-00"
                                    value={cpf}
                                    onChange={(e) => setCpf(e.target.value)}
                                />
                            </div>

                            <div>
                                <Label htmlFor="telefone">Telefone</Label>
                                <Input
                                    id="telefone"
                                    placeholder="(00) 00000-0000"
                                    value={telefone}
                                    onChange={(e) => setTelefone(e.target.value)}
                                />
                            </div>

                            <div>
                                <Label htmlFor="email">E-mail</Label>
                                <Input
                                    id="email"
                                    placeholder="email@exemplo.com"
                                    value={email}
                                    onChange={(e) => setEmail(e.target.value)}
                                />
                            </div>

                            <div className="md:col-span-2 flex justify-end">
                                <Button type="submit" className="bg-primary hover:bg-blue-500">
                                    Salvar
                                </Button>
                            </div>
                        </form>
                    </CardContent>
                </Card>

                {/* Lista de pacientes */}
                <Card>
                    <CardHeader>
                        <CardTitle className="text-blue-600">Pacientes Cadastrados</CardTitle>
                    </CardHeader>
                    <CardContent>
                        {pacientes.length === 0 ? (
                            <p className="text-gray-500 text-sm">Nenhum paciente encontrado.</p>
                        ) : (
                            <div className="overflow-x-auto">
                                <table className="w-full text-sm text-left border-collapse">
                                    <thead className="bg-blue-100 dark:bg-zinc-800 text-blue-700 dark:text-blue-400">
                                    <tr>
                                        <th className="p-2 border-b">Nome</th>
                                        <th className="p-2 border-b">CPF</th>
                                        <th className="p-2 border-b">Telefone</th>
                                        <th className="p-2 border-b">E-mail</th>
                                        <th className="p-2 border-b text-right">Ações</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    {pacientes.map((p) => (
                                        <tr
                                            key={p.id}
                                            className="hover:bg-blue-50 dark:hover:bg-zinc-700 transition"
                                        >
                                            <td className="p-2 border-b">{p.nome}</td>
                                            <td className="p-2 border-b">{p.cpf}</td>
                                            <td className="p-2 border-b">{p.telefone}</td>
                                            <td className="p-2 border-b">{p.email || "-"}</td>
                                            <td className="p-2 border-b text-right">
                                                <Button
                                                    variant="destructive"
                                                    size="sm"
                                                    onClick={() => excluirPaciente(p.id)}
                                                >
                                                    Excluir
                                                </Button>
                                            </td>
                                        </tr>
                                    ))}
                                    </tbody>
                                </table>
                            </div>
                        )}
                    </CardContent>
                </Card>
            </section>
        </DashboardLayout>
    )
}
