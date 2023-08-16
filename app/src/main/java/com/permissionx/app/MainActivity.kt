package com.permissionx.app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.permissionx.app.ui.theme.PermissionXTheme
import com.permissionx.calvindev.PermissionX
import kotlinx.android.synthetic.main.activity_main.makeCallBtn

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makeCallBtn.setOnClickListener{
            PermissionX.request(this,Manifest.permission.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION){ allGranted, deniedList ->
                if (allGranted) {
                    call()
                } else {
                    Toast.makeText(this,"You denied $deniedList", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    private fun call() {
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

