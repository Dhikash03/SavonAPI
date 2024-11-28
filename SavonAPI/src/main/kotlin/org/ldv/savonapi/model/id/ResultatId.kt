package org.ldv.savonapi.model.id

import jakarta.persistence.Embeddable
import org.ldv.savonapi.model.entity.Caracteristique
import java.io.Serializable

@Embeddable
class ResultatId(
    val caracteristiqueId: Long,
    val recetteSavonId: Long
): Serializable {
}