package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.RecetteSavon
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RecetteSavonDAO : JpaRepository<RecetteSavon, Long> {
}