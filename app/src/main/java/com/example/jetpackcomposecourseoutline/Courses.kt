package com.example.jetpackcomposecourseoutline

import com.google.firebase.firestore.Exclude
import java.time.Duration

data class Courses(
    @Exclude var courseID: String? = "",
    var courseName: String? = "",
    var courseDuration: String? = "",
    var courseDescription: String? = ""
)