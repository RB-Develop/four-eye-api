package ind.bulsing.foureye.changes

import ind.bulsing.foureye.participant.ParticipantCreationRequest
import ind.bulsing.foureye.participant.ParticipantService
import jakarta.transaction.Transactional
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Service

@Service
class ChangesService(
    val changesRepository: ChangesRepository,
    val participantService: ParticipantService
) {
    fun createParticipantCreationRequest(creationRequest: ParticipantCreationRequest): Change {
        return changesRepository.save(
            Change(
                status = ChangeStatus.PROPOSED,
                change = Json.encodeToString(creationRequest),
                username = creationRequest.requestingUser,
                targetTable = ChangeTarget.PARTICIPANT
            )
        )
    }

    fun getChange(id: Int): Change {
        return changesRepository.findById(id).orElseThrow()
    }

    fun getChanges(): List<Change> {
        return changesRepository.findAll().toList()
    }

    private fun processChange(change: Change) {
        when (change.targetTable) {
            ChangeTarget.PARTICIPANT -> participantService.createParticipant(Json.decodeFromString(change.change))
        }
    }

    @Transactional
    fun approveChange(approval: ChangeApprovalRequest): Change {
        val change = changesRepository
            .findById(approval.id)
            .orElseThrow()

        if (change.username == approval.approvingUser) {
            throw IllegalArgumentException("Cannot approve your own change")
        }

        change.status = ChangeStatus.APPROVED
        change.approvingUser = approval.approvingUser

        processChange(change)
        changesRepository.save(change)

        return change
    }
}