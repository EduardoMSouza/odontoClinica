// middleware.ts
import { NextResponse } from "next/server"

export function middleware(req) {
    const isLogged = req.cookies.get("token") // ou sessionStorage
    const isLoginPage = req.nextUrl.pathname.startsWith("/login")

    if (!isLogged && !isLoginPage) {
        return NextResponse.redirect(new URL("/login", req.url))
    }

    if (isLogged && isLoginPage) {
        return NextResponse.redirect(new URL("/dashboard/secretaria", req.url))
    }
}
