package org.ldv.savonapi.model.entity


import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
class RecetteSavon  (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var recetteSavonId : Long? = null,
    var nom : String,
    var concentrationAgentAlcalin : Int,
    var surgraissageDesire : Int,
    var quantiteEau : Int,
    var quantiteAgentAlcalin : Int,

    @OneToMany(mappedBy = "recetteSavon")
    var ligne : MutableList<Ligne> = mutableListOf(),

    @OneToMany(mappedBy = "recetteSavon")
    var commentaire : MutableList<Commentaire> = mutableListOf(),

    /*
    @OneToMany(mappedBy = "recetteSavon")
    var utilisateur : MutableList<Utilisateur> = mutableListOf(),
*/
    @OneToMany(mappedBy = "recetteSavon")
    var resultat : MutableList<Resultat> = mutableListOf()


){
}