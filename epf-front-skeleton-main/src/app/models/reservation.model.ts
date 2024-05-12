import { Utilisateur } from "./utilisateur.model"

export interface Reservation {
  Id_Reservation?: bigint
  Id_Seance?: bigint
  user: Utilisateur
}
