package com.example.composedemo

import android.app.appsearch.SearchResults
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
//            ListView(R.drawable.baseline_heart_broken_24,"joh doe","software engineer")

//                WelcomeScreen("raash")
//                    Counter()
//                    LoginScreen()
                       // SearchBar()
//                         LightBulb()

//                            Room()
//            Log.d("TAG", "onCreate: ")
//                            Box1()
//                            Box2()
//                                TextBox()
//                        Verticalist()
            HorizontalList()
        }
    }
}


//basic exercise 1
@Composable
fun WelcomeScreen(userName: String){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
        ){
        Text(
            text = "hello $userName",
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold,
            color = Color.Blue,
            textAlign = TextAlign.Center
        )
    }
    }



@Preview()
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen("raas")
}




//exercise 2 -> State and Recomposition

//this wont work
@Composable
fun Counter() {
    // This resets to 0 on every recomposition!
    var count = 0

    Button(onClick = { count++ }) {
        Text("Count: $count")
    }
}


@Composable
fun Counter1(){
    val count =  remember { mutableStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(onClick = {count.value++ }) {
            Text("clicked ${count.value}")
        }
    }
}



//remember vs rememberSaveable
//remember: Preserves state during recomposition but lost on configuration changes
//rememberSaveable: Persists across configuration changes using SavedStateHandle


@Composable
fun LoginScreen(){
    val username = remember { mutableStateOf("") }
    val passWord = rememberSaveable { mutableStateOf("") }


        Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
            TextField(value = username.value, onValueChange = { username.value = it })
            TextField(value = passWord.value, onValueChange = { passWord.value = it })        }



}





//State Hoisting


// BAD - Switch trapped inside the lightbulb
@Composable
fun LightBulb(){
        var isOn by remember { mutableStateOf(false) }

        Button(onClick = {isOn =! isOn}) {
            if (isOn){
                Text("💡 Light is ON")
            }else{
                Text("💡 Light is OFF")
            }

        }

}


@Composable
fun LightBulb(
    isOn: Boolean,
    toggle: () -> Unit
){
        Button(onClick = toggle) {
            if (isOn){
                Text("💡 Light is ON")
            }else{
                Text("⚫ Light is OFF")
            }
        }
}


@Composable
fun Room(){

    var isLightOn by remember { mutableStateOf(false) }

    LightBulb(
        isLightOn,
        toggle = {isLightOn = !isLightOn}

    )

    if (isLightOn) {
        Text("💰 Electricity bill: $10")
    } else {
        Text("💰 Electricity bill: $0")
    }


}



//Modifiers - order matters
@Composable
fun Box1(){
    Text(
        text = "Hello",
        modifier = Modifier
                    .padding(46.dp)
                    .background(Color.Blue),
        fontSize = 20.sp





    )
}


@Composable
fun Box2(){
    Text(
        text = "world",
        modifier = Modifier
                   .background(Color.Blue)
            .padding(46.dp),
                fontSize = 20.sp
    )
}




//modifiers available
@Composable
fun TextBox(){
    Text(
        "hello this is",
        modifier = Modifier.size(200.dp)
            .width(200.dp)
            .height(20.dp)
            .padding(16.dp)
            .background(Color.Cyan)
//            .border(2.dp, Color.Blue)
            .clip(RoundedCornerShape(8.dp))
//            .shadow(3.dp)

    )



}




//Core Concept - Layouts
@Composable
fun Verticalist(){
    Column(
            modifier = Modifier.fillMaxSize()
            .padding(6.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text("Item 1")
        Text("Item 2")
        Text("Item 3")
    }
}


@Composable
fun HorizontalList(){
    Row(
modifier = Modifier.fillMaxSize()
    .padding(6.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Button(onClick = {}) {Text("click 1") }
        Button(onClick = {}) { Text("click 2")}


    }
}








