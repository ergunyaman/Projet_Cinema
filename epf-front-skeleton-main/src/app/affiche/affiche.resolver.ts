import { Injectable } from "@angular/core"
import { Resolve } from "@angular/router"
import { Observable } from "rxjs"
import { Student } from "models/student.model"
import { StudentService } from "services/student.service"
import { Seance } from "../models/affiche.model"
import { AfficheService } from "../services/affiche.service"

@Injectable({
  providedIn: "root",
})
export class AfficheResolver implements Resolve<Seance[]> {
  constructor(private afficheService: AfficheService) {
  }

  resolve(): Observable<Seance[]> {
    console.log(this.afficheService.findAll());
    return this.afficheService.findAll()
  }
}
