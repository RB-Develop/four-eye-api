package ind.bulsing.foureye.changes

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "changes")
data class Change (
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Int? = null,
    var status: ChangeStatus,
    var targetTable: ChangeTarget,
    var change: String,
    var username: String,
    var approvingUser: String? = null
)

enum class ChangeStatus {
    PROPOSED, APPROVED, DENIED
}