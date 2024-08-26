package com.example.technicaltask1.search.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

const val SERVER_CODE_200 = 200
const val SERVER_CODE_400 = 400

class RetrofitNetworkClient(private val someApi: SomeApi) : NetworkClient {
    override suspend fun doRequest(): Response {
        return withContext(Dispatchers.IO) {
            try {
                val resp = someApi.getVacancy()
                resp.apply { resultCode = SERVER_CODE_200 }

            } catch (e: Throwable) {
                Response().apply { resultCode = SERVER_CODE_400 }
            }
        }
    }
}
