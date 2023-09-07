package com.example.jetpackcomposecourseoutline

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecourseoutline.ui.theme.IntentActivity

class SelectionControlActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Demo()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Demo() {

    Column(modifier = Modifier.fillMaxSize()) {

        var mcontext= LocalContext.current

        //TopAppBar
        //TopAppBar -displays information and actions relating to the current screen and is placed at the top of the screen.
        TopAppBar(
            title = { Text("Selection Controls") },
            colors = TopAppBarDefaults.largeTopAppBarColors(Color.Magenta),
            navigationIcon = {
                val mcontext = LocalContext.current
                IconButton(onClick = {
                    mcontext.startActivity(
                        Intent(
                            mcontext,
                            MainActivity::class.java
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


        //ExtendedFloatingButton
        ExtendedFloatingActionButton(
            icon = { Icon(Icons.Filled.Favorite, "") },
            text = { Text("FloatingActionButton") },
            onClick = { /*do something*/ },
            elevation = FloatingActionButtonDefaults.elevation(8.dp),
        )


        Spacer(modifier = Modifier.height(20.dp))

        ExtendedFloatingActionButton(
            icon = { Icon(Icons.Filled.Favorite, "") },
            text = { Text("FloatingActionButton") },
            onClick = { /*do something*/ },
            elevation = FloatingActionButtonDefaults.elevation(8.dp),
            modifier = Modifier.padding(start = 180.dp)
        )

        Spacer(modifier = Modifier.height(100.dp))


            Button(
                onClick = {
                    mcontext.startActivity(Intent(mcontext, IntentActivity::class.java))
                },
                modifier = Modifier.padding(start = 260.dp, top = 260.dp),
                shape = CutCornerShape(3.dp),
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(text = "Go to intents")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = { mcontext.startActivity(Intent(mcontext, ImagePickerActivity::class.java)) },
                shape = CutCornerShape(3.dp),
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier.padding(start = 260.dp)
            ) {
                Text(text = "Imagepicker")
            
        }


        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { mcontext.startActivity(Intent(mcontext, RegistrationForm::class.java)) },
            shape = CutCornerShape(3.dp),
            colors = ButtonDefaults.buttonColors(Color.Black),
            modifier = Modifier.padding(start = 260.dp)
        ) {
            Text(text = "Capture")

        }

    }
}

@Preview(showBackground = true)
@Composable
fun SelectPreview(){
   Demo()

}
