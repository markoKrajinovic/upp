import { ProcessService } from './../services/process.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-authors-theses',
  templateUrl: './authors-theses.component.html',
  styleUrls: ['./authors-theses.component.css'],
  providers: [ProcessService]
})
export class AuthorsThesesComponent implements OnInit {

  private theses: any[];

  constructor(private processService: ProcessService, private router: Router) { }

  ngOnInit() {
    this.processService.getThesesByAuthor(localStorage.getItem('username')).subscribe((data: any) => {
      console.log(data);
      this.theses = data;
    })
  }

  reviewerComments(thesisId){
    this.router.navigate(['/reviewer-comments/' + thesisId]);
  }

}
