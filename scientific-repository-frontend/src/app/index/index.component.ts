import { ProcessService } from './../process.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css'],
  providers: [ProcessService]
})
export class IndexComponent implements OnInit {

  constructor(private processService: ProcessService, private router: Router) { }

  ngOnInit() {
  }

  publish(){
    this.processService.startProcess().subscribe((data: any) => {
      this.router.navigate(['tasks']);
    })
  }

}
