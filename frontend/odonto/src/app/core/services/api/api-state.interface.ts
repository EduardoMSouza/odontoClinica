// src/app/core/services/api/api-state.ts
export interface ApiState<T> {
  data: T | null;
  loading: boolean;
  error: string | null;
  success: boolean;
}

export interface ApiResponse<T> {
  data: T;
  message?: string;
  status: number;
}
