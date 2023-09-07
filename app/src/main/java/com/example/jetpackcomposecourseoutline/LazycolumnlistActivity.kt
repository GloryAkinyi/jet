package com.example.jetpackcomposecourseoutline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class LazycolumnlistActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mylist()
        }
    }
}

@Composable
fun mylist(){
    Column(modifier = Modifier.fillMaxSize()
        .background(Color.Magenta)) {
        LazyColumn{
            //Adding a single item
            item {
                Text(text = "Header")
            }

            items (1000){index->
                Text(text = "First list items $index")


            }
        }

    }

}


@Preview(showBackground = true)
@Composable
fun mylistPreview(){
    mylist()
}
