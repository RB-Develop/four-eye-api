package ind.bulsing.foureye.participant

import ind.bulsing.foureye.changes.ChangesService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class ParticipantController(var changesService: ChangesService) {
    @PostMapping("/participant")
    fun createParticipant(participant: ParticipantCreationRequest): ResponseEntity<URI> {
        val changeRequestId = changesService.createParticipantCreationRequest(participant).id
            ?: throw IllegalStateException("No change found")
        return ResponseEntity.created(URI.create("/changes/$changeRequestId")).build()
    }
}