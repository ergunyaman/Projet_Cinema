import { Component, OnInit } from "@angular/core"
import { map, Observable } from "rxjs"
import { Seance } from "../models/affiche.model"
import { ActivatedRoute, Router } from "@angular/router"
import { AfficheService } from "services/affiche.service"

@Component({
  selector: "epf-affiche",
  templateUrl: "./affiche.componant.html",
  styleUrls: ["./affiche.componant.scss"],
})
export class AfficheComponent implements OnInit {

  seancess$: Observable<Seance[]> = this._route.data.pipe(map((data) => {console.log(data)
  return data["seances"]
  }))

  constructor(private _route: ActivatedRoute, private afficheService: AfficheService, private router: Router,) {
  }

  deleteSeance(event: any, seance: Seance) {
    event.stopPropagation()
    this.afficheService.delete(seance).subscribe(() => this.router.navigate(["seances"]))
  }

  searchByMajorAndCourse($event: Observable<Seance[]>) {
    this.seancess$ = $event
  }

  ngOnInit(): void {
  }

}
