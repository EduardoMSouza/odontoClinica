"use client"

import DashboardLayout from "@/components/layout/DashboardLayout"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { CalendarDays, PlusCircle } from "lucide-react"
import { useState, useEffect } from "react"
import { toast } from "sonner"
import axios from "axios"

interface Agendamento {
    id: number
    paciente: string
    data: string
    hora: string
    profissional: string
    observacao?: string
}

export default function AgendamentosPage() {
    const [agendamentos, setAgendamentos] = useState<Agendamento[]>([])
    const [paciente, setPaciente] = useState("")
    const [data, setData] = useState("")
    const [hora, setHora] = useState("")
    const [profissional, setProfissional] = useState("")
    const [observacao, setObservacao] = useState("")

    useEffect(() => {
        // Carrega agendamentos ao abrir
        axios
            .get("http://localhost:8080/agendamentos")
            .then((res) => setAgendamentos(res.data))
            .catch(() => toast.error("Erro ao carregar agendamentos"))
    }, [])

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault()

        if (!paciente || !data || !hora || !profissional) {
            toast.warning("Preencha todos os campos obrigatórios!")
            return
        }

        const novoAgendamento = { paciente, data, hora, profissional, observacao }

        try {
            const res = await axios.post("http://localhost:8080/agendamentos", novoAgendamento)
            setAgendamentos((prev) => [...prev, res.data])
            toast.success("Agendamento criado com sucesso!")
            setPaciente("")
            setData("")
            setHora("")
            setProfissional("")
            setObservacao("")
        } catch (err) {
            toast.error("Erro ao criar agendamento")
        }
    }

    return (
        <DashboardLayout>
            <section className="space-y-6">
                <header className="flex items-center justify-between">
                    <h1 className="text-2xl font-bold text-blue-600 flex items-center gap-2">
                        <CalendarDays className="h-6 w-6" /> Agendamentos
                    </h1>
                </header>

                {/* Formulário de novo agendamento */}
                <Card>
                    <CardHeader>
                        <CardTitle className="text-blue-600 flex items-center gap-2">
                            <PlusCircle className="h-5 w-5" /> Novo Agendamento
                        </CardTitle>
                    </CardHeader>
                    <CardContent>
                        <form onSubmit={handleSubmit} className="grid grid-cols-1 md:grid-cols-2 gap-4">
                            <div>
                                <Label htmlFor="paciente">Paciente</Label>
                                <Input
                                    id="paciente"
                                    placeholder="Nome do paciente"
                                    value={paciente}
                                    onChange={(e) => setPaciente(e.target.value)}
                                />
                            </div>

                            <div>
                                <Label htmlFor="profissional">Profissional</Label>
                                <Input
                                    id="profissional"
                                    placeholder="Nome do dentista"
                                    value={profissional}
                                    onChange={(e) => setProfissional(e.target.value)}
                                />
                            </div>

                            <div>
                                <Label htmlFor="data">Data</Label>
                                <Input
                                    id="data"
                                    type="date"
                                    value={data}
                                    onChange={(e) => setData(e.target.value)}
                                />
                            </div>

                            <div>
                                <Label htmlFor="hora">Hora</Label>
                                <Input
                                    id="hora"
                                    type="time"
                                    value={hora}
                                    onChange={(e) => setHora(e.target.value)}
                                />
                            </div>

                            <div className="md:col-span-2">
                                <Label htmlFor="observacao">Observações</Label>
                                <Input
                                    id="observacao"
                                    placeholder="Detalhes adicionais (opcional)"
                                    value={observacao}
                                    onChange={(e) => setObservacao(e.target.value)}
                                />
                            </div>

                            <div className="md:col-span-2 flex justify-end">
                                <Button type="submit" className="bg-primary hover:bg-blue-500">
                                    Salvar Agendamento
                                </Button>
                            </div>
                        </form>
                    </CardContent>
                </Card>

                {/* Lista de agendamentos */}
                <Card>
                    <CardHeader>
                        <CardTitle className="text-blue-600">Consultas Agendadas</CardTitle>
                    </CardHeader>
                    <CardContent>
                        {agendamentos.length === 0 ? (
                            <p className="text-gray-500 text-sm">Nenhum agendamento encontrado.</p>
                        ) : (
                            <div className="overflow-x-auto">
                                <table className="w-full text-sm text-left border-collapse">
                                    <thead className="bg-blue-100 dark:bg-zinc-800 text-blue-700 dark:text-blue-400">
                                    <tr>
                                        <th className="p-2 border-b">Paciente</th>
                                        <th className="p-2 border-b">Profissional</th>
                                        <th className="p-2 border-b">Data</th>
                                        <th className="p-2 border-b">Hora</th>
                                        <th className="p-2 border-b">Observação</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    {agendamentos.map((a) => (
                                        <tr
                                            key={a.id}
                                            className="hover:bg-blue-50 dark:hover:bg-zinc-700 transition"
                                        >
                                            <td className="p-2 border-b">{a.paciente}</td>
                                            <td className="p-2 border-b">{a.profissional}</td>
                                            <td className="p-2 border-b">{a.data}</td>
                                            <td className="p-2 border-b">{a.hora}</td>
                                            <td className="p-2 border-b">{a.observacao || "-"}</td>
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
