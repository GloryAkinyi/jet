package com.example.jetpackcomposecourseoutline

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class InsertActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            firebaseUI()

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun firebaseUI() {
    val context= LocalContext.current
    val courseName = remember { mutableStateOf("") }
    val courseDuration = remember { mutableStateOf("") }
    val courseDescription = remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(Color.White),
    ) {

        //TopAppBar -displays information and actions relating to the current screen and is placed at the top of the screen.
        TopAppBar(
            title = { Text("Add data") },
            colors = TopAppBarDefaults.largeTopAppBarColors(Color.Green),
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
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            TextField(
                value = courseName.value,
                onValueChange = { courseName.value = it },
                placeholder = { Text(text = "Enter your course name") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = courseDuration.value,
                onValueChange = { courseDuration.value = it },
                placeholder = { Text(text = "Enter your course duration") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = courseDescription.value,
                onValueChange = { courseDescription.value = it },
                placeholder = { Text(text = "Enter your course description") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                singleLine = true,
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    if (TextUtils.isEmpty(courseName.value.toString())) {
                        Toast.makeText(context, "Please enter course name", Toast.LENGTH_SHORT)
                            .show()
                    } else if (TextUtils.isEmpty(courseDuration.value.toString())) {
                        Toast.makeText(context, "Please enter course Duration", Toast.LENGTH_SHORT)
                            .show()
                    } else if (TextUtils.isEmpty(courseDescription.value.toString())) {
                        Toast.makeText(
                            context,
                            "Please enter course descritpion",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        addDataToFirebase(
                            courseName.value, courseDuration.value, courseDescription.value, context
                        )
                    }
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {

                Text(text = "Add Data", modifier = Modifier.padding(8.dp))
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    context.startActivity(Intent(context, CourseDetailsActivity::class.java))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Text(text = "View Courses", modifier = Modifier.padding(8.dp))
            }
        }
    }
}

fun addDataToFirebase(courseName: String, courseDuration: String, courseDescription: String,
    context: Context
) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val dbCourses: CollectionReference = db.collection("Courses")
    val courses = Course(courseName, courseDescription, courseDuration)
    dbCourses.add(courses).addOnSuccessListener {
        Toast.makeText(context, "Your Course has been added to Firebase Firestore", Toast.LENGTH_SHORT).show()

    }.addOnFailureListener { e ->
        Toast.makeText(context, "Fail to add course", Toast.LENGTH_SHORT).show()
    }

}

@Preview(showBackground = true)
@Composable
fun FirebaseUiPreview() {
    firebaseUI()
}