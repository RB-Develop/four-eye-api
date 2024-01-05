package ind.bulsing.foureye.changes

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ChangesController(var changeService: ChangesService) {
    @GetMapping("/changes")
    fun getChanges(): ResponseEntity<List<Change>> {
        val changes = changeService.getChanges()
        return ResponseEntity.ok(changes)
    }

    @PutMapping("/changes")
    fun approveChange(@RequestBody approvalRequest: ChangeApprovalRequest): ResponseEntity<Change> {
        val approvedChange = changeService.approveChange(approvalRequest)
        return ResponseEntity.ok(approvedChange)
    }

    @GetMapping("/changes/{id}")
    fun getChange(@PathVariable id: Int): ResponseEntity<Change> {
        val change = changeService.getChange(id)
        return ResponseEntity.ok(change)
    }
}