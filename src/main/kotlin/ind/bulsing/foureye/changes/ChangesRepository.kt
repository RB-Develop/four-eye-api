package ind.bulsing.foureye.changes

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ChangesRepository: CrudRepository<Change, Int> {
}