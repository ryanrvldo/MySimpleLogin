package com.ryanrvldo.mysimplelogin

import com.ryanrvldo.mysimplelogin.di.storageModule
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.core.component.inject
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest

class MainActivityTest : KoinTest {

    private val userRepository: UserRepository by inject()
    private val username = "ryanrvldo"

    @Before
    fun setUp() {
        loadKoinModules(storageModule)
        userRepository.loginUser(username)
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun getUsernameFromRepository() {
        val requestedUsername = userRepository.getUser()
        assertEquals(username, requestedUsername)
    }
}