package com.example.a19200211_20200077_limonadaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.a19200211_20200077_limonadaapp.ui.theme._19200211_20200077_LimonadaAppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _19200211_20200077_LimonadaAppTheme {
                // A surface container using the 'background' color from the theme
                LimonadaApp()
            }
        }
    }
}

@Preview
@Composable
fun LimonadaApp(){

    BotoneImagen(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)

    )
}
@Composable
fun BotoneImagen(modifier: Modifier = Modifier){
    var imagen by remember{ mutableStateOf(1) } //inicializamos en la primera imagen
    val imagenMostrada = when(imagen){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_squeeze
        4 -> R.drawable.lemon_squeeze
        5 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val textoMostrado = when(imagen){
        1 -> R.string.arbol
        2 -> R.string.limon
        3 -> R.string.limon
        4 -> R.string.limon
        5 -> R.string.limonada_llena
        else -> R.string.limonada_vacia
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = { if (imagen < 6) imagen=imagen + 1 else imagen=1 }
            ) {
            Image(painter = painterResource(imagenMostrada),contentDescription = null )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(stringResource(textoMostrado),fontSize = 18.sp)
    }
}