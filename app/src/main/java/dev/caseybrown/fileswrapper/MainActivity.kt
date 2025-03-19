package dev.caseybrown.fileswrapper

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            val intent = Intent().apply {
                component = ComponentName(
                    "com.google.android.documentsui",
                    "com.android.documentsui.files.FilesActivity"
                )
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(
                this,
                "com.google.android.documentsui/com.android.documentsui.files.FilesActivity not found.",
                Toast.LENGTH_LONG
            ).show()
        } finally {
            finishAndRemoveTask()
        }
    }
}