package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.Ligne

import org.ldv.savonapi.model.id.LigneId
import org.springframework.data.jpa.repository.JpaRepository

interface LigneDAO: JpaRepository<Ligne,LigneId>{
}