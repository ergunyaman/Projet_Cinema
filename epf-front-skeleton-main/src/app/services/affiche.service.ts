import { Injectable } from "@angular/core"
import { Observable } from "rxjs"
import { Seance } from "models/affiche.model"
import { Course } from "models/course.model"
import { HttpClient } from "@angular/common/http"

@Injectable({
  providedIn: "root",
})
export class AfficheService {
  constructor(private http: HttpClient) {
  }

  private seancesUrl = "http://localhost:8080/seances"

  findAll(): Observable<Seance[]> {
    return this.http.get<Seance[]>(this.seancesUrl)
  }

  findById(id: number): Observable<Seance> {
    return this.http.get<Seance>(`${this.seancesUrl}/${id}`)
  }

  update(id: number, seance: Seance): Observable<Seance> {
    return this.http.post<Seance>(`${this.seancesUrl}/${id}`, seance)
  }

  create(seance: Seance): Observable<Seance> {
    return this.http.post<Seance>(this.seancesUrl, seance)
  }

  delete(seance: Seance) {
    return this.http.delete(`${this.seancesUrl}/${seance.id_seance}`)
  }

  /*
  addCourseToStudent(seance: Seance, course: Course) {
    if (seance.courses == undefined) {
      seance.courses = [course]
    } else {
      seance.courses.push(course)
    }
    return seance
  }

  removeCourseToStudent(seance: Seance, course: Course) {
    const index = seance.courses?.indexOf(course)
    if (index!! > -1) {
      seance.courses?.splice(index!!, 1)
    }
    return seance
  }*/

}
