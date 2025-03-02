package com.example.calculatepercentage.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatepercentage.R
import com.example.calculatepercentage.ui.screen.component.ZetaAlertDialog
import com.example.calculatepercentage.ui.screen.component.ZetaButtonBasic
import com.example.calculatepercentage.ui.screen.component.ZetaOutlinedTextField
import com.example.calculatepercentage.ui.screen.component.ZetaSpaceHeight
import com.example.calculatepercentage.ui.screen.component.ZetaTwoCards

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(R.string.title_app_bar), color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {
        ContentHomeScreen(it)
    }

}

@Composable
fun ContentHomeScreen(paddingValues: PaddingValues){
    Column(modifier = Modifier
        .padding(paddingValues)
        .padding(10.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var price by remember { mutableStateOf("") }
        var discount by remember { mutableStateOf("") }
        var priceDiscount by remember { mutableDoubleStateOf(0.0) }
        var totalDiscount by remember { mutableDoubleStateOf(0.0) }
        var showAlertDialog by remember { mutableStateOf(false) }

        ZetaTwoCards(
            title1 = stringResource(R.string.precio_total),
            number1 = priceDiscount,
            title2 = stringResource(R.string.descuento_card),
            number2 = totalDiscount
        )
        ZetaSpaceHeight(30.dp)
        ZetaOutlinedTextField(
            value = price,
            onValueChange ={ newValue ->
                if (newValue.all { it.isDigit() || it == '.' }) {
                    price = newValue
                }
            },
            label = stringResource(R.string.precio)
        )
        ZetaSpaceHeight()
        ZetaOutlinedTextField(
            value = discount,
            onValueChange = { newValue ->
                if (newValue.all { it.isDigit() || it == '.' }) {
                    discount = newValue
                }
            },
            label = stringResource(R.string.descuento)
        )
        ZetaSpaceHeight(40.dp)
        ZetaButtonBasic(
            text = stringResource(R.string.calcular),
            textSize = 18.sp,
            color = Color.Black
        ){
            if (price != "" && discount != ""){
                priceDiscount = calculatePrice(price.toDouble(), discount.toDouble())
                totalDiscount = calculateDiscount(price.toDouble(), discount.toDouble())

            }else{
                showAlertDialog = true

            }

        }
        ZetaSpaceHeight()
        ZetaButtonBasic(
            text = stringResource(R.string.limpiar),
            textSize = 18.sp,
            color = Color.Red
        ) {
            price = ""
            discount = ""
            priceDiscount = 0.0
            totalDiscount = 0.0
        }

        if (showAlertDialog){
            ZetaAlertDialog(
                title = stringResource(R.string.alerta),
                message = stringResource(R.string.message_alert),
                confirmText = stringResource(R.string.aceptar),
                onConfirmClick = { showAlertDialog = false }) {}
        }
    }
}

fun calculatePrice(price: Double, discount: Double):Double{
   val res = price - calculateDiscount(price, discount)
    return kotlin.math.round(res * 100) / 100

}

fun calculateDiscount(price: Double, discount: Double): Double {
    val res = price * (discount / 100)
    return kotlin.math.round(res * 100) / 100
}


