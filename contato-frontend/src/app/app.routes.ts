import { Routes } from '@angular/router';
import { Home } from './components/home/home';
import { ContatoList } from './components/contato-list/contato-list';
import { ContatoForm } from './components/contato-form/contato-form';
import { AuthGuard } from './guards/auth-guard';

export const routes: Routes = [
  { path: '', component: Home },
  { 
    path: 'contatos', 
    component: ContatoList,
    canActivate: [AuthGuard] 
  },
  { 
    path: 'contatos/editar/:id', 
    component: ContatoForm,
    canActivate: [AuthGuard] 
  },
  { path: '**', redirectTo: '' }
];