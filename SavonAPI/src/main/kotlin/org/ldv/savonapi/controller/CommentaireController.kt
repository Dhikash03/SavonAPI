package org.ldv.savonapi.controller

import org.ldv.savonapi.model.dao.CommentaireDAO
import org.ldv.savonapi.model.entity.Commentaire
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api-savon/commentaire")
class CommentaireController(private val commentaireDAO: CommentaireDAO) {
    @GetMapping
    fun getAllCommentaire(): List<Commentaire> {
        return commentaireDAO.findAll()
    }

    @GetMapping("/{id}")
    fun getCommentaireById(@PathVariable id: Long): ResponseEntity<Commentaire> {
        val commentaire = commentaireDAO.findById(id)
        return if (commentaire.isPresent) {
            ResponseEntity.ok(commentaire.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createCommentaire(@RequestBody commentaire: Commentaire): ResponseEntity<Commentaire> {
        val savedCommentaire = commentaireDAO.save(commentaire)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCommentaire)
    }

    @PutMapping("/{id}")
    fun updateCommentaire(@PathVariable id: Long, @RequestBody commentaire: Commentaire): ResponseEntity<Commentaire> {
        return if (commentaireDAO.existsById(id)) {
            commentaire.commentaireId = id
            val updatedCommentaire = commentaireDAO.save(commentaire)
            ResponseEntity.ok(updatedCommentaire)
        } else {
            ResponseEntity.notFound().build()
        }
    }
    @DeleteMapping("/{id}")
    fun deleteCommentaire(@PathVariable id: Long): ResponseEntity<Void> {
        return if (commentaireDAO.existsById(id)) {
            commentaireDAO.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}