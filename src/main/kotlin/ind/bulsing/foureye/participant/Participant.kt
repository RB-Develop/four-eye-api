package ind.bulsing.foureye.participant

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Participant(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Int? = null,
    var status: ParticipantStatus,
    var firstName: String,
    var lastName: String,
    var age: Int
)
