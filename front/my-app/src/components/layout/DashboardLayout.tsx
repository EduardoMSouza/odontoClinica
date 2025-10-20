"use client"

import { Navbar } from "./Navbar"
import { Sidebar } from "./Sidebar"

type DashboardLayoutProps = {
    children: React.ReactNode
}

export default function DashboardLayout({ children }: DashboardLayoutProps) {
    return (
        <div className="flex h-screen">
            <Sidebar />
            <div className="flex-1 flex flex-col">
                <Navbar />
                <main className="flex-1 overflow-y-auto p-6 bg-background dark:bg-background-dark transition-colors">
                    {children}
                </main>
            </div>
        </div>
    )
}
