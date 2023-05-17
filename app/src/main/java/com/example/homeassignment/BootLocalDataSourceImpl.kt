package com.example.homeassignment

class BootLocalDataSourceImpl(
    private val bootEventDao: BootEventDao,
) : BootLocalDataSource {
    override fun addBootEvent(bootEvent: BootEvent) {
        val entity = BootEventEntity(
            bootEvent.timestamp
        )
        bootEventDao.addBootEvent(entity)
    }

    override fun getLastTwoEventsDescending(): List<BootEvent> {
        return bootEventDao.getLastTwoEntriesDescending().map {
            BootEvent(
                it.timestamp,
            )
        }
    }
}