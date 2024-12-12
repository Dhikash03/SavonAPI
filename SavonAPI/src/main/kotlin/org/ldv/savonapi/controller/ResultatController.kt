package org.ldv.savonapi.controller

import org.ldv.savonapi.model.dao.RecetteSavonDAO
import org.ldv.savonapi.model.entity.RecetteSavon
import org.ldv.savonapi.service.SimulateurService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("api-savon/v1/recette")
class ResultatController(
    val simulateurService: SimulateurService,
    val recetteDAO : RecetteSavonDAO
) {
    @GetMapping
    fun getRecetteSavons() : List<RecetteSavon>{
        return recetteDAO.findAll()
    }
    @GetMapping("/{id}")
    fun getRecetteSavonsById( @PathVariable id: Long): ResponseEntity<RecetteSavon> {
        val recette = recetteDAO.findById(id)
        return if (recette.isPresent){
            ResponseEntity.ok(recette.get())
        } else{
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteRecetteSavon(@PathVariable id: Long): ResponseEntity<Void>{
        return if (recetteDAO.existsById(id)){
            recetteDAO.deleteById(id)
            ResponseEntity.noContent().build()
        } else{
            ResponseEntity.notFound().build()
        }
    }

}