"use client"

import { useEffect, useMemo, useState } from "react"
import { toast } from "sonner"
import { CalendarDays, Clock, PlusCircle, UserMinus } from "lucide-react"

import DashboardLayout from "@/components/layout/DashboardLayout"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import api from "@/lib/api"

interface PacienteOption {
    id: number
    nome: string
}

interface DentistaOption {
    id: number
    nome: string
}

interface Agendamento {
    id: number
    pacienteId: number
    pacienteNome: string
    dentistaId: number
    dentistaNome: string
    dataHora: string
    status: string
    observacoes?: string
}

interface AgendamentoRequest {
    pacienteId: number
    dentistaId: number
    dataHora: string
    observacoes?: string
}

const formatarData = (dataHora: string) => {
    const [data] = dataHora.split("T")
    if (!data) return "-"
    const [ano, mes, dia] = data.split("-")
    if (!ano || !mes || !dia) return data
    return `${dia}/${mes}/${ano}`
}

const formatarHora = (dataHora: string) => {
    const [, hora] = dataHora.split("T")
    if (!hora) return "-"
    return hora.substring(0, 5)
}

const formatarStatus = (status: string) => {
    switch (status) {
        case "AGENDADO":
            return "Agendado"
        case "CANCELADO":
            return "Cancelado"
        case "REALIZADO":
            return "Realizado"
        default:
            return status
    }
}

export default function AgendamentosPage() {
    const [agendamentos, setAgendamentos] = useState<Agendamento[]>([])
    const [pacientes, setPacientes] = useState<PacienteOption[]>([])
    const [dentistas, setDentistas] = useState<DentistaOption[]>([])

    const [pacienteId, setPacienteId] = useState<number | "">("")
    const [dentistaId, setDentistaId] = useState<number | "">("")
    const [data, setData] = useState("")
    const [hora, setHora] = useState("")
    const [observacoes, setObservacoes] = useState("")

    const [loading, setLoading] = useState(false)
    const [saving, setSaving] = useState(false)
    const [updatingStatusId, setUpdatingStatusId] = useState<number | null>(null)

    const formularioValido = useMemo(
        () =>
            Boolean(pacienteId) &&
            Boolean(dentistaId) &&
            data.trim().length > 0 &&
            hora.trim().length > 0,
        [pacienteId, dentistaId, data, hora],
    )

    useEffect(() => {
        carregarDados()
    }, [])

    const carregarDados = async () => {
        setLoading(true)
        try {
            const [agendaRes, pacientesRes, dentistasRes] = await Promise.all([
                api.get<Agendamento[]>("/agendamentos"),
                api.get<PacienteOption[]>("/pacientes"),
                api.get<DentistaOption[]>("/dentistas"),
            ])
            setAgendamentos(agendaRes.data)
            setPacientes(pacientesRes.data)
            setDentistas(dentistasRes.data)
        } catch (error) {
            console.error(error)
            toast.error("Não foi possível carregar os dados de agendamento.")
        } finally {
            setLoading(false)
        }
    }

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault()
        if (!formularioValido || !pacienteId || !dentistaId) {
            toast.warning("Preencha todos os campos obrigatórios.")
            return
        }

        const dataHora = `${data}T${hora}:00`
        const payload: AgendamentoRequest = {
            pacienteId,
            dentistaId,
            dataHora,
            observacoes: observacoes.trim() || undefined,
        }

        setSaving(true)
        try {
            const { data: novoAgendamento } = await api.post<Agendamento>("/agendamentos", payload)
            setAgendamentos((prev) => [...prev, novoAgendamento])
            toast.success("Agendamento criado com sucesso!")
            setPacienteId("")
            setDentistaId("")
            setData("")
            setHora("")
            setObservacoes("")
        } catch (error) {
            console.error(error)
            toast.error("Erro ao criar agendamento.")
        } finally {
            setSaving(false)
        }
    }

    const atualizarStatus = async (id: number, status: "CANCELADO" | "REALIZADO") => {
        setUpdatingStatusId(id)
        try {
            const { data } = await api.patch<Agendamento>(`/agendamentos/${id}/status`, null, {
                params: { status },
            })
            setAgendamentos((prev) => prev.map((agenda) => (agenda.id === id ? data : agenda)))
            toast.success(`Agendamento ${status === "CANCELADO" ? "cancelado" : "marcado como realizado"}.`)
        } catch (error) {
            console.error(error)
            toast.error("Não foi possível atualizar o status do agendamento.")
        } finally {
            setUpdatingStatusId(null)
        }
    }

    const excluirAgendamento = async (id: number) => {
        const confirmado = window.confirm("Deseja realmente excluir este agendamento?")
        if (!confirmado) return

        setUpdatingStatusId(id)
        try {
            await api.delete(`/agendamentos/${id}`)
            setAgendamentos((prev) => prev.filter((agenda) => agenda.id !== id))
            toast.success("Agendamento removido.")
        } catch (error) {
            console.error(error)
            toast.error("Não foi possível excluir o agendamento.")
        } finally {
            setUpdatingStatusId(null)
        }
    }

    return (
        <DashboardLayout>
            <section className="space-y-6">
                <header className="flex items-center justify-between">
                    <h1 className="text-2xl font-bold text-blue-600 flex items-center gap-2">
                        <CalendarDays className="h-6 w-6" /> Agendamentos
                    </h1>
                    <Button variant="outline" onClick={carregarDados} disabled={loading}>
                        <Clock className="h-4 w-4 mr-2" /> Atualizar
                    </Button>
                </header>

                <Card>
                    <CardHeader>
                        <CardTitle className="text-blue-600 flex items-center gap-2">
                            <PlusCircle className="h-5 w-5" /> Novo Agendamento
                        </CardTitle>
                    </CardHeader>
                    <CardContent>
                        <form
                            onSubmit={handleSubmit}
                            className="grid grid-cols-1 md:grid-cols-2 gap-4"
                        >
                            <div>
                                <Label htmlFor="paciente">Paciente *</Label>
                                <select
                                    id="paciente"
                                    className="w-full rounded-md border border-input bg-background px-3 py-2 text-sm"
                                    value={pacienteId}
                                    onChange={(event) =>
                                        setPacienteId(event.target.value ? Number(event.target.value) : "")
                                    }
                                >
                                    <option value="">Selecione um paciente</option>
                                    {pacientes.map((paciente) => (
                                        <option key={paciente.id} value={paciente.id}>
                                            {paciente.nome}
                                        </option>
                                    ))}
                                </select>
                            </div>

                            <div>
                                <Label htmlFor="dentista">Dentista *</Label>
                                <select
                                    id="dentista"
                                    className="w-full rounded-md border border-input bg-background px-3 py-2 text-sm"
                                    value={dentistaId}
                                    onChange={(event) =>
                                        setDentistaId(event.target.value ? Number(event.target.value) : "")
                                    }
                                >
                                    <option value="">Selecione um dentista</option>
                                    {dentistas.map((dentista) => (
                                        <option key={dentista.id} value={dentista.id}>
                                            {dentista.nome}
                                        </option>
                                    ))}
                                </select>
                            </div>

                            <div>
                                <Label htmlFor="data">Data *</Label>
                                <Input
                                    id="data"
                                    type="date"
                                    value={data}
                                    onChange={(event) => setData(event.target.value)}
                                />
                            </div>

                            <div>
                                <Label htmlFor="hora">Hora *</Label>
                                <Input
                                    id="hora"
                                    type="time"
                                    value={hora}
                                    onChange={(event) => setHora(event.target.value)}
                                />
                            </div>

                            <div className="md:col-span-2">
                                <Label htmlFor="observacoes">Observações</Label>
                                <Input
                                    id="observacoes"
                                    placeholder="Detalhes adicionais (opcional)"
                                    value={observacoes}
                                    onChange={(event) => setObservacoes(event.target.value)}
                                />
                            </div>

                            <div className="md:col-span-2 flex justify-end">
                                <Button
                                    type="submit"
                                    className="bg-primary hover:bg-blue-500"
                                    disabled={saving || !formularioValido}
                                >
                                    {saving ? "Salvando..." : "Salvar agendamento"}
                                </Button>
                            </div>
                        </form>
                    </CardContent>
                </Card>

                <Card>
                    <CardHeader>
                        <CardTitle className="text-blue-600">Consultas agendadas</CardTitle>
                    </CardHeader>
                    <CardContent>
                        {loading ? (
                            <p className="text-gray-500 text-sm">Carregando agendamentos...</p>
                        ) : agendamentos.length === 0 ? (
                            <p className="text-gray-500 text-sm">Nenhum agendamento encontrado.</p>
                        ) : (
                            <div className="overflow-x-auto">
                                <table className="w-full text-sm text-left border-collapse">
                                    <thead className="bg-blue-100 dark:bg-zinc-800 text-blue-700 dark:text-blue-400">
                                        <tr>
                                            <th className="p-2 border-b">Paciente</th>
                                            <th className="p-2 border-b">Dentista</th>
                                            <th className="p-2 border-b">Data</th>
                                            <th className="p-2 border-b">Hora</th>
                                            <th className="p-2 border-b">Status</th>
                                            <th className="p-2 border-b">Observações</th>
                                            <th className="p-2 border-b text-right">Ações</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {agendamentos.map((agendamento) => (
                                            <tr
                                                key={agendamento.id}
                                                className="hover:bg-blue-50 dark:hover:bg-zinc-700 transition"
                                            >
                                                <td className="p-2 border-b">{agendamento.pacienteNome}</td>
                                                <td className="p-2 border-b">{agendamento.dentistaNome}</td>
                                                <td className="p-2 border-b">{formatarData(agendamento.dataHora)}</td>
                                                <td className="p-2 border-b">{formatarHora(agendamento.dataHora)}</td>
                                                <td className="p-2 border-b">{formatarStatus(agendamento.status)}</td>
                                                <td className="p-2 border-b">{agendamento.observacoes || "-"}</td>
                                                <td className="p-2 border-b text-right space-x-2">
                                                    <Button
                                                        variant="secondary"
                                                        size="sm"
                                                        disabled={updatingStatusId === agendamento.id}
                                                        onClick={() => atualizarStatus(agendamento.id, "REALIZADO")}
                                                    >
                                                        Concluir
                                                    </Button>
                                                    <Button
                                                        variant="outline"
                                                        size="sm"
                                                        disabled={updatingStatusId === agendamento.id}
                                                        onClick={() => atualizarStatus(agendamento.id, "CANCELADO")}
                                                    >
                                                        Cancelar
                                                    </Button>
                                                    <Button
                                                        variant="destructive"
                                                        size="sm"
                                                        disabled={updatingStatusId === agendamento.id}
                                                        onClick={() => excluirAgendamento(agendamento.id)}
                                                    >
                                                        <UserMinus className="h-4 w-4" />
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
