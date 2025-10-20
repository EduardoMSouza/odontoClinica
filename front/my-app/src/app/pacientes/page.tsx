"use client"

import { useEffect, useMemo, useState } from "react"
import { toast } from "sonner"

import DashboardLayout from "@/components/layout/DashboardLayout"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import api from "@/lib/api"
import { UserPlus, Users } from "lucide-react"

interface Paciente {
    id: number
    nome: string
    cpf?: string
    telefone?: string
    email?: string
}

interface PacienteRequest {
    nome: string
    cpf?: string
    telefone?: string
    email?: string
}

export default function PacientesPage() {
    const [pacientes, setPacientes] = useState<Paciente[]>([])
    const [nome, setNome] = useState("")
    const [cpf, setCpf] = useState("")
    const [telefone, setTelefone] = useState("")
    const [email, setEmail] = useState("")
    const [loading, setLoading] = useState(false)
    const [saving, setSaving] = useState(false)

    useEffect(() => {
        carregarPacientes()
    }, [])

    const formularioValido = useMemo(() => nome.trim().length > 0, [nome])

    const carregarPacientes = async () => {
        setLoading(true)
        try {
            const { data } = await api.get<Paciente[]>("/pacientes")
            setPacientes(data)
        } catch (error) {
            console.error(error)
            toast.error("Não foi possível carregar os pacientes.")
        } finally {
            setLoading(false)
        }
    }

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault()
        if (!formularioValido) {
            toast.warning("Informe ao menos o nome do paciente.")
            return
        }

        const payload: PacienteRequest = {
            nome: nome.trim(),
            cpf: cpf.trim() || undefined,
            telefone: telefone.trim() || undefined,
            email: email.trim() || undefined,
        }

        setSaving(true)
        try {
            const { data } = await api.post<Paciente>("/pacientes", payload)
            setPacientes((prev) => [...prev, data])
            toast.success("Paciente cadastrado com sucesso!")
            setNome("")
            setCpf("")
            setTelefone("")
            setEmail("")
        } catch (error) {
            console.error(error)
            toast.error("Erro ao cadastrar paciente.")
        } finally {
            setSaving(false)
        }
    }

    const excluirPaciente = async (id: number) => {
        const confirmado = window.confirm("Deseja realmente excluir este paciente?")
        if (!confirmado) return

        try {
            await api.delete(`/pacientes/${id}`)
            setPacientes((prev) => prev.filter((paciente) => paciente.id !== id))
            toast.success("Paciente removido com sucesso.")
        } catch (error) {
            console.error(error)
            toast.error("Não foi possível excluir o paciente.")
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

                <Card>
                    <CardHeader>
                        <CardTitle className="text-blue-600 flex items-center gap-2">
                            <UserPlus className="h-5 w-5" /> Novo Paciente
                        </CardTitle>
                    </CardHeader>
                    <CardContent>
                        <form
                            onSubmit={handleSubmit}
                            className="grid grid-cols-1 md:grid-cols-2 gap-4"
                        >
                            <div>
                                <Label htmlFor="nome">Nome *</Label>
                                <Input
                                    id="nome"
                                    placeholder="Nome completo"
                                    value={nome}
                                    onChange={(event) => setNome(event.target.value)}
                                />
                            </div>

                            <div>
                                <Label htmlFor="cpf">CPF</Label>
                                <Input
                                    id="cpf"
                                    placeholder="000.000.000-00"
                                    value={cpf}
                                    onChange={(event) => setCpf(event.target.value)}
                                />
                            </div>

                            <div>
                                <Label htmlFor="telefone">Telefone</Label>
                                <Input
                                    id="telefone"
                                    placeholder="(00) 00000-0000"
                                    value={telefone}
                                    onChange={(event) => setTelefone(event.target.value)}
                                />
                            </div>

                            <div>
                                <Label htmlFor="email">E-mail</Label>
                                <Input
                                    id="email"
                                    placeholder="email@exemplo.com"
                                    value={email}
                                    onChange={(event) => setEmail(event.target.value)}
                                />
                            </div>

                            <div className="md:col-span-2 flex justify-end">
                                <Button
                                    type="submit"
                                    className="bg-primary hover:bg-blue-500"
                                    disabled={saving}
                                >
                                    {saving ? "Salvando..." : "Salvar"}
                                </Button>
                            </div>
                        </form>
                    </CardContent>
                </Card>

                <Card>
                    <CardHeader>
                        <CardTitle className="text-blue-600">Pacientes cadastrados</CardTitle>
                    </CardHeader>
                    <CardContent>
                        {loading ? (
                            <p className="text-sm text-gray-500">Carregando pacientes...</p>
                        ) : pacientes.length === 0 ? (
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
                                        {pacientes.map((paciente) => (
                                            <tr
                                                key={paciente.id}
                                                className="hover:bg-blue-50 dark:hover:bg-zinc-700 transition"
                                            >
                                                <td className="p-2 border-b">{paciente.nome}</td>
                                                <td className="p-2 border-b">{paciente.cpf || "-"}</td>
                                                <td className="p-2 border-b">{paciente.telefone || "-"}</td>
                                                <td className="p-2 border-b">{paciente.email || "-"}</td>
                                                <td className="p-2 border-b text-right">
                                                    <Button
                                                        variant="destructive"
                                                        size="sm"
                                                        onClick={() => excluirPaciente(paciente.id)}
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
