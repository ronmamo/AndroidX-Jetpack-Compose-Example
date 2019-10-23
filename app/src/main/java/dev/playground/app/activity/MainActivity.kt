package dev.playground.app.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import dev.playground.app.RallyApp
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RallyApp { t -> startActivity(t) }
        }
    }

    fun startActivity(value: Any) {
        startActivity(
            Intent(this, MainActivity::class.java)
                .putExtra("key", value as Serializable)
        )
    }
}

