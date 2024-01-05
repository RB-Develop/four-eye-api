package ind.bulsing.foureye.participant

import org.springframework.stereotype.Service

@Service
class ParticipantService(
    val participantRepository: ParticipantRepository
) {
    fun createParticipant(participant: ParticipantCreationRequest): Participant {
        val newParticipant = Participant(
            status = ParticipantStatus.ACTIVE,
            firstName = participant.firstName,
            lastName = participant.lastName,
            age = participant.age
        )
        return participantRepository.save(newParticipant)
    }
}