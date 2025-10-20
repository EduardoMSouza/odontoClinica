export interface Usuario {
    nome: string
    email: string
    funcao: "ADMIN" | "DENTISTA" | "SECRETARIA"
    token: string
}

// salva usuário no navegador
export function salvarUsuario(usuario: { nome: string; email: string; funcao: string; token: string }) {
    localStorage.setItem("usuario", JSON.stringify(usuario))
}

// retorna usuário atual
export function obterUsuario(): Usuario | null {
    const data = localStorage.getItem("usuario")
    return data ? JSON.parse(data) : null
}

// remove ao deslogar
export function limparUsuario() {
    localStorage.removeItem("usuario")
}
