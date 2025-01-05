package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            Text(text = "hello josh")
//            SayCheesy()
//            TextUpdate()
            ListView(R.drawable.baseline_heart_broken_24,"joh doe","software engineer")


        }
    }
}


@Composable
fun SayCheesy(name: String = "cheesy") {
    Text(
        text = "hello $name",
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.SemiBold,
        color = Color.Red,
        fontSize = 30.sp,
        textAlign = TextAlign.Left
    )
}


//text composable
/*
@Preview(showBackground = true, name = "a1", showSystemUi = true, widthDp = 500, heightDp = 500)
@Composable
fun PreviewFunction() {
    SayCheesy("world")
}*/


//image composable
/*@Preview(showBackground = true, name = "a1", showSystemUi = true, widthDp = 300, heightDp = 500)
@Composable
fun PreviewFunction() {
    Image(painter = painterResource(id = R.drawable.baseline_heart_broken_24),
        contentDescription ="Dummy heart break",
        colorFilter = ColorFilter.tint(Color.Blue),
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center
        )
}*/

//button composable
/*
@Preview(showBackground = true, name = "a1", showSystemUi = true, widthDp = 300, heightDp = 100)
@Composable
fun PreviewFunction() {
   Button(onClick = {}, colors = ButtonDefaults.buttonColors(
       contentColor = Color.Yellow,
       containerColor = Color.Blue
       ), enabled = true
   ) {
       Text(text = "click me")
       Image(painter = painterResource(id = R.drawable.baseline_heart_broken_24), contentDescription = "d2")

   }
}*/


//Tex-input composable
/*
@Preview(showBackground = true, name = "a1", showSystemUi = true, widthDp = 300, heightDp = 100)
@Composable
fun PreviewFunction() {
   TextField(
       value = "hello world",
       onValueChange = {},
       label = {(Text(text = "enter message"))},
       placeholder = {}
   )
}*/


/*@Composable
fun TextUpdate() {
    val state = remember {
        mutableStateOf("")
    }
    TextField(
        value = state.value,
        onValueChange = { state.value = it },
        label = { Text("Label") }
    )

}*/

@Preview(showBackground = true, name = "a1", showSystemUi = true, widthDp = 300, heightDp = 500)
@Composable
fun TextUpdate() {
    /* Column(
         //this will take max space bw two text views.
         verticalArrangement = Arrangement.SpaceBetween,
         horizontalAlignment = Alignment.CenterHorizontally
     ) {
         Text(text = "first", fontSize = 34.sp)
         Text(text = "second", fontSize = 24.sp)
     }*/

    /*  Row(
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.Bottom
      ) {
          Text(text = "first", fontSize = 34.sp)
          Text(text = "second", fontSize = 24.sp)
      }*/

    /*
        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.baseline_heart_broken_24),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.Red)
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = ""
            )
        }*/
    Column {
        ListView(imgId = R.drawable.baseline_heart_broken_24, name = "john doe", occupation ="developer" )
        ListView(imgId = R.drawable.baseline_arrow_back_24, name = "john doe", occupation ="developer" )
        ListView(imgId = R.drawable.baseline_arrow_back_24, name = "john doe", occupation ="developer" )
        ListView(imgId = R.drawable.baseline_arrow_back_24, name = "john doe", occupation ="developer" )
        ListView(imgId = R.drawable.baseline_arrow_back_24, name = "john doe", occupation ="developer" )
    }

}


@Composable
fun ListView(imgId:Int,name:String,occupation:String) {

    Row (Modifier.padding(8.dp)){
        Image(
            painter = painterResource(id = imgId),
            contentDescription = "",
            modifier = Modifier.size(40.dp)
        )
        Column {
            Text(text = name, fontWeight = FontWeight.Bold)
            Text(text = occupation, fontWeight = FontWeight.Thin, fontSize = 12.sp)
        }
    }

}



