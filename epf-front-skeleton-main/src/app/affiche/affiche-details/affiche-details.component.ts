import { Component, OnInit } from "@angular/core"
import { map, Observable } from "rxjs"
import { Student } from "models/student.model"
import { ActivatedRoute, Router } from "@angular/router"

import { AfficheService } from "services/affiche.service"

import { Seance } from "../../models/affiche.model"

@Component({
  selector: "epf-student-details",
  templateUrl: "./affiche-details.component.html",
  styleUrls: ["./affiche-details.component.scss"],
})
export class AfficheDetailsComponent {
  seance$: Observable<Seance> = this._route.data.pipe(map((data) => data["seance"]))

  notSelectedCourse: boolean | undefined
  today = new Date(Date.now())
  private afficheService: any

  constructor(
    private _route: ActivatedRoute,

    private router: Router,
  ) {
  }

  courseClick() {
    this.seance$ = this.afficheService.findAll()
  }



  delate(seance: Seance) {
    this.afficheService.delate(seance)
  }

  add(seance: Seance) {
    this.afficheService.add(seance)
  }

  save(student: Student) {
    const id = this._route.snapshot.params["id"]


    if (id == "new") {
      this.afficheService.create(student).subscribe(() => {
        this.router.navigate(["students"])
      })
    } else {
      this.afficheService.update(id, student).subscribe(() => {
        this.router.navigate(["students"])
      })
    }
  }

  // because the format of the date doesn't fit date picker
  updateBirthdate($event: any, student: Student) {
    student.birthdate = new Date($event)
  }
}
