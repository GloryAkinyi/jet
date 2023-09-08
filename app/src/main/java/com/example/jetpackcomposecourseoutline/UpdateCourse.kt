package com.example.jetpackcomposecourseoutline

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.FirebaseFirestore

class UpdateCourse : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            firebaseUI(
                LocalContext.current,
                intent.getStringExtra("courseName"),
                intent.getStringExtra("courseDuration"),
                intent.getStringExtra("courseDescription"),
                intent.getStringExtra("courseID")
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun firebaseUI(context: Context,name: String?, duration: String?, description: String?, courseID: String?) {

    val courseName = remember { mutableStateOf(name) }
    val courseDuration = remember { mutableStateOf(duration) }
    val courseDescription = remember { mutableStateOf(description) }

        Column(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White),
        ) {

            //TopAppBar -displays information and actions relating to the current screen and is placed at the top of the screen.
            TopAppBar(
                title = { Text("Update data") },
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

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TextField(
                    value = courseName.value.toString(),
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
                    value = courseDuration.value.toString(),
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
                    value = courseDescription.value.toString(),
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
                            Toast.makeText(
                                context,
                                "Please enter course Duration",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else if (TextUtils.isEmpty(courseDescription.value.toString())) {
                            Toast.makeText(
                                context,
                                "Please enter course description",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            updateDataToFirebase(
                                courseID,
                                courseName.value,
                                courseDuration.value,
                                courseDescription.value,
                                context
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = ButtonDefaults.buttonColors(Color.Green)
                ) {
                    Text(text = "Update Data", modifier = Modifier.padding(8.dp))
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { deleteDataFromFirebase(courseID, context) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = ButtonDefaults.buttonColors(Color.Green)
                ) {
                    Text(text = "Delete Course", modifier = Modifier.padding(8.dp))
                }
            }

        }
}

private fun deleteDataFromFirebase(courseID: String?, context: Context) {
    val db = FirebaseFirestore.getInstance();
    db.collection("Courses").document(courseID.toString()).delete().addOnSuccessListener {
        Toast.makeText(context, "Course Deleted successfully..", Toast.LENGTH_SHORT).show()
        context.startActivity(Intent(context, CourseDetailsActivity::class.java))
    }.addOnFailureListener {
        Toast.makeText(context, "Fail to delete course..", Toast.LENGTH_SHORT).show()
    }

}


private fun updateDataToFirebase(
        courseID: String?,
        name: String?,
        duration: String?,
        description: String?,
        context: Context
    ) {
    val updatedCourse = Courses(courseID, name, duration, description)
    val db = FirebaseFirestore.getInstance();
    db.collection("Courses").document(courseID.toString()).set(updatedCourse)
        .addOnSuccessListener {
            Toast.makeText(context, "Course Updated successfully..", Toast.LENGTH_SHORT).show()
            context.startActivity(Intent(context, CourseDetailsActivity::class.java))

        }.addOnFailureListener {
            Toast.makeText(context, "Fail to update course : " + it.message, Toast.LENGTH_SHORT)
                .show()
        }
}
