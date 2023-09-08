package com.example.jetpackcomposecourseoutline

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.FirebaseFirestore

class CourseDetailsActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var courseList = mutableStateListOf<Courses?>()
            var db: FirebaseFirestore = FirebaseFirestore.getInstance()
            db.collection("Courses").get()
                .addOnSuccessListener { queryDocumentSnapshots ->
                    if (!queryDocumentSnapshots.isEmpty) {
                        val list = queryDocumentSnapshots.documents
                        for (d in list) {
                            val c: Courses? = d.toObject(Courses::class.java)
                            courseList.add(c)

                        }
                    } else {
                        Toast.makeText(this@CourseDetailsActivity, "No data found in Database", Toast.LENGTH_SHORT).show()
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(this@CourseDetailsActivity, "Fail to get the data.", Toast.LENGTH_SHORT).show()
                }
            firebaseUI(LocalContext.current, courseList)
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun firebaseUI(context: Context, courseList: SnapshotStateList<Courses?>) {
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //TopAppBar -displays information and actions relating to the current screen and is placed at the top of the screen.
        TopAppBar(
            title = { Text("Course Details") },
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

        LazyColumn {
            itemsIndexed(courseList) { index, item ->
                Card(onClick = {
                    val i = Intent(context, UpdateCourse::class.java)
                    i.putExtra("courseName", item?.courseName)
                    i.putExtra("courseDuration", item?.courseDuration)
                    i.putExtra("courseDescription", item?.courseDescription)
                    i.putExtra("courseID", item?.courseID)
                    context.startActivity(i)
                    Toast.makeText(context, courseList[index]?.courseName + " selected..", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Column(modifier = Modifier.padding(8.dp).fillMaxWidth()
                    ) {
                        Spacer(modifier = Modifier.width(5.dp))

                        courseList[index]?.courseName?.let {
                            Text(
                                text = it,
                                modifier = Modifier.padding(4.dp),
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                style = TextStyle(
                                    fontSize = 25.sp, fontWeight = FontWeight.Bold
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(5.dp))

                        courseList[index]?.courseDuration?.let {
                            Text(
                                text = it,
                                modifier = Modifier.padding(4.dp),
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                style = TextStyle(
                                    fontSize = 15.sp
                                )
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))

                        courseList[index]?.courseDescription?.let {
                            Text(
                                text = it,
                                modifier = Modifier.padding(4.dp),
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                style = TextStyle(fontSize = 15.sp)
                            )
                        }
                    }
                }
            }

        }
    }
}
@Preview(showBackground = true)
@Composable
fun CourseDetailsPreview() {


}