import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminHomeComponent } from './pages/admin-home/admin-home.component';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminListProductsComponent } from './pages/manage-products/products/admin-list-products/admin-list-products.component';
import { NewProductComponent } from './pages/manage-products/products/new-product/new-product.component';
import { EditProductComponent } from './pages/manage-products/products/edit-product/edit-product.component';
import { ProductsNavbarComponent } from './components/products-navbar/products-navbar.component';
import { ListBrandsComponent } from './pages/manage-products/brands/list-brands/list-brands.component';
import { NewBrandComponent } from './pages/manage-products/brands/new-brand/new-brand.component';
import { EditBrandComponent } from './pages/manage-products/brands/edit-brand/edit-brand.component';
import { ListTypesComponent } from './pages/manage-products/product-types/list-types/list-types.component';
import { NewTypeComponent } from './pages/manage-products/product-types/new-type/new-type.component';
import { EditTypeComponent } from './pages/manage-products/product-types/edit-type/edit-type.component';

@NgModule({
  declarations: [
    AdminHomeComponent,
    AdminListProductsComponent,
    NewProductComponent,
    EditProductComponent,
    ProductsNavbarComponent,
    ListBrandsComponent,
    NewBrandComponent,
    EditBrandComponent,
    ListTypesComponent,
    NewTypeComponent,
    EditTypeComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule
  ],
  exports:[AdminHomeComponent]
})
export class AdminModule { }
