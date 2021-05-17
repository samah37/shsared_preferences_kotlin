package com.tdm.exo1tp7

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    val MIN_PASSWD_LENGTH: Int=3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var button = findViewById<Button>(R.id.login_button)
        var Email = findViewById<EditText>(R.id.email)
        var Password = findViewById<EditText>(R.id.password)

        button.setOnClickListener{
            Validation(Email.text.toString(), Password.text.toString())

        }
    }

    fun Validation(Email: String, Mdp: String){

        if (Email== ""){
            Toast.makeText(this, "Entrer l'email", Toast.LENGTH_SHORT).show()
        }
        else {
            if(Mdp==""){
                Toast.makeText(this, "Entrer le mot de passe", Toast.LENGTH_SHORT).show()
            }
            else{
                if(Mdp.length< MIN_PASSWD_LENGTH){
                    Toast.makeText(this, "Mot de passe incorrect", Toast.LENGTH_SHORT).show()
                }
                else{

                        if ((Email== "test@gmail.com") && (Mdp == "test")){
                            val settings = getSharedPreferences(
                                "mysettings",
                                Context.MODE_PRIVATE
                            )
                            val editor = settings.edit()
                            editor.putString("email", Email)
                            editor.commit()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }
                        else {
                            Toast.makeText(this, "Mot de passe ou Email incorrect", Toast.LENGTH_SHORT).show()
                        }


                }

            }

        }

    }
}