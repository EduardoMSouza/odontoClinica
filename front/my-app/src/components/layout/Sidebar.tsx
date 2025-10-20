"use client"
import Link from "next/link"
import { usePathname } from "next/navigation"
import { Home, Users, Calendar, Settings } from "lucide-react"

export function Sidebar() {
    const pathname = usePathname()

    const links = [
        { href: "/dashboard/secretaria", label: "Secretária", icon: Home },
        { href: "/dashboard/dentista", label: "Dentista", icon: Users },
        { href: "/dashboard/admin", label: "Admin", icon: Settings },
        { href: "/pacientes", label: "Pacientes", icon: Users },
        { href: "/agendamentos", label: "Agendamentos", icon: Calendar },
    ]

    return (
        <aside className="w-64 bg-white dark:bg-zinc-900 border-r dark:border-zinc-800 p-4">
            <h2 className="text-lg font-bold text-blue-600 mb-6">OdontoClínica</h2>
            <nav className="space-y-2">
                {links.map(({ href, label, icon: Icon }) => (
                    <Link
                        key={href}
                        href={href}
                        className={`flex items-center gap-2 p-2 rounded-md hover:bg-blue-100 dark:hover:bg-zinc-800 ${
                            pathname === href ? "bg-blue-50 dark:bg-zinc-800 text-blue-600" : "text-gray-700 dark:text-gray-200"
                        }`}
                    >
                        <Icon className="h-4 w-4" />
                        {label}
                    </Link>
                ))}
            </nav>
        </aside>
    )
}
