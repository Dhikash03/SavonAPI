package org.ldv.savonapi.model.dao

import org.ldv.savonapi.model.entity.Mention
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MentionDAO : JpaRepository<Mention, Long> {
}