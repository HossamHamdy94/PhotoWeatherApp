package com.example.photoweatherapp.util

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.FileProvider
import com.example.photoweatherapp.R
import java.io.File




@RequiresApi(Build.VERSION_CODES.DONUT)
fun Activity.shareImage(imagePath: String, packageName: String? = null) {

    val imageFile=File(imagePath)

    val imageUri = FileProvider.getUriForFile(
        this,
        "com.example.photoweatherapp.fileprovider",
        imageFile)

    val shareIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_STREAM, imageUri)
        packageName?.let {
            setPackage(it)
        }
        type = "image/jpeg"
    }
    startActivity(Intent.createChooser(shareIntent, getString(R.string.share_to_label)))
}



