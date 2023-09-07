package com.example.jetpackcomposecourseoutline

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.model.content.CircleShape
import com.example.jetpackcomposecourseoutline.ui.theme.JetpackComposeCourseOutlineTheme

class AlerterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            popmessage()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun popmessage() {
    val mContext= LocalContext.current
    var search by remember { mutableStateOf("") }
    val btn= remember { mutableStateOf(false ) }

    Column(modifier = Modifier.fillMaxSize()) {

        //TopAppBar
        //TopAppBar -displays information and actions relating to the current screen and is placed at the top of the screen.
        TopAppBar(
            title = { Text("Alerter") },
            colors = TopAppBarDefaults.largeTopAppBarColors(Color.Magenta),
            navigationIcon = {
                val mcontext = LocalContext.current
                IconButton(onClick = {
                    mcontext.startActivity(
                        Intent(mcontext, MainActivity::class.java)
                    )
                }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            }, actions = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Search, null)
                }
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Add, null)
                }
            })
        Spacer(modifier = Modifier.height(10.dp))
        //Hauzisha
        OutlinedTextField(value =search ,
            onValueChange ={search=it},
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(10.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "")},
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
            placeholder = { Text(text = "Search...")},
            shape = RoundedCornerShape(10.dp)
            )

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Looking for a house?",
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 10.dp))

        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Card(onClick = { /*TODO*/ },
                modifier = Modifier.padding(10.dp)) {
                Image(painter = painterResource(id = R.drawable.img_1) ,
                    contentDescription = "",
                    modifier = Modifier
                        .size(width = 180.dp, height = 180.dp)
                        .padding(start = 10.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "KSH.10,000/pm",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "2 Bedroom",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Located near Pangani Girls",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Spacious",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 10.dp))

                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = { btn.value=true},
                    shape = CutCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    modifier = Modifier.padding(start = 10.dp)) {
                    Text(text = "Buy")
                }

                if (btn.value){
                    AlertDialog(onDismissRequest = {btn.value=false},
                        title = { Text(text = "Ecommerce App")},
                        text = { Text(text = "Do you want to continue with the payment")},
                        confirmButton = {
                            Button(onClick = { val simToolKitLaunchIntent =
                                mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                            },
                                shape = CutCornerShape(5.dp),
                                colors = ButtonDefaults.buttonColors(Color.Green)) {
                                Text(text = "PAY")
                            }
                        },
                        dismissButton = {
                            Button(onClick = { btn.value=false },
                                shape = CutCornerShape(5.dp),
                                colors = ButtonDefaults.buttonColors(Color.Red)) {
                                Text(text = "EXIT")

                            }
                        })

                }



            }
            

            //Card2
            Card(onClick = { /*TODO*/ },
                modifier = Modifier.padding(10.dp)) {
                Image(painter = painterResource(id = R.drawable.img_1) ,
                    contentDescription = "",
                    modifier = Modifier
                        .size(width = 180.dp, height = 180.dp)
                        .padding(start = 10.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "KSH.10,000/pm",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "2 Bedroom",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Located near Pangani Girls",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Spacious",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
                //AlertDialog

                Button(onClick = { btn.value=true},
                    shape = CutCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    modifier = Modifier.padding(start = 10.dp)) {
                    Text(text = "Buy")
                }
                if (btn.value){
                    AlertDialog(onDismissRequest = {btn.value=false},
                        title = { Text(text = "Ecommerce App")},
                        text = { Text(text = "Do you want to continue with the payment")},
                        confirmButton = {
                            Button(onClick = { val simToolKitLaunchIntent =
                                mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                            },
                                shape = CutCornerShape(5.dp),
                                colors = ButtonDefaults.buttonColors(Color.Green)) {
                                Text(text = "PAY")
                            }
                        },
                        dismissButton = {
                            Button(onClick = { btn.value=false },
                                shape = CutCornerShape(5.dp),
                                colors = ButtonDefaults.buttonColors(Color.Red)) {
                                Text(text = "EXIT")

                            }
                        })

            }
        }







        }





    }
}

@Preview(showBackground = true)
@Composable
fun popMessagePreview(){
    popmessage()
}