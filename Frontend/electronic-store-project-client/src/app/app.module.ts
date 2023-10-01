import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { SlickCarouselModule } from 'ngx-slick-carousel';

import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { HomeComponent } from './component/home/home.component';
import { ProductsingleComponent } from './component/productsingle/productsingle.component';
import { CartComponent } from './component/cart/cart.component';
import { CheckoutComponent } from './component/checkout/checkout.component';
import { ProductComponent } from './component/product/product.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { OrdersComponent } from './component/orders/orders.component';
import { LoginComponent } from './component/login/login.component';
import { SignupComponent } from './component/signup/signup.component';
import { ProfileDetailComponent } from './component/profile-detail/profile-detail.component';
import { OrderDetailComponent } from './component/order-detail/order-detail.component';
import { MenuInfoComponent } from './component/menu-info/menu-info.component';

import { httpInterceptorProviders } from './helpers/http.interceptor';
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    ProductsingleComponent,
    CartComponent,
    CheckoutComponent,
    ProductComponent,
    DashboardComponent,
    OrdersComponent,
    LoginComponent,
    SignupComponent,
    ProfileDetailComponent,
    OrderDetailComponent,
    MenuInfoComponent
  ],
  imports: [
    BrowserModule,
    SlickCarouselModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
