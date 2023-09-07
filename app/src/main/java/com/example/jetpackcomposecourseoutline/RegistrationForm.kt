package com.example.jetpackcomposecourseoutline

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class RegistrationForm : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            form()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun form(){

    val mContext= LocalContext.current
    var fname by remember { mutableStateOf("") }
    var lname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxSize()){

        //TopAppBar -displays information and actions relating to the current screen and is placed at the top of the screen.
        TopAppBar(
            title = { Text("Form") },
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


        Text(text = "Register", fontSize = 50.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 100.dp), color = Color.Magenta, fontFamily = FontFamily.Cursive)
        Spacer(modifier = Modifier.height(5.dp))

        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()){
           Image(painter = painterResource(id = R.drawable.img_1),
               contentDescription ="",
               modifier = Modifier
                   .size(200.dp)
                   .clip(shape = CircleShape),
               contentScale = ContentScale.Crop)
       }
        Spacer(modifier = Modifier.height(10.dp))


        //Textfields
        Column (modifier = Modifier.padding(40.dp)){


            TextField(value = fname,
                onValueChange = { fname=it},
                label = { Text(text = "Firstname") },
                placeholder = { Text(text = "Enter your firstname")},
                modifier = Modifier.size(350.dp,50.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "lock")}
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(value = lname,
                onValueChange = { lname=it},
                label = { Text(text = "Lastname") },
                placeholder = { Text(text = "Enter your lastname")},
                modifier = Modifier.size(350.dp,50.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "lock")}
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(value = email,
                onValueChange = { email=it},
                label = { Text(text = "Email Address") },
                placeholder = { Text(text = "Enter email")},
                modifier = Modifier.size(350.dp,50.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "lock")}
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(value = password,
                onValueChange = { password=it},
                label = { Text(text = "Password") },
                placeholder = { Text(text = "Type password")},
                modifier = Modifier.size(350.dp,50.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "lock")},
                trailingIcon = { Icon(imageVector = Icons.Default.Check, contentDescription = "") }
            )
            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextField(value = phone,
                onValueChange = {phone=it},
                label = { Text(text = "Phone number")},
                placeholder = { Text(text = "Tyoe phone number")},
                modifier = Modifier.size(350.dp,50.dp),
                leadingIcon = { Icon(imageVector = Icons.Default.Call, contentDescription = "")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )


            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Magenta),
                shape = RectangleShape,
                modifier = Modifier.size(350.dp,50.dp)) {
                Text(text = "Signup")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(modifier = Modifier.clickable {
                mContext.startActivity(Intent(mContext,MainActivity::class.java))
            }) {
                Text(text = "Already have an account? LOGIN",
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(start = 30.dp)
                        .clickable {
                            mContext.startActivity(
                                Intent(
                                    mContext,
                                    ImageuploadActivity::class.java
                                )
                            )
                        },
                    color = Color.Blue)



            }


        }


    }

}

@Preview(showBackground = true)
@Composable
fun FormPreview(){
    form()

}
