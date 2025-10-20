"use client"

import "./globals.css"
import { Toaster } from "@/components/ui/sonner"
import { ThemeProvider } from "@/components/theme-provider"
import { QueryClient, QueryClientProvider } from "@tanstack/react-query"
import React from "react";

const queryClient = new QueryClient()

export default function RootLayout({ children }: { children: React.ReactNode }) {
    return (
        <html lang="pt-BR" suppressHydrationWarning>
        <body className="min-h-screen bg-background text-gray-900 dark:bg-background-dark dark:text-gray-100 transition-colors duration-200">
        <ThemeProvider>
            <QueryClientProvider client={queryClient}>
                {children}
                <Toaster position="top-right" richColors />
            </QueryClientProvider>
        </ThemeProvider>
        </body>
        </html>
    )
}
