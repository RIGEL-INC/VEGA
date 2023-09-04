export interface User {
  username: string;
  password: string;
  returnSecureToken?: boolean;
}

export interface AuthResponse {
  idToken: string;
  expiresIn: string
}
