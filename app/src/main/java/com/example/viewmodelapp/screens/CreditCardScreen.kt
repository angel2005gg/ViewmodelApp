//package com.example.viewmodelapp.screens
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Card
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import com.example.viewmodelapp.CreditCardViewModel
//import com.example.viewmodelapp.model.CreditCard
//import com.example.viewmodelapp.model.CreditCardResponse
//
//@Composable
//fun CreditCardScreen(viewModel: CreditCardViewModel){
//    val creditCard by viewModel.creditCards.observeAsState(null)
//    LaunchedEffect(Unit) {
//        viewModel.fetchCreditCards()
//
//    }
//    Column {
//        if (creditCard == null){
//            // mostrar indicador
//            Text(text = "Cargandoo.,.,")
//
//        }else{
//            CreditCardItem(creditCard!!)
//        }
//    }
//}
//@Composable
//fun CreditCardItem(creditCard: CreditCardResponse){
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//
//    ){
//        Column (modifier = Modifier
//            .padding(16.dp)
//            .fillMaxWidth()) {
//            Text(
//                text = creditCard.credit_card_number,
//                style = MaterialTheme.typography.bodyLarge
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = creditCard.credit_card_expiry_date,
//                style = MaterialTheme.typography.bodyLarge
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = creditCard.credit_card_type,
//                style = MaterialTheme.typography.bodyLarge
//            )
//        }
//    }
//}