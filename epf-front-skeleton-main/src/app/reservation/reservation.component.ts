import { Component, OnInit } from "@angular/core"
import { map, Observable } from "rxjs"
import { Reservation } from "models/reservation.model"
import { ActivatedRoute, Router } from "@angular/router"
import { ReservationService } from "services/reservation.service"
import { parseJson } from "@angular/cli/src/utilities/json-file"
import { Student } from "../models/student.model"

@Component({
  selector: "epf-reservation",
  templateUrl: "./reservation.component.html",
  styleUrls: ["./reservation.component.scss"],
})
export class ReservationComponent {
  reservations$: Observable<Reservation[]> = this._route.data.pipe(map((data) => {
    console.log(data["majors"])
    return data["majors"]} ))


  constructor(private _route: ActivatedRoute,private reservationService: ReservationService, private router: Router,) {
  }

  deleteReservation(event: any, reservation: Reservation) {
    event.stopPropagation()
    this.reservationService.delete(reservation).subscribe(() => this.router.navigate(["reservations"]))
  }
}


