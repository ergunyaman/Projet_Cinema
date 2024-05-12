import { Course } from "./course.model"
import { Major } from "./major.model"

export interface Utilisateur {
  id_User?: bigint
  nom: string
  prenom: string
  mdp: string
  mail: string
}
