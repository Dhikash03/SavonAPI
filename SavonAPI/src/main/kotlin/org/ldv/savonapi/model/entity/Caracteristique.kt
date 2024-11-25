import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
class Caracteristique (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val caracteristiqueId: Long? = null,
    var nom : String? = null

    /*
    @OneToMany(mappedBy = "caracteristiques")
    var mentions : MutableList<Mention>? =  null
    */


){
}