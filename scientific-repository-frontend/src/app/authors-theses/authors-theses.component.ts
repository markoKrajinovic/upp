import { ProcessService } from './../services/process.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-authors-theses',
  templateUrl: './authors-theses.component.html',
  styleUrls: ['./authors-theses.component.css'],
  providers: [ProcessService]
})
export class AuthorsThesesComponent implements OnInit {

  constructor(private processService: ProcessService) { }

  ngOnInit() {
    this.processService.getThesesByAuthor(localStorage.getItem('username')).subscribe(data => {
      console.log(data);
    })
  }

}
