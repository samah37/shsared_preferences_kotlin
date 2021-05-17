package com.tdm.exo1tp7

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var deconnexion = findViewById<TextView>(R.id.deconnexion)
        val settings = getSharedPreferences(
            "mysettings",
            Context.MODE_PRIVATE
        )
        val mail = settings.getString("email", "")
        if (mail==""){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        else {
            Toast.makeText(this, mail, Toast.LENGTH_SHORT).show()
            deconnexion.setOnClickListener{
                val editor = settings.edit()
                editor.putString("email", "")
                editor.commit()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }

    }
}