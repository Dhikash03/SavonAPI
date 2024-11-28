package org.ldv.savonapi.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
/*
@Entity
class Role (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Int,
    var visiteur : String,
    var admin : String,
    var utilisateur : String,

    @OneToMany(mappedBy = "Role")
    var utilisateurs : MutableList<Utilisateur> = mutableListOf(),

) {
}*/