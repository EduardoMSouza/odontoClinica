"use client"

import DashboardLayout from "@/components/layout/DashboardLayout"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"
import { Button } from "@/components/ui/button"
import Link from "next/link"
import { CalendarDays, Users, ClipboardList, Settings, Stethoscope } from "lucide-react"
import {redirect} from "next/navigation";

export default function HomePage() {
    redirect("/login")
}
