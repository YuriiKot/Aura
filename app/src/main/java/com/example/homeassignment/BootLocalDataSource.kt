package com.example.homeassignment

interface BootLocalDataSource {
    fun addBootEvent(bootEvent: BootEvent)
    fun getLastTwoEventsDescending(): List<BootEvent>
}