package org.ldv.savonapi.model.entity

import Caracteristique
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
class Mention (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val mentionid : Long? = null,
    var mentionSavon : String? = null,
    var savonMini : Float? = null,
    var savonMaxi : Float? = null,
    /*
    @ManyToOne
    @JoinColumn(name = "caracteristique_id")
    var caracteristiques: Caracteristique? = null
    *
     */
){
}