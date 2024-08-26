package com.example.technicaltask1.search.data

interface NetworkClient {
    suspend fun doRequest(): Response
}