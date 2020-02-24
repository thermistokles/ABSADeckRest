import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { DatePipe } from '@angular/common';


import { BatchstatusComponent } from './batchstatus/batchstatus.component';
import { NotFoundComponent } from './not-found/not-found.component';
import {SodComponent} from "./sod/sod.component";
import { Dm9Component } from './ltp-components/dm9/dm9.component';
import { TabsComponent } from './tabs/tabs.component';
import { TestingComponent } from './testing/testing.component';
import { KamlsHealthComponent } from './kamls-health/kamls-health.component';
import { PaymentsComponent } from './payments/payments.component';
import { VisionplushcComponent } from './visionplushc/visionplushc.component';
import { Dm9hcComponent } from './dm9hc/dm9hc.component';
import { LogoutnavComponent } from './logoutnav/logoutnav.component';
import {LoginnavComponent} from "./loginnav/loginnav.component";
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { TabsltpComponent } from './tabsltp/tabsltp.component';
import { PaymentViewComponent } from './ltp-components/payment-view/payment-view.component';
import { SodViewComponent } from './ltp-components/sod-view/sod-view.component';
import { AppstatusViewComponent } from './ltp-components/appstatus-view/appstatus-view.component';
import { VisionplusViewComponent } from './ltp-components/visionplus-view/visionplus-view.component';
import { Dm9hcViewComponent } from './ltp-components/dm9hc-view/dm9hc-view.component';
import { LtplogoutnavComponent } from './ltplogoutnav/ltplogoutnav.component';



@NgModule({
  declarations: [
    AppComponent,
    BatchstatusComponent,
    NotFoundComponent,
    SodComponent,
    Dm9Component,
    TabsComponent,
    TestingComponent,
    KamlsHealthComponent,
    PaymentsComponent,
    VisionplushcComponent,
    Dm9hcComponent,
    LoginnavComponent,
    LogoutnavComponent,
    HomeComponent,
    LoginComponent,
    TabsltpComponent,
    PaymentViewComponent,
    SodComponent,
    SodViewComponent,
    AppstatusViewComponent,
    VisionplusViewComponent,
    Dm9hcViewComponent,
    LtplogoutnavComponent
  ],
  
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
