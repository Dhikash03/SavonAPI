package org.ldv.savonapi.model.entity


import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
class RecetteSavon  (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var recetteSavonId : Long? = null,
    var description : String,
    var concentrationAgentAlcalin : Float,
    var surgraissageDesire : Float,
    var apportEnEau : Float,
    var qteAlcalin : Float,
    var avecSoude : Boolean,
    var titre  : String,


    @OneToMany(mappedBy = "recetteSavon")
    var ligne : MutableList<Ligne> = mutableListOf(),

    @OneToMany(mappedBy = "recetteSavon")
    var commentaire : MutableList<Commentaire> = mutableListOf(),

    /*
    @OneToMany(mappedBy = "recetteSavon")
    var utilisateur : MutableList<Utilisateur> = mutableListOf(),
*/
    @OneToMany(mappedBy = "recetteSavon")
    var resultat : MutableList<Resultat> = mutableListOf()

){
    fun calculQteAlcalin() {

        var qteAlcalinNormal = 0.0

        if (this.avecSoude) {
            qteAlcalinNormal = this.ligne.sumOf { (it.ingredient!!.sapo) * 40.0 / 56 / 1000.0 }.toDouble()
        } else {
            qteAlcalinNormal = this.ligne.sumOf { (it.ingredient!!.sapo) / 1000.0 }.toDouble()
        }

        qteAlcalin = (qteAlcalinNormal / (concentrationAgentAlcalin / 100)).toFloat()

        qteAlcalin -= (qteAlcalin * (surgraissageDesire / 100.0)).toFloat()

        qteAlcalin = this.qteAlcalin.toFloat()
    }

    fun calculApportEau(){

        var concentrationEau = ((100 - concentrationAgentAlcalin)/100).toFloat()

        apportEnEau = qteAlcalin * concentrationEau

        apportEnEau = this.apportEnEau
    }

    fun calculScoreNonPondere(){

        var ins = ligne.sumOf { it.ingredient!!.ins * it.pourcentage/100.0 }
        var iode = ligne.sumOf { it.ingredient!!.iode * it.pourcentage /100.0 }

        resultat.find { it.caracteristique!!.nom == "iode"}!!.score = iode.toFloat()
        resultat.find { it.caracteristique!!.nom =="ins"}!!.score = ins.toFloat()
    }

    fun calculPondere(){
        var scoresBase = 0.0

        var douceur = ligne.sumOf { it.ingredient!!.douceur * it.pourcentage / 100.0 }
        var lavant = ligne.sumOf { it.ingredient!!.lavant * it.pourcentage/100.0 }
        var volMousse = ligne.sumOf { it.ingredient!!.volMousse * it.pourcentage / 100.0 }
        var tenueMousse = ligne.sumOf { it.ingredient!!.tenueMousse * it.pourcentage / 100.0 }
        var durete = ligne.sumOf { it.ingredient!!.durete * it.pourcentage / 100.0 }
        var solubilite = ligne.sumOf { it.ingredient!!.solucibilite * it.pourcentage/100.0 }
        var sechage = ligne.sumOf { it.ingredient!!.sechage * it.pourcentage/ 100.0 }

        douceur = douceur * (1+0.01494 * surgraissageDesire)
        lavant = lavant * (1+-0.01203 * surgraissageDesire)
        volMousse = volMousse * (1+-0.00702 * surgraissageDesire)
        tenueMousse = tenueMousse * (1+0.01016 * surgraissageDesire)
        durete = durete * (1 +- 0.00602 * surgraissageDesire)
        solubilite = solubilite * (1+ 0.00250 * surgraissageDesire)
        sechage = sechage * (1+-0.00503 * surgraissageDesire)

/*
     for (unResultat in this.resultat){
         if(unResultat.caracteristique!!.nom=="douceur"){
             unResultat.score=douceur.toFloat()
         }
     }
        */
        this.resultat.find { it.caracteristique!!.nom=="douceur" }!!.score=douceur.toFloat()
        this.resultat.find { it.caracteristique!!.nom=="lavant" }!!.score=lavant.toFloat()
        this.resultat.find { it.caracteristique!!.nom=="volMousse" }!!.score=volMousse.toFloat()
        this.resultat.find { it.caracteristique!!.nom=="tenueMousse" }!!.score=tenueMousse.toFloat()
        this.resultat.find { it.caracteristique!!.nom=="durete" }!!.score=durete.toFloat()
        this.resultat.find { it.caracteristique!!.nom=="solucibilite" }!!.score=solubilite.toFloat()
        this.resultat.find { it.caracteristique!!.nom=="sechage" }!!.score=sechage.toFloat()
    }






}
