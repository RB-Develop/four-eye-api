package ind.bulsing.foureye.changes

abstract class ChangeProcessor(
    changesService: ChangesService,
    changeTarget: ChangeTarget
) {
    init {
        changesService.
    }

    abstract fun processCreation();
    abstract fun processUpdate();
    abstract fun processDeletion();
}