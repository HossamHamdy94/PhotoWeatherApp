package com.example.photoweatherapp.util

import android.app.Activity
import android.os.Build
import android.os.Environment
import androidx.annotation.RequiresApi
import java.io.File



@RequiresApi(Build.VERSION_CODES.FROYO)
fun Activity.getPhotoFile(name: String): File {
    val path = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    val photoName = "Image-$name.jpg"
    return File(path, photoName)
}