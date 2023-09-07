package com.example.jetpackcomposecourseoutline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            list()
        }
    }
}

@Composable
fun list(){
    Column(modifier = Modifier.fillMaxSize()){

        //Horizontalscroll
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier.size(300.dp))
            Spacer(modifier = Modifier.width(10.dp))

            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier.size(300.dp))
            Spacer(modifier = Modifier.width(10.dp))

            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier.size(300.dp))
            Spacer(modifier = Modifier.width(10.dp))

            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier.size(300.dp))
            Spacer(modifier = Modifier.width(10.dp))

            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier.size(300.dp))
            Spacer(modifier = Modifier.width(10.dp))

            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier.size(300.dp))
            Spacer(modifier = Modifier.width(10.dp))

            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier.size(300.dp))
        }
        Spacer(modifier = Modifier.height(20.dp))


        //Verticalscroll
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier.size(300.dp))
            Spacer(modifier = Modifier.height(10.dp))

            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier.size(300.dp))
            Spacer(modifier = Modifier.height(10.dp))

            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier.size(300.dp))
            Spacer(modifier = Modifier.height(10.dp))

            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier.size(300.dp))
            Spacer(modifier = Modifier.height(10.dp))

            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier.size(300.dp))
            Spacer(modifier = Modifier.height(10.dp))

            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier.size(300.dp))
            Spacer(modifier = Modifier.height(10.dp))

            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = Modifier.size(300.dp))
        }






    }

}

@Preview(showBackground = true)
@Composable
fun ListPreview(){
    list()
}
