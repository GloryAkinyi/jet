package com.example.jetpackcomposecourseoutline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class ImagecaptureActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent()
        }
    }
}



@Composable
fun AppContent() {


}

@Preview(showBackground = true)
@Composable
fun AppContentPreview(){
    AppContent()
}
