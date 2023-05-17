package com.example.homeassignment

interface BootRepository {
    fun addBootEvent(bootEvent: BootEvent)
    fun getLastTwoEventsDescending():List<BootEvent>
}