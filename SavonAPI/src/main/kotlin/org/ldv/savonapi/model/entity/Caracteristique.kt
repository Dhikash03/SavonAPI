import org.ldv.savonapi.model.entity.Mention



import jakarta.persistence.*

@Entity
class Caracteristique (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val caracteristiqueId: Int? = null,
    var nom : String? = null,

    @OneToMany(mappedBy = "caracteristiques")
    var mentions : MutableList<Mention>? =  null

){
}