package com.example.kotlinchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register_actvity.*

class RegisterActivity : AppCompatActivity() {

    private  lateinit var mAuth: FirebaseAuth
    private  lateinit var refUsers: DatabaseReference
    private var firebaseUserId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_actvity)

        val toolbar : Toolbar = findViewById(R.id.toolbar_register)
        setSupportActionBar(toolbar)
        supportActionBar!!.title="Register"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener{
            val intent = Intent(this@RegisterActivity, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
            finish()
        }
        mAuth = FirebaseAuth.getInstance()

        register_btn.setOnClickListener {
            registerUser()
        }

    }
    private fun registerUser(){
        val username : String = username_register.text.toString()
        val email : String = email_register.text.toString().trim()
        val password : String = password_register.text.toString()

        if(username == "" || email =="" || password== ""){
            Toast.makeText(this@RegisterActivity, "Please enter all fields", Toast.LENGTH_SHORT).show()
        }
        else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                task ->
                if(task.isSuccessful){
                   firebaseUserId = mAuth.currentUser!!.uid
                    refUsers = FirebaseDatabase.getInstance().reference.child("Users").child(firebaseUserId)
                    val userHashMap =  HashMap<String, Any>()
                    userHashMap["uid"] = firebaseUserId
                    userHashMap["username"] = username
                    userHashMap["profile"] = "https://firebasestorage.googleapis.com/v0/b/kotlinchat-ddaf1.appspot.com/o/download.png?alt=media&token=e8098ce3-8851-4beb-831e-85265c3d9b1f"
                    userHashMap["cover"] = "https://firebasestorage.googleapis.com/v0/b/kotlinchat-ddaf1.appspot.com/o/cover.jpg?alt=media&token=4db6d18d-60d9-49a3-a75f-b52221a7ddea"
                    userHashMap["status"] = "Offline"
                    userHashMap["search"] = username.toLowerCase()
                    userHashMap["facebook"] = "https://m.facebook.com"
                    userHashMap["instagram"] = "https://m.instagram.com"
                    userHashMap["website"] = "https://www.google.com"
                    refUsers.updateChildren(userHashMap).addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                            finish()
                        }
                    }

                }
                else{
                    Toast.makeText(this@RegisterActivity, "Login Failed. Error Message: " + task.exception.toString(), Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}