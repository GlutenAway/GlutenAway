import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminProductsComponent } from './admin/admin-products/admin-products/admin-products.component';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';

const routes: Routes = [
  {
    path: '',
    component: AdminHomeComponent
  },
  {
    path:'admin',
    children: [
      {
        path: 'home',
        component: AdminHomeComponent
      },
      {
        path: 'products',
        children: [
          {
            path: '',
            component: AdminProductsComponent //LIST PRODUCTS
          },
          {
            path: 'list',
            component: AdminProductsComponent //LIST PRODUCTS
          },
          {
            path: 'new',
            component: AdminProductsComponent //NEW PRODUCT
          },
          {
            path: ':id',
            component: AdminProductsComponent //EDIT PRODUCT
          },
          {
            path: '**',
            redirectTo: 'home'
          }

        ]
      }
    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
