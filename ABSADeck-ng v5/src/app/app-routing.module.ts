import { NgModule } from '@angular/core';
import { Routes, RouterModule, Router } from '@angular/router';
import { BatchstatusComponent } from "./batchstatus/batchstatus.component";
import { NotFoundComponent } from "./not-found/not-found.component";
import {SodComponent} from "./sod/sod.component";
import {KamlsHealthComponent} from "./kamls-health/kamls-health.component";
import {PaymentsComponent} from "./payments/payments.component";
import {VisionplushcComponent} from "./visionplushc/visionplushc.component";
import {Dm9hcComponent} from "./dm9hc/dm9hc.component";
import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";
import {Dm9Component} from "./ltp-components/dm9/dm9.component";
import {Dm9hcViewComponent} from "./ltp-components/dm9hc-view/dm9hc-view.component";
import {PaymentViewComponent} from "./ltp-components/payment-view/payment-view.component";
import {SodViewComponent} from "./ltp-components/sod-view/sod-view.component";
import {VisionplusViewComponent} from "./ltp-components/visionplus-view/visionplus-view.component";
import {AppstatusViewComponent} from "./ltp-components/appstatus-view/appstatus-view.component";



const routes: Routes = [
  {
    path:'',
    component: HomeComponent,
  },
  {
    path:'login',
    component: LoginComponent
  },
  {
    path:'sod',
    component:SodComponent
  },
  {
    path:'dm9/batch',
    component:BatchstatusComponent
  },
  {
    path:'dm9/payment',
    component: PaymentsComponent
  },
 
  {
    path:'kamls/health',
    component:KamlsHealthComponent
  },
  {
    path:'dm9/health',
    component:Dm9hcComponent,
    pathMatch:'full'
  },
  {
    path:'visionplus',
    component:VisionplushcComponent
  },
  {
    path: 'report/dm9/health',
    component: Dm9hcViewComponent
  },
  {
    path: 'report/dm9/batch',
    component: Dm9Component
  },
  {
    path: 'report/dm9/payment',
    component: PaymentViewComponent
  },
  {
    path: 'report/sod',
    component: AppstatusViewComponent
  },
  {
    path: 'report/visionplus/hc',
    component: VisionplusViewComponent
  },
  {
    path:'**',
    component:NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {enableTracing:true}), ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
