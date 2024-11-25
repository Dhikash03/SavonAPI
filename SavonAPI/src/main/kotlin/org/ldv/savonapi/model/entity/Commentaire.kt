package org.ldv.savonapi.model.entity

import jakarta.persistence.*

import java.time.LocalDate

@Entity
class Commentaire(
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    val commentaireId: Long,
    val dateCommentaire: LocalDate? = null,
    val texte: String,

   /* @ManyToOne
    @JoinColumn(name = "recetteSavon_id")
    var recetteSavon: RecetteSavon? = null,

    @ManyToOne
    @JoinColumn(name = "utlisateur_id")
    var utilisateur: Utilisateur? = null*/
) {
}