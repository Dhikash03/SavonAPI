package org.ldv.savonapi.controller

import org.ldv.savonapi.dto.RecetteFormDTO
import org.ldv.savonapi.model.dao.RecetteSavonDAO
import org.ldv.savonapi.model.entity.RecetteSavon
import org.ldv.savonapi.service.SimulateurService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api-savon/recetteSavon")
class RecetteSavonController(
    private val recetteSavonDAO: RecetteSavonDAO,
    private val simulateurService: SimulateurService
){

    @GetMapping
    fun getAllRecetteSavon(): List<RecetteSavon>{
        return recetteSavonDAO.findAll()
    }

    @GetMapping("{id}")
    fun getRecetteSavonById(@PathVariable id: Long): ResponseEntity<RecetteSavon> {
        val recetteSavon = recetteSavonDAO.findById(id)
        return if (recetteSavon.isPresent) {
            ResponseEntity.ok(recetteSavon.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/recetteSavon/{id}")
    fun deleteRecetteSavon(@PathVariable id: Long):ResponseEntity<Void>{
        return if (recetteSavonDAO.existsById(id)){
            recetteSavonDAO.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun store(@RequestBody recetteFormDTO: RecetteFormDTO): ResponseEntity<RecetteSavon>{

        val savedRecette = simulateurService.toRecette(recetteFormDTO)

        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecette)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody recetteFormDTO: RecetteFormDTO ) : ResponseEntity<RecetteSavon>{

        val 

    }

}
