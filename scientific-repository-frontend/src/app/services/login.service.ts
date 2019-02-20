import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class LoginService {

  constructor(private http: HttpClient) { }

  login(username, password, role){
    return this.http.post('api/login/' + role, {"username": username, "password": password});
  }
}
