import { NextResponse } from "next/server"
import type { NextRequest } from "next/server"

export function middleware(req: NextRequest) {
    const token = req.cookies.get("token")?.value
    const isLoginPage = req.nextUrl.pathname.startsWith("/login")

    // se não estiver logado e não estiver no login → redireciona
    if (!token && !isLoginPage) {
        return NextResponse.redirect(new URL("/login", req.url))
    }

    // se já estiver logado e tentar acessar o login → redireciona ao painel
    if (token && isLoginPage) {
        return NextResponse.redirect(new URL("/dashboard/secretaria", req.url))
    }

    return NextResponse.next()
}

export const config = {
    matcher: ["/((?!_next/static|_next/image|favicon.ico).*)"],
}
