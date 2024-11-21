package org.ldv.savonapi.model.dao

import Caracteristique
import org.ldv.savonapi.model.entity.Mention
import org.springframework.data.jpa.repository.JpaRepository

interface CaractéristiqueDAO : JpaRepository<Caracteristique, Long> {
}