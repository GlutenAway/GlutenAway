import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AdminHomeComponent } from "./pages/admin-home/admin-home.component";
import { NotFoundComponent } from "src/app/core/pages/not-found/not-found.component";
import { AdminListProductsComponent } from "./pages/manage-products/products/admin-list-products/admin-list-products.component";
import { NewProductComponent } from "./pages/manage-products/products/new-product/new-product.component";
import { EditProductComponent } from "./pages/manage-products/products/edit-product/edit-product.component";

const routes: Routes = [
    {
        path: 'admin',
        children: [
        {
            path: '',
            component: AdminHomeComponent
        },
        {
            path: 'products',
            children: [
                {
                    path: '',
                    component: AdminListProductsComponent
                },
                {
                    path: 'new',
                    component: NewProductComponent
                },
                {
                    path: 'edit/:id',
                    component: EditProductComponent
                },
                {
                    path: '**',
                    component: NotFoundComponent
                }
            ]
        },
        {
            path:'**',
            component: NotFoundComponent
        }
    ]}
]
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })
  export class AdminRoutingModule { }