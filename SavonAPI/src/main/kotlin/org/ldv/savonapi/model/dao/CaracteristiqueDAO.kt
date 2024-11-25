package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.Caracteristique

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CaracteristiqueDAO: JpaRepository<Caracteristique, Long> {
}