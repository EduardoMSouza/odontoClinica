"use client"
import DashboardLayout from "@/components/layout/DashboardLayout"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"

export default function DentistaPage() {
    return (
        <DashboardLayout>
            <h1 className="text-2xl font-bold mb-6">Painel do Dentista</h1>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
                <Card>
                    <CardHeader>
                        <CardTitle>Consultas do Dia</CardTitle>
                    </CardHeader>
                    <CardContent>
                        <p className="text-sm text-gray-600 mb-4">
                            Visualize as consultas agendadas para hoje.
                        </p>
                    </CardContent>
                </Card>

                <Card>
                    <CardHeader>
                        <CardTitle>Prontuários</CardTitle>
                    </CardHeader>
                    <CardContent>
                        <p className="text-sm text-gray-600 mb-4">
                            Acesse o histórico clínico dos pacientes e fichas médicas.
                        </p>
                    </CardContent>
                </Card>
            </div>
        </DashboardLayout>
    )
}
