package ind.bulsing.foureye.participant

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ParticipantRepository: CrudRepository<Participant, Int> {
}