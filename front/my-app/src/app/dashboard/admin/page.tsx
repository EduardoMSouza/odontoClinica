"use client"
import DashboardLayout from "@/components/layout/DashboardLayout"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Button } from "@/components/ui/button"

export default function AdminPage() {
    return (
        <DashboardLayout>
            <h1 className="text-2xl font-bold mb-6">Painel Administrativo</h1>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
                <Card>
                    <CardHeader>
                        <CardTitle>Usuários do Sistema</CardTitle>
                    </CardHeader>
                    <CardContent>
                        <p className="text-sm text-gray-600 mb-4">
                            Gerencie os acessos e permissões de usuários.
                        </p>
                        <Button className="bg-primary">Gerenciar Usuários</Button>
                    </CardContent>
                </Card>

                <Card>
                    <CardHeader>
                        <CardTitle>Configurações Gerais</CardTitle>
                    </CardHeader>
                    <CardContent>
                        <p className="text-sm text-gray-600 mb-4">
                            Ajuste preferências, aparência e dados da clínica.
                        </p>
                        <Button className="bg-primary">Abrir Configurações</Button>
                    </CardContent>
                </Card>
            </div>
        </DashboardLayout>
    )
}
