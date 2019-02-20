import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class ProcessService {

  constructor(private http: HttpClient) { }

  startProcess() {
    var token = {
      'username': localStorage.getItem('username'),
      'role': localStorage.getItem('role')
    }
    return this.http.post('api/process/start', token);
  }

  getTasks() {
    var token = {
      'username': localStorage.getItem('username'),
      'role': localStorage.getItem('role')
    }
    return this.http.post('api/process/get/tasks', token);
  }

  getTaskForm(taskId){
    return this.http.get('api/process/get/' + taskId);
  }

  submitTaskForm(taskId, form){
    return this.http.post('api/process/submit/' + taskId, form);
  }

}