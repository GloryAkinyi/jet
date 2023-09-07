package com.example.jetpackcomposecourseoutline

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class ScaffoldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myscaffold()

        }

        }
}
@Composable
fun myContent(){
   Column {
       Text(text = "Hello world")
       Text(text = "Hello world")
       Text(text = "Hello world")
       Text(text = "Hello world")

   }

}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myscaffold(){
    Column(modifier = Modifier.fillMaxSize()){
        Scaffold (
            //TopAppBar
            topBar = { TopAppBar(title = { Text(text = "Top App Bar")},
                colors = TopAppBarDefaults.largeTopAppBarColors(Color.Green),
                navigationIcon = {
                    IconButton(onClick = {/* Do Something*/ }) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                },
                actions = {
                    IconButton(onClick = {/* Do Something*/ }) {
                        Icon(Icons.Filled.Share, null)
                    }
                    IconButton(onClick = {/* Do Something*/ }) {
                        Icon(Icons.Filled.Settings, null)
                    }
                })},
            //Content
            content = {
                      myContent()
            },

            //BottomAppBar
            bottomBar = {
               BottomAppBar {

               }

            })

    }


}


@Preview(showBackground = true)
@Composable
fun mycaffoldPreview(){
    myscaffold()

}
