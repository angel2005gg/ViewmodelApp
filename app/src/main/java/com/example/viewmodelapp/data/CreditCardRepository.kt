package com.example.viewmodelapp.data

import com.example.viewmodelapp.model.CreditCardResponse
import com.example.viewmodelapp.service.RetrofitInstance

class CreditCardRepository {
    private val creditCardService = RetrofitInstance.creditCardService
    suspend fun getCreditCards(): CreditCardResponse{
        return creditCardService.getCreditCards()
    }
}