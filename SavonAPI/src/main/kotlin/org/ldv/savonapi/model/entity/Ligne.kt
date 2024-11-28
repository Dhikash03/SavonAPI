package org.ldv.savonapi.model.entity
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.OneToMany
import org.ldv.savonapi.model.entity.Ingredient
import org.ldv.savonapi.model.entity.RecetteSavon
import org.ldv.savonapi.model.id.LigneId

@Entity
class Ligne(
    @EmbeddedId
    var ligneId: LigneId? = null,
    var quantiteIngredient : Float,
    var pourcentage : Float,

    @MapsId("ingredientId")
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    var ingredient: Ingredient? = null,

    @MapsId("recetteSavonId")
    @ManyToOne
    var recetteSavon: RecetteSavon? = null,

    val ligne: Float? = null
){}