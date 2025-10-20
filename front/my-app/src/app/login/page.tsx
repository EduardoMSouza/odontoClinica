"use client"

import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { Button } from "@/components/ui/button"
import { toast } from "sonner"
import { useState } from "react"
import { useRouter } from "next/navigation"
import { salvarUsuario } from "@/lib/auth"

export default function LoginPage() {
    const router = useRouter()
    const [email, setEmail] = useState("")
    const [senha, setSenha] = useState("")
    const [loading, setLoading] = useState(false)

    const handleLogin = async (e: React.FormEvent) => {
        e.preventDefault()
        if (!email || !senha) {
            toast.warning("Preencha todos os campos.")
            return
        }

        setLoading(true)

        try {
            // ⚙️ Aqui você pode integrar com seu backend (exemplo: POST /login)
            // const res = await axios.post("http://localhost:8080/login", { email, senha })
            // const { token, funcao, nome } = res.data

            // Simulação
            let funcao = "SECRETARIA"
            if (email.includes("admin")) funcao = "ADMIN"
            else if (email.includes("dentista")) funcao = "DENTISTA"

            const usuario = {
                nome: "Usuário Teste",
                email,
                funcao,
                token: "fake-token-123"
            }

            salvarUsuario(usuario)
            toast.success(`Bem-vindo, ${usuario.nome}!`)

            setTimeout(() => {
                if (funcao === "ADMIN") router.push("/dashboard/admin")
                else if (funcao === "DENTISTA") router.push("/dashboard/dentista")
                else router.push("/dashboard/secretaria")
            }, 1000)
        } catch {
            toast.error("Usuário ou senha incorretos.")
        } finally {
            setLoading(false)
        }
    }

    return (
        <div className="min-h-screen flex items-center justify-center bg-gradient-to-br from-blue-100 to-blue-300 dark:from-zinc-900 dark:to-zinc-800 transition-colors">
            <Card className="w-full max-w-md shadow-xl border-none">
                <CardHeader className="text-center">
                    <CardTitle className="text-2xl font-bold text-blue-600">
                        OdontoClínica — Login
                    </CardTitle>
                </CardHeader>

                <CardContent>
                    <form onSubmit={handleLogin} className="space-y-4">
                        <div>
                            <Label htmlFor="email">E-mail</Label>
                            <Input
                                id="email"
                                type="email"
                                placeholder="seuemail@exemplo.com"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                            />
                        </div>

                        <div>
                            <Label htmlFor="senha">Senha</Label>
                            <Input
                                id="senha"
                                type="password"
                                placeholder="********"
                                value={senha}
                                onChange={(e) => setSenha(e.target.value)}
                            />
                        </div>

                        <Button
                            type="submit"
                            disabled={loading}
                            className="w-full bg-primary hover:bg-blue-500"
                        >
                            {loading ? "Entrando..." : "Entrar"}
                        </Button>
                    </form>
                </CardContent>
            </Card>
        </div>
    )
}
