import { Injectable } from "@angular/core"
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from "@angular/router"
import { Observable } from "rxjs"
import { Reservation } from "../../models/reservation.model"
import { ReservationService } from "../../services/reservation.service"
import { unwrapConstructorDependencies } from "@angular/compiler-cli/src/ngtsc/annotations/common"
import { Utilisateur } from "../../models/utilisateur.model"

@Injectable({
  providedIn: "root",
})
export class ReservationUsersResolver implements Resolve<Utilisateur[]> {
  constructor(private reservationService: ReservationService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Utilisateur[]> {
    return this.reservationService.findUsersFromReservation(route.params["id"])
  }
}
