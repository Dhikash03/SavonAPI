package org.ldv.savonapi.model.id

import java.io.Serializable

class CommentaireId(
    val utilisateurId : Long,
    val recetteSavonId : Long
) : Serializable{
}