"use client"
import { main } from "framer-motion/client"
import { Navbar } from "./Navbar"
import { Sidebar } from "./Sidebar"

export default function DashboardLayout({ children }: { children: React.ReactNode }) {
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
