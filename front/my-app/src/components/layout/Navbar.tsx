"use client"
import { useTheme } from "next-themes"
import { Button } from "@/components/ui/button"
import { Sun, Moon } from "lucide-react"

export function Navbar() {
    const { theme, setTheme } = useTheme()

    return (
        <header className="flex justify-between items-center p-4 border-b bg-white dark:bg-zinc-900 dark:border-zinc-800">
            <h1 className="text-xl font-semibold text-blue-600">Painel de Gerenciamento</h1>
            <Button
                variant="outline"
                size="icon"
                onClick={() => setTheme(theme === "light" ? "dark" : "light")}
            >
                {theme === "light" ? <Moon className="h-5 w-5" /> : <Sun className="h-5 w-5" />}
            </Button>
        </header>
    )
}
