package org.ldv.savonapi.service

import org.ldv.savonapi.dto.LigneDTO
import org.ldv.savonapi.dto.RecetteFormDTO
import org.ldv.savonapi.model.dao.*
import org.ldv.savonapi.model.entity.Ligne
import org.ldv.savonapi.model.entity.RecetteSavon
import org.ldv.savonapi.model.entity.Resultat
import org.ldv.savonapi.model.id.LigneId
import org.ldv.savonapi.model.id.ResultatId
import org.springframework.stereotype.Service
/**
 * Service pour gérer la simulation et la création de recettes de savon.
 *
 * @property caracteristiqueDAO DAO pour accéder aux caractéristiques.
 * @property recetteDAO DAO pour accéder aux recettes.
 * @property ingredientDAO DAO pour accéder aux ingrédients.
 * @property ligneIngredientDAO DAO pour gérer lse lignes d'ingrédients.
 * @property mentionDAO DAO pour accéder aux mentions.
 * @property resultatDAO DAO pour accéder aux résultats.
 */

@Service
class SimulateurService(
    val caracteristiqueDAO: CaracteristiqueDAO,
    val recetteSavonDAO: RecetteSavonDAO,
    val ingredientDAO: IngredientDAO,
    val ligneIngredientDAO: IngredientDAO,
    val mentionDAO: MentionDAO,
    val resultatDAO: ResultatDAO
)  {
    fun toLigne(ligneDTO: LigneDTO, recetteSavon: RecetteSavon): Ligne {
        var ingredient =  ingredientDAO.findById(ligneDTO.ingredientId).get() //.get() lance une exception si rien est trouvé

        // Création de l'instance LigneIngredientId
        val ligneIngredientId = LigneId(
            ingredientId = ingredient.ingredientid!!,
            recetteSavonId = recetteSavon.recetteSavonId!!
        )

        val ligneIngredient = Ligne(
            ligneId = ligneIngredientId,
            quantiteIngredient = ligneDTO.quantite,
            pourcentage = ligneDTO.pourcentage // Si vous avez une propriété unité dans LigneDTO
        )

        return ligneIngredient
    }

    fun createResultats(recetteSavon: RecetteSavon):MutableList<Resultat> {
        var caracteristique = caracteristiqueDAO.findAll()

        if(caracteristique.isEmpty()){
            return mutableListOf()
        }
        var listeVide = mutableListOf<Resultat>()

        for (i in caracteristique) {
            val resultatId = ResultatId(i.caracteristiqueId!!,recetteSavon.recetteSavonId!!)
            val scoreResultat = 0.0f
            val resultat = Resultat(
                resultatId = resultatId, // Remplacez par la variable ou valeur de votre `resultatId`
                score = scoreResultat
            )

            listeVide.add(resultat)
        }

        return listeVide

    }

    fun assignMentionToResult(recetteSavon: RecetteSavon):RecetteSavon{

        for (resultat in recetteSavon.resultat){
            if(resultat.caracteristique!= null){
                var caracteristique = resultat.caracteristique
                var mention =  mentionDAO.findMentionByScoreAndCaracteristique(
                    score = resultat.score!!, caracteristique = caracteristique!!
                )
                if (mention!=null){
                    resultat.mention = mention
                }
                else{
                    println("Aucune mention trouvée pour le score et la caratéristique")
                }
            }
            return recetteSavon
        }
    }


    fun toRecette(recetteFormDTO: RecetteFormDTO): RecetteSavon{
        var recette = RecetteSavon(
            description = recetteFormDTO.description,
            concentrationAgentAlcalin = recetteFormDTO.concentrationAlcalin,
            surgraissageDesire = recetteFormDTO.surgraissage,
            apportEnEau = 0.0f,
            qteAlcalin = 0.0f,
            avecSoude = recetteFormDTO.avecSoude,
            titre = recetteFormDTO.tite
        )
        this.recetteSavonDAO.save(recette)
        for (ligneDTO in ligneIngredientDAO){

        }
    }
}