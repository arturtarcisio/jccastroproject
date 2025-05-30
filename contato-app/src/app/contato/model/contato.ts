export interface Contato {
  id?: number;
  nome: string;
  email?: string;
  celular: string;
  telefone?: string;
  favorito?: 'S' | 'N';
  ativo?: 'S' | 'N';
}
