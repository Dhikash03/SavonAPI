package org.ldv.savonapi.model.dao

import Caracteristique
import org.springframework.data.jpa.repository.JpaRepository

interface CaracteristiqueDAO: JpaRepository<Caracteristique, Long> {
}