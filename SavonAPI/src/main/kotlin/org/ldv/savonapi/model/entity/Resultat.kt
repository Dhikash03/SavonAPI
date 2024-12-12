package org.ldv.savonapi.model.entity

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import org.ldv.savonapi.model.id.ResultatId

@Entity
class Resultat(
    @EmbeddedId
    var resultatId: ResultatId? = null,

    @MapsId("caracteristiqueId")
    @ManyToOne
    @JoinColumn(name = "caracteristique_id")
    var caracteristique: Caracteristique? = null,

    @MapsId("recetteSavonId")
    @ManyToOne
    @JoinColumn(name = "recettesavon_id")
    var recetteSavon: RecetteSavon? = null,

    @MapsId("mentionId")
    @ManyToOne
    @JoinColumn(name ="mention_id")
    var mention: Mention? = null,


    var score: Float? = null
) {

}