package com.example.homeassignment

class BootRepositoryImpl(
    private val bootLocalDataSource: BootLocalDataSource,
) : BootRepository {
    override fun addBootEvent(bootEvent: BootEvent) {
        bootLocalDataSource.addBootEvent(bootEvent)
    }

    override fun getLastTwoEventsDescending(): List<BootEvent> {
        return bootLocalDataSource.getLastTwoEventsDescending()
    }
}