package org.ldv.savonapi.service
import org.ldv.savonapi.model.dao.CaracteristiqueDAO
import org.ldv.savonapi.model.dao.IngredientDAO
import org.ldv.savonapi.model.dao.MentionDAO
import org.ldv.savonapi.model.entity.Caracteristique
import org.ldv.savonapi.model.entity.Ingredient
import org.ldv.savonapi.model.entity.Mention
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
@Component
class DataInitializer (val ingredientDAO: IngredientDAO,val caracteristiqueDAO: CaracteristiqueDAO,val mentionDAO: MentionDAO) : CommandLineRunner {
    override fun run(vararg args: String?) {
        //Pour importer les ingredients
        if (ingredientDAO.count() == 0L) { // Éviter les doublons
            var huileOlive=  Ingredient(1,"Huile d'olive",189,78,111,9.260f,10.192f,9.838f,9.152f, 10.144f,9.298f,10.194f                                                                     )
            var ingredients= listOf<Ingredient>(huileOlive)
            ingredientDAO.saveAll(ingredients)
        }

        // Pour importer les caracteristiques ...
        if (caracteristiqueDAO.count() == 0L) {
            val douceur= Caracteristique(nom = "douceur")
            val ins = Caracteristique(nom = "ins")
            val sapo = Caracteristique(nom = "sapo")
            val iode = Caracteristique(nom = "iode")
            val lavant = Caracteristique(nom = "lavant")
            val volMousse = Caracteristique(nom = "volMousse")
            val durete = Caracteristique(nom = "durete")
            val tenueMousse = Caracteristique(nom = "tenueMousse")
            val solucibilite = Caracteristique(nom = "solucibilite")
            val sechage = Caracteristique(nom = "sechage")

            caracteristiqueDAO.saveAll(
                listOf(
                    douceur,ins,sapo,iode,lavant,volMousse,durete,tenueMousse,solucibilite,sechage
                )
            )
            
            var mentionDouceur = Mention(mentionSavon = "faible", caracteristiques = douceur, savonMini = 0f, savonMaxi = 5f)
            var mentionIns = Mention(mentionSavon = "fort", caracteristiques = ins, savonMini = 25f, savonMaxi = 60f)
            var mentionSapo = Mention(mentionSavon = "faible", caracteristiques = sapo, savonMini = 0f, savonMaxi = 3f)
            var mentionIode = Mention(mentionSavon = "moyen", caracteristiques = iode, savonMini = 5f, savonMaxi = 25f)
            var mentionLavant = Mention(mentionSavon = "moyen", caracteristiques = lavant, savonMini = 3f, savonMaxi = 20f)
            var mentionVolMousse = Mention(mentionSavon = "fort", caracteristiques = volMousse, savonMini = 20f, savonMaxi = 55f)
            var mentiontenueMousse = Mention(mentionSavon = "faible", caracteristiques = tenueMousse, savonMini = 2f, savonMaxi = 10f)
            var mentionsolucibilite = Mention(mentionSavon = "moyen", caracteristiques = solucibilite, savonMini = 12f, savonMaxi = 35f)
            var mentionsechage = Mention(mentionSavon = "faible", caracteristiques = sechage, savonMini = 5f, savonMaxi = 10f)
            mentionDAO.saveAll(listOf(mentionDouceur,mentionIns,mentionSapo,mentionIode,mentionLavant,mentionVolMousse,mentiontenueMousse,mentionsolucibilite,mentionsechage))
        }
    }
}
