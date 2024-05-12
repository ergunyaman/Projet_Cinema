import { Injectable } from "@angular/core"
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from "@angular/router"
import { Observable } from "rxjs"
import { Seance } from "../../models/affiche.model"
import { AfficheService } from "../../services/affiche.service"

@Injectable({
  providedIn: "root",
})
export class StudentDetailsResolver implements Resolve<Seance> {
  constructor(private afficheService: AfficheService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Seance> {
    if (route.params["id"] == "new") {
      // @ts-ignore
      return new Observable((observer) => observer.next({
        id: 0n,
        id_film: 0n,
        id_salle: 0n,
        prix: 0n,
      }))
    }
    return this.afficheService.findById(parseInt(route.params["id"], 10))
  }
}
