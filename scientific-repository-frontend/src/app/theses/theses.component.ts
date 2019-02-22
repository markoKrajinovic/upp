import { ProcessService } from './../services/process.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-theses',
  templateUrl: './theses.component.html',
  styleUrls: ['./theses.component.css'],
  providers: [ProcessService]
})
export class ThesesComponent implements OnInit {

  constructor(private processService: ProcessService) { }

  ngOnInit() {
    this.processService.getTheses().subscribe(data => {
      console.log(data);
    })
  }

}
