import type { NextRequest } from "next/server"
import { NextResponse } from "next/server"

export function middleware(req: NextRequest) {
    const token = req.cookies.get("token")?.value
    const isLoginPage = req.nextUrl.pathname.startsWith("/login")

    if (!token && !isLoginPage) {
        return NextResponse.redirect(new URL("/login", req.url))
    }

    if (token && isLoginPage) {
        return NextResponse.redirect(new URL("/dashboard/secretaria", req.url))
    }

    return NextResponse.next()
}
