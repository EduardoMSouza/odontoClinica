

export default function PatientsPage() {
    return (
        <DashboardLayout>
            <div className="flex flex-col gap-6">
                <div>
                    <h1 className="text-3xl font-bold tracking-tight text-balance">Pacientes</h1>
                    <p className="text-muted-foreground mt-1">Gerencie todos os pacientes da clínica</p>
                </div>

                <PatientsTable />
            </div>
        </DashboardLayout>
    )
}
