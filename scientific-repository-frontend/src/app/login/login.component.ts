import { LoginService } from './../services/login.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService]
})
export class LoginComponent implements OnInit {

  private role = "author";
  private username;
  private password;

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit(){
    this.loginService.login(this.username, this.password, this.role).subscribe((data: any) => {
      localStorage.setItem('username', data.username);
      localStorage.setItem('role', data.role);
      this.router.navigate(['tasks']);
    }, error => {
      alert('wrong credentials')
    })
  }
}
