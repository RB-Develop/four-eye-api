package ind.bulsing.foureye.changes

import org.springframework.stereotype.Component

@Component
class ChangesProcessorRegistrar() {
    companion object {
        val changeProcessors: MutableMap<ChangeTarget, ChangeProcessor> = mutableMapOf()
    }

    fun registerProcessor(changeTarget: ChangeTarget, changeProcessor: ChangeProcessor) {
        if (changeProcessors.containsKey(changeTarget)) {
            throw IllegalStateException("Cannot have a duplicate processor for change target $changeTarget")
        }

        changeProcessors[changeTarget] = changeProcessor
    }
}