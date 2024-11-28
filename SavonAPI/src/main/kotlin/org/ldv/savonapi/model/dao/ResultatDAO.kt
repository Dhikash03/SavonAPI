package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.Resultat
import org.ldv.savonapi.model.id.ResultatId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ResultatDAO: JpaRepository<Resultat, ResultatId > {
}