package com.camrrseis.labo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.camrrseis.labo2.ui.theme.Labo2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Labo2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize(),


        )
    {
        Column(
            modifier = Modifier
                .height(200.dp)
                .padding(10.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            ) {




        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    val nombre: MutableState<String> = remember {
                         mutableStateOf("")
                    }

                    val listanombres: MutableList<String> = remember {
                        mutableListOf()
                    }


                Text(text = "Añadir nombre", modifier = modifier)
                OutlinedTextField(
                    value = nombre.value,
                    onValueChange = {
                         nombre.value = it
                    },
                    label = { Text("nombre")},
                    modifier = Modifier)
            LazyRow{
            itemsIndexed(listanombres.toList()) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                { Text(
                    text = item
                )item(100) {
                    Text(text = "Posicion${index}:$item")
                }}
                /*/disculpe en serio pero no pude hacer el cuadro de arriba y no tuve tiempo por los dos parciales*/
            } }
        Button(
            onClick = { listanombres.add(nombre.value)
            nombre.value = ""}) {
            Text( text = "Añadir")
        }
        LazyRow (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(1f)
                .border(1.dp, MaterialTheme.colorScheme.primary))
        {
            itemsIndexed(listanombres.toList()) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = item
                    )
                    Text(
                        text = (index + 1).toString()
                    )
                }

            }}
        }
    }
}

/*/ borrar el index en la ultima parte
* Text(
                        text = "Posicion ${index): $item"
                    )
                    */

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Labo2Theme {
        Greeting("Android")
    }
}