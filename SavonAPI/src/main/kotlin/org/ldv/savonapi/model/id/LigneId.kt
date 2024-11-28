package org.ldv.savonapi.model.id

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class LigneId(
    val ingredientId: Long,
    val recetteSavonId: Long
): Serializable {
}

