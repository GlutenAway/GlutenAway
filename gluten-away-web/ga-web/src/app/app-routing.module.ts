import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NotFoundComponent } from './core/pages/not-found/not-found.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: 'products',
    pathMatch: 'full'
  },
  {
    path:'products',
    loadChildren: () => import('./modules/products/products.module').then(m => m.ProductsModule)
  },
  {
    path:'establishments',
    loadChildren: () => import('./modules/establishments/establishments.module').then(m => m.EstablishmentsModule)
  },
  {
    path:'admin',
    loadChildren: () => import('./modules/admin/admin.module').then(m => m.AdminModule)
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
