package com.example.jetpackcomposecourseoutline.ui.theme

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecourseoutline.MainActivity
import com.example.jetpackcomposecourseoutline.ui.theme.ui.theme.JetpackComposeCourseOutlineTheme

class IntentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myintents()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myintents(){
    Column(modifier = Modifier.fillMaxSize()) {

        val mcontext= LocalContext.current


        //TopAppBar
        //TopAppBar -displays information and actions relating to the current screen and is placed at the top of the screen.
        TopAppBar(
            title = { Text("Intents") },
            colors = TopAppBarDefaults.largeTopAppBarColors(Color.Magenta),
            navigationIcon = {
                val mcontext = LocalContext.current
                IconButton(onClick = {
                    mcontext.startActivity(Intent(mcontext, MainActivity::class.java
                    )
                    )
                }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            }, actions = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Build, null)
                }
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.AddCircle, null)
                }
            })
        Spacer(modifier = Modifier.height(20.dp))





        //INTENTS
       Column(modifier = Modifier.padding(top = 20.dp, start = 130.dp)) {
           //Simtoolkit intent
           Button(onClick = { mcontext.startActivity(Intent(mcontext.packageManager.getLaunchIntentForPackage("com.android.stk")))},
               shape = CutCornerShape(2.dp),
               colors = ButtonDefaults.buttonColors(Color.DarkGray),
               modifier = Modifier.size(150.dp,50.dp)) {
               Text(text = "PAY")
           }
           Spacer(modifier = Modifier.height(10.dp))

           //Google map intent
           Button(onClick = {mcontext.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/@-1.2648448,36.8017408,14z?entry=ttu"))) },
               shape = CutCornerShape(2.dp),
               colors = ButtonDefaults.buttonColors(Color.DarkGray),
               modifier = Modifier.size(150.dp,50.dp)) {
               Text(text = "Location", fontSize = 20.sp)
           }
           Spacer(modifier = Modifier.height(10.dp))

           //Email intent
           Button(onClick = {mcontext.startActivity(Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "akinyiglory2@gmail.com", null))) },
               shape = CutCornerShape(2.dp),
               colors = ButtonDefaults.buttonColors(Color.DarkGray),
               modifier = Modifier.size(150.dp,50.dp)) {
               Text(text = "Email", fontSize = 20.sp)
           }
           Spacer(modifier = Modifier.height(10.dp))


           //Call Intent
           val phone = "+34666777888"
           Button(onClick = {mcontext.startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))) },
               shape = CutCornerShape(2.dp),
               colors = ButtonDefaults.buttonColors(Color.DarkGray),
               modifier = Modifier.size(150.dp,50.dp)) {
               Text(text = "Call", fontSize = 20.sp)
           }
       }
        Spacer(modifier = Modifier.height(50.dp))



        //Sending message to Whatsapp
        val message = remember { mutableStateOf("") }
        val phoneNumber = remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Send SMS to WhatsApp",
                color = Color.Magenta,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            TextField(
                value = phoneNumber.value,
                onValueChange = { phoneNumber.value = it },
                placeholder = { Text(text = "Enter your whatsapp phone number") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = message.value,
                onValueChange = { message.value = it },
                placeholder = { Text(text = "Enter your message") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    mcontext.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(java.lang.String.format("https://api.whatsapp.com/send?phone=%s&text=%s", phoneNumber.value, message.value))
                        ))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                shape = CutCornerShape(1.dp),
                colors = ButtonDefaults.buttonColors(Color.Magenta)
            ) {
                Text(text = "Send Message on WhatsApp")
            }
        }

    }
    
}


@Preview(showBackground = true)
@Composable
fun IntentPreview(){
    myintents()
}
