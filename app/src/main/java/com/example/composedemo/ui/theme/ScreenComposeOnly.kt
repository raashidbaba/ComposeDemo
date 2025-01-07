package com.example.composedemo.ui.theme

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.R

 class ScreenComposeOnly {


    @Preview(heightDp = 500)
    @Composable
    fun PreviewFun(){
        //vertical scroll

      /*  Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            getCategoryList().map {
                BlogCategory(img = R.drawable.baseline_heart_broken_24, title = "Developer", subtitle = "nerd developer")
            }
        }*/

        //lazy column

       LazyColumn(content = {
           items(getCategoryList()){ item ->
               BlogCategory(img = item.img, title = item.title, subtitle = item.subtitle)
           }

       })

    }



    //parameterized composable.
//    @Preview
    @Composable
    fun BlogCategory(img:Int ,title:String,subtitle:String) {
        Card() {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
                Image(
                    painter = painterResource(id = img),
                    contentDescription = "",
                    modifier = Modifier
                        .size(48.dp)
                        .padding(8.dp)
                        .weight(.2f)
                )
                ItemDes(title = title, subtitle = subtitle, modifier = Modifier.weight(.8f))
            }


        }

    }

}



// re-usable fun
@Composable
fun ItemDes(title: String,subtitle: String,modifier: Modifier){

    Column(modifier = modifier) {
        Text(
            text = title,

            //we can replace this line with
//                        fontWeight = FontWeight.Bold
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = subtitle,
            fontWeight = FontWeight.Thin, fontSize = 12.sp,
            style = MaterialTheme.typography.titleSmall
        )

    }
}



//data class
data class Category(val img: Int,val title: String,val subtitle: String)

fun getCategoryList():MutableList<Category>{
    val list = (mutableListOf <Category>())
    list.add(Category(R.drawable.baseline_heart_broken_24,  "john doe", "developer" ))
    list.add(Category(R.drawable.baseline_arrow_back_24,"john doe", "tech lead" ))
    list.add(Category(R.drawable.ic_launcher_foreground,"john doe","QA" ))
    list.add(Category(R.drawable.baseline_arrow_back_24,"john doe","manager" ))
    list.add(Category(R.drawable.baseline_arrow_back_24,"john doe","developer" ))
    list.add(Category(R.drawable.baseline_heart_broken_24,  "john doe", "developer" ))
    list.add(Category(R.drawable.baseline_arrow_back_24,"john doe", "tech lead" ))
    list.add(Category(R.drawable.ic_launcher_foreground,"john doe","QA" ))
    list.add(Category(R.drawable.baseline_arrow_back_24,"john doe","manager" ))
    list.add(Category(R.drawable.baseline_arrow_back_24,"john doe","developer" ))
    list.add(Category(R.drawable.baseline_heart_broken_24,  "john doe", "developer" ))
    list.add(Category(R.drawable.baseline_arrow_back_24,"john doe", "tech lead" ))
    list.add(Category(R.drawable.ic_launcher_foreground,"john doe","QA" ))
    list.add(Category(R.drawable.baseline_arrow_back_24,"john doe","manager" ))
    list.add(Category(R.drawable.baseline_arrow_back_24,"john doe","developer" ))

    return list
}