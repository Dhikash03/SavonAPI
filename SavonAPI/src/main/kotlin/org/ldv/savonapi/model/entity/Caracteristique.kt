package org.ldv.savonapi.model.entity

import jakarta.persistence.*

@Entity
class Caracteristique(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    val caracteristiqueId: Long? = null,
    var nom : String? = null,


    @OneToMany(mappedBy = "caracteristiques")
    var mentions : MutableList<Mention>? =  null

) {
}