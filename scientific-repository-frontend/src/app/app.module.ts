import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';



import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { TasksComponent } from './tasks/tasks.component';
import { AuthorsThesesComponent } from './authors-theses/authors-theses.component';
import { ThesesComponent } from './theses/theses.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TasksComponent,
    AuthorsThesesComponent,
    ThesesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
