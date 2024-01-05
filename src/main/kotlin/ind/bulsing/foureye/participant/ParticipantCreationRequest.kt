package ind.bulsing.foureye.participant

import jakarta.persistence.Embeddable
import kotlinx.serialization.Serializable

@Embeddable
@Serializable
data class ParticipantCreationRequest(
    var firstName: String,
    var lastName: String,
    var age: Int,
    var requestingUser: String
)
