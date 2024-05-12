import { Injectable } from "@angular/core"
import { Observable } from "rxjs"
import { Reservation } from "models/reservation.model"
import { HttpClient } from "@angular/common/http"
import { Utilisateur } from "../models/utilisateur.model"

@Injectable({
  providedIn: "root",
})
export class ReservationService {
  constructor(private http: HttpClient) {
  }

  private reservationsUrl = "http://localhost:8080/reservations"

  findAll(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(this.reservationsUrl)
  }

  findById(id: number): Observable<Reservation> {
    return this.http.get<Reservation>(`${this.reservationsUrl}/${id}`)
  }

  update(id: number, reservation: Reservation): Observable<Reservation> {
    return this.http.post<Reservation>(`${this.reservationsUrl}/${id}`, reservation)
  }

  create(reservation: Reservation): Observable<Reservation> {
    return this.http.post<Reservation>(this.reservationsUrl, reservation)
  }

  delete(reservation: Reservation) {
    return this.http.delete(`${this.reservationsUrl}/${reservation.Id_Reservation}`)
  }

  findUsersFromReservation(Id_Reservation: string): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(this.reservationsUrl + `/${Id_Reservation}/students`)
  }
}
