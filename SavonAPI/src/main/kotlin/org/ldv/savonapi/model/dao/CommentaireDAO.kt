package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.Commentaire

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentaireDAO : JpaRepository<Commentaire, Long> {
}