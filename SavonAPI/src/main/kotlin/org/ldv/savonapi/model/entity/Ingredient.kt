package org.ldv.savonapi.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany

@Entity
class Ingredient(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var ingredientid:Long?= null,
    var nomCorpsGras: String,
    var sapo: Int,
    var iode: Int,
    var ins: Int,
    var douceur: Float,
    var lavant: Float,
    var volMousse: Float,
    var tenueMousse: Float,
    var durete: Float,
    var solucibilite: Float,
    var sechage: Float,


    //@OneToMany(mappedBy = "ingredients")
    // var recetteSavon: MutableList<RecetteSavon>?= null
) {
}