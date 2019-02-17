import { ProcessService } from './../process.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css'],
  providers: [ProcessService]
})
export class TasksComponent implements OnInit {

  private processId;
  private taskId;
  private tasks: any[];
  private formFields: any[];
  private enumValues = [];


  constructor(private processService: ProcessService) { }

  ngOnInit() {
      this.processService.getTasks().subscribe((data: any) => {
        this.tasks = data;
        
      })

  }

  doTask(taskId) {
    this.processService.getTaskForm(taskId).subscribe((data: any) => {
      this.formFields = data.formFields;
      this.taskId = data.taskId;
      this.formFields.forEach( (field) =>{
          
        if( field.type.name=='enum'){
          this.enumValues = Object.keys(field.type.values);
        }
      });
    })
  }

  onSubmit(value, form) {
    let o = new Array();
    for (var property in value) {
      //console.log(property);
      //console.log(value[property]);
      if(property == 'username_login'){
        localStorage.setItem('username', value[property]);
        localStorage.setItem('role', 'author');
        }
      o.push({ fieldId: property, fieldValue: value[property] });
    }

    console.log(o);

    this.processService.submitTaskForm(this.taskId, o).subscribe(data => {
      console.log(data);
      window.location.reload();
    });
  }

  publish(){
    this.processService.startProcess().subscribe((data: any) => {
      window.location.reload();
    })
  }

  logout(){
    localStorage.clear();
  }
}
