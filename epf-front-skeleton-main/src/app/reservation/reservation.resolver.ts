import { Injectable } from "@angular/core"
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from "@angular/router"
import { Observable } from "rxjs"
import { ReservationService } from "services/reservation.service"
import { Reservation } from "models/reservation.model"

@Injectable({
  providedIn: "root",
})
export class ReservationResolver implements Resolve<Reservation[]> {
  constructor(private reservationService: ReservationService) {
  }

  resolve(): Observable<Reservation[]> {
    return this.reservationService.findAll()
  }
}
