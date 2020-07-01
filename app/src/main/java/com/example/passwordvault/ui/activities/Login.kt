package com.example.passwordvault.ui.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.HandlerThread
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.passwordvault.R
import com.example.passwordvault.databinding.LoginBinding

class Login : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding : LoginBinding
    private var password : String = ""
    private  var count : Int = 0
    private var masterPassword : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        masterPassword = intent.getStringExtra("PIN")
        Log.e("Register", masterPassword)
        setUpClickListeners()

    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.number1 -> {
                view as TextView
                password+= view.text
                count++
                if(count== 4){
                    binding.passwordFirst.setImageResource(R.drawable.password_entered)
                    if(password == masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                    }
                    else{
                        Toast.makeText(this,"WrongPassword!", Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        uncheckPasswordViews()
                        binding.demoText.text = "Re-Enter PIN"
                    }
                }
                else{
                    when(count){
                        1 -> binding.passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> binding.passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> binding.passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> binding.passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }
            R.id.number2 -> {
                view as TextView
                password+= view.text
                count++
                if(count== 4){
                    binding.passwordFirst.setImageResource(R.drawable.password_entered)
                    if(password == masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                    }
                    else{
                        Toast.makeText(this,"WrongPassword!", Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        uncheckPasswordViews()
                        binding.demoText.text = "Re-Enter PIN"
                    }
                }
                else{
                    when(count){
                        1 -> binding.passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> binding.passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> binding.passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> binding.passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }
            R.id.number3 -> {
                view as TextView
                password+= view.text
                count++
                if(count== 4){
                    binding.passwordFirst.setImageResource(R.drawable.password_entered)
                    if(password == masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                    }
                    else{
                        Toast.makeText(this,"WrongPassword!", Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        uncheckPasswordViews()
                        binding.demoText.text = "Re-Enter PIN"
                    }
                }
                else{
                    when(count){
                        1 -> binding.passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> binding.passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> binding.passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> binding.passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }
            R.id.number4 -> {
                view as TextView
                password+= view.text
                count++
                if(count== 4){
                    binding.passwordFirst.setImageResource(R.drawable.password_entered)
                    if(password == masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                    }
                    else{
                        Toast.makeText(this,"WrongPassword!", Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        uncheckPasswordViews()
                        binding.demoText.text = "Re-Enter PIN"
                    }
                }
                else{
                    when(count){
                        1 -> binding.passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> binding.passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> binding.passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> binding.passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }
            R.id.number5 -> {
                view as TextView
                password+= view.text
                count++
                if(count== 4){
                    binding.passwordFirst.setImageResource(R.drawable.password_entered)
                    if(password == masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                    }
                    else{
                        Toast.makeText(this,"WrongPassword!", Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        uncheckPasswordViews()
                        binding.demoText.text = "Re-Enter PIN"
                    }
                }
                else{
                    when(count){
                        1 -> binding.passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> binding.passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> binding.passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> binding.passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }
            R.id.number6 -> {
                view as TextView
                password+= view.text
                count++
                if(count== 4){
                    binding.passwordFirst.setImageResource(R.drawable.password_entered)
                    if(password == masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                    }
                    else{
                        Toast.makeText(this,"WrongPassword!", Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        uncheckPasswordViews()
                        binding.demoText.text = "Re-Enter PIN"
                    }
                }
                else{
                    when(count){
                        1 -> binding.passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> binding.passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> binding.passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> binding.passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }
            R.id.number7 -> {
                view as TextView
                password+= view.text
                count++
                if(count== 4){
                    binding.passwordFirst.setImageResource(R.drawable.password_entered)
                    if(password == masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                    }
                    else{
                        Toast.makeText(this,"WrongPassword!", Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        uncheckPasswordViews()
                        binding.demoText.text = "Re-Enter PIN"
                    }
                }
                else{
                    when(count){
                        1 -> binding.passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> binding.passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> binding.passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> binding.passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }
            R.id.number8 -> {
                view as TextView
                password+= view.text
                count++
                if(count== 4){
                    binding.passwordFirst.setImageResource(R.drawable.password_entered)
                    if(password == masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                    }
                    else{
                        Toast.makeText(this,"WrongPassword!", Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        uncheckPasswordViews()
                        binding.demoText.text = "Re-Enter PIN"
                    }
                }
                else{
                    when(count){
                        1 -> binding.passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> binding.passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> binding.passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> binding.passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }
            R.id.number9 -> {
                view as TextView
                password+= view.text
                count++
                if(count== 4){
                    binding.passwordFirst.setImageResource(R.drawable.password_entered)
                    if(password == masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                    }
                    else{
                        Toast.makeText(this,"WrongPassword!", Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        uncheckPasswordViews()
                        binding.demoText.text = "Re-Enter PIN"
                    }
                }
                else{
                    when(count){
                        1 -> binding.passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> binding.passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> binding.passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> binding.passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }
            R.id.number0 -> {
                view as TextView
                password+= view.text
                count++
                if(count== 4){
                    binding.passwordFirst.setImageResource(R.drawable.password_entered)
                    if(password == masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                    }
                    else{
                        Toast.makeText(this,"WrongPassword!", Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        uncheckPasswordViews()
                        binding.demoText.text = "Re-Enter PIN"
                    }
                }
                else{
                    when(count){
                        1 -> binding.passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> binding.passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> binding.passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> binding.passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }
            R.id.next -> {
                if(password == masterPassword){
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Wrong Password", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.numberDelete -> {
                password = password.substring(0,password.length-1)
                when(count){
                    1 -> binding.passwordFirst.setImageResource(R.drawable.password_not_entered)
                    2 -> binding.passwordSecond.setImageResource(R.drawable.password_not_entered)
                    3 -> binding.passwordThird.setImageResource(R.drawable.password_not_entered)
                    4 -> binding.passwordFourth.setImageResource(R.drawable.password_not_entered)
                }
                count--
            }

        }
    }

    private fun uncheckPasswordViews() {
        binding.passwordFirst.setImageResource(R.drawable.password_not_entered)
        binding.passwordSecond.setImageResource(R.drawable.password_not_entered)
        binding.passwordThird.setImageResource(R.drawable.password_not_entered)
        binding.passwordFourth.setImageResource(R.drawable.password_not_entered)
    }

    private fun setUpClickListeners() {
        binding.number0.setOnClickListener(this)
        binding.number1.setOnClickListener(this)
        binding.number2.setOnClickListener(this)
        binding.number3.setOnClickListener(this)
        binding.number4.setOnClickListener(this)
        binding.number5.setOnClickListener(this)
        binding.number6.setOnClickListener(this)
        binding.number7.setOnClickListener(this)
        binding.number8.setOnClickListener(this)
        binding.number9.setOnClickListener(this)
        binding.next.setOnClickListener(this)
        binding.numberDelete.setOnClickListener(this)
    }
}
