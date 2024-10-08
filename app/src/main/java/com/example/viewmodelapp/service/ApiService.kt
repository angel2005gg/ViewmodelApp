package com.example.viewmodelapp.service

import com.example.viewmodelapp.model.CreditCardResponse
import retrofit2.http.GET

interface ApiService {

    @GET("credit_cards")
    suspend fun getCreditCards(): CreditCardResponse
}