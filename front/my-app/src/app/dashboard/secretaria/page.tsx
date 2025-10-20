"use client"
import DashboardLayout from "@/components/layout/DashboardLayout"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Button } from "@/components/ui/button"
import Link from "next/link"

export default function SecretariaPage() {
    return (
        <DashboardLayout>
            <h1 className="text-2xl font-bold mb-6">Painel da Secretária</h1>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
                <Card>
                    <CardHeader>
                        <CardTitle>Gerenciar Pacientes</CardTitle>
                    </CardHeader>
                    <CardContent>
                        <p className="text-sm text-gray-600 mb-4">
                            Cadastre e edite informações dos pacientes.
                        </p>
                        <Link href="/pacientes">
                            <Button className="bg-primary">Acessar Pacientes</Button>
                        </Link>
                    </CardContent>
                </Card>

                <Card>
                    <CardHeader>
                        <CardTitle>Agendamentos</CardTitle>
                    </CardHeader>
                    <CardContent>
                        <p className="text-sm text-gray-600 mb-4">
                            Controle de consultas e horários.
                        </p>
                        <Link href="/agendamentos">
                            <Button className="bg-primary">Ver Agendamentos</Button>
                        </Link>
                    </CardContent>
                </Card>
            </div>
        </DashboardLayout>
    )
}
