package com.example.jetpackcomposecourseoutline

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardDemo()



        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardDemo() {
    var mcontext= LocalContext.current

    Column(modifier = Modifier
        .fillMaxSize()
        .paint(painterResource(id = R.drawable.img_2), contentScale = ContentScale.FillBounds)) {

        //TopAppBar -displays information and actions relating to the current screen and is placed at the top of the screen.
        TopAppBar(
            title = { Text("Homepage") },
            colors = TopAppBarDefaults.largeTopAppBarColors(Color.Magenta),
            navigationIcon = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            }, actions = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Share, null)
                }
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Settings, null)
                }
            })




        //CARDS
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { }) {
            Column(modifier = Modifier.padding(15.dp)) {
                Text(
                    buildAnnotatedString {
                        append("welcome to ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.W900,
                                color = Color(0xFF4552B8)
                            )
                        ) {
                            append("Jetpack Compose Playground")
                        }
                    }
                )

                Text(buildAnnotatedString {
                    append("Now you are in the")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold))
                    {
                        append("Section")
                    }
                })

            }

        }

        Spacer(modifier = Modifier.height(10.dp))
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { }) {
            Column(modifier = Modifier.padding(15.dp)) {
                Text(
                    buildAnnotatedString {
                        append("welcome to ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.W900,
                                color = Color(0xFF4552B8)
                            )
                        ) {
                            append("Jetpack Compose Playground")
                        }
                    }
                )

                Text(buildAnnotatedString {
                    append("Now you are in the")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold))
                    {
                        append("Section")
                    }
                })

            }

        }

        Spacer(modifier = Modifier.height(10.dp))
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { }) {
            Column(modifier = Modifier.padding(15.dp)) {
                Text(
                    buildAnnotatedString {
                        append("welcome to ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.W900,
                                color = Color(0xFF4552B8)
                            )
                        ) {
                            append("Jetpack Compose Playground")
                        }
                    }
                )

                Text(buildAnnotatedString {
                    append("Now you are in the")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold))
                    {
                        append("Section")
                    }
                })

            }

        }


        Spacer(modifier = Modifier.height(10.dp))

        //Divider-Draws a horizontal line
        Divider(thickness = 1.dp, color = Color.Black)

        Spacer(modifier = Modifier.height(10.dp))
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { }) {
            Column(modifier = Modifier.padding(15.dp)) {
                Text(
                    buildAnnotatedString {
                        append("welcome to ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.W900,
                                color = Color(0xFF4552B8)
                            )
                        ) {
                            append("Jetpack Compose Playground")
                        }
                    }
                )

                Text(buildAnnotatedString {
                    append("Now you are in the")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold))
                    {
                        append("Section")
                    }
                })

            }

        }

        Spacer(modifier = Modifier.height(10.dp))

        Divider()

        Spacer(modifier = Modifier.height(10.dp))




        //AlertDialog - Interrupts the user with urgent information,details or actions

        val btn = remember { mutableStateOf(false) }
        Button(
            onClick = { btn.value = true },
            shape = CutCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            modifier = Modifier.padding(30.dp)
        ) {
            Text("Click me!")
        }

        if (btn.value) {
            AlertDialog(
                onDismissRequest = { btn.value = false },
                title = { Text(text = "Ecommerce App") },
                text = { Text("Do you want to proceed?") },
                confirmButton = {
                    Button(
                        onClick = { val simToolKitLaunchIntent =
                            mcontext.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { mcontext.startActivity(it) }
                        },
                        shape = CutCornerShape(3.dp),
                        colors = ButtonDefaults.buttonColors(
                            Color.Green
                        )
                    ) {
                        Text("PAY")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = { btn.value = false },
                        shape = CutCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red)
                    ) {
                        Text("CANCEL")
                    }
                }
            )
        }

      Button(onClick = { mcontext.startActivity(Intent(mcontext,LottieAnimationActivity::class.java))},
          modifier = Modifier.padding(start = 260.dp, top = 50.dp),
          shape = CutCornerShape(3.dp),
          colors = ButtonDefaults.buttonColors(Color.Black),) {
          Text(text = "Next")
          
      }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { mcontext.startActivity(Intent(mcontext,InsertActivity::class.java))},
            shape = CutCornerShape(3.dp),
            colors = ButtonDefaults.buttonColors(Color.Black),
            modifier = Modifier.padding(start = 260.dp)) {
            Text(text = "Form")

        }

    }
}



@Preview(showBackground = true)
@Composable
fun CardsPreview(){
    CardDemo()

}
