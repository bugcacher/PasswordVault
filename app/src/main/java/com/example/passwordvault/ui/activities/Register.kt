package com.example.passwordvault.ui.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Display
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.passwordvault.R
import com.example.passwordvault.databinding.CreateMasterPasswordBinding
import kotlinx.android.synthetic.main.create_master_password.*
import java.util.jar.Manifest

class Register : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding : CreateMasterPasswordBinding
    private var password : String = ""
    private var passwordTemp: String = ""
    private lateinit var masterPassword : String
    private  var count : Int = 0
    private var onConfirmation : Boolean = false
    private lateinit var preference : SharedPreferences
    private val PERMISSIONCODE : Int = 1

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CreateMasterPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkPermissions()
        setUpClickListeners()
        preference = getSharedPreferences("PasswordPreferences",Context.MODE_PRIVATE)
        binding.passwordGridLayout.setOnClickListener(this)

        if(preference.contains("PIN"))
            startActivity(Intent(this,Login::class.java).putExtra("PIN",preference.getString("PIN","No Pin")))
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

    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkPermissions() {
      if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
          || ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
          requestPermissions(arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                     android.Manifest.permission.READ_EXTERNAL_STORAGE),PERMISSIONCODE)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.number1 -> {
                Log.e("Register", "onclick")
                view as TextView
                password+= view.text
                count++
                if(count== 4 && !onConfirmation){
                    binding.demoText.text = "Confirm Password"
                    onConfirmation = true
                    uncheckPasswordViews()
                    count = 0
                    passwordTemp = password
                    password = ""
                }
                else if(count == 4 && onConfirmation){
                    if(password == passwordTemp){
                        var editor = preference.edit()
                        editor.putString("PIN",password)
                        editor.commit()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"Password not matched!",Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        onConfirmation = true
                        uncheckPasswordViews()
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
                if(count== 4 && !onConfirmation){
                    binding.demoText.text = "Confirm Password"
                    onConfirmation = true
                    uncheckPasswordViews()
                    count = 0
                    passwordTemp = password
                    password = ""
                }
                else if(count == 4 && onConfirmation){
                    if(password == passwordTemp){
                        var editor = preference.edit()
                        editor.putString("PIN",password)
                        editor.commit()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"Password not matched!",Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        onConfirmation = true
                        uncheckPasswordViews()
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
                if(count== 4 && !onConfirmation){
                    binding.demoText.text = "Confirm Password"
                    onConfirmation = true
                    uncheckPasswordViews()
                    count = 0
                    passwordTemp = password
                    password = ""
                }
                else if(count == 4 && onConfirmation){
                    if(password == passwordTemp){
                        var editor = preference.edit()
                        editor.putString("PIN",password)
                        editor.commit()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"Password not matched!",Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        onConfirmation = true
                        uncheckPasswordViews()
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
                if(count== 4 && !onConfirmation){
                    binding.demoText.text = "Confirm Password"
                    onConfirmation = true
                    uncheckPasswordViews()
                    count = 0
                    passwordTemp = password
                    password = ""
                }
                else if(count == 4 && onConfirmation){
                    if(password == passwordTemp){
                        var editor = preference.edit()
                        editor.putString("PIN",password)
                        editor.commit()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"Password not matched!",Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        onConfirmation = true
                        uncheckPasswordViews()
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
                if(count== 4 && !onConfirmation){
                    binding.demoText.text = "Confirm Password"
                    onConfirmation = true
                    uncheckPasswordViews()
                    count = 0
                    passwordTemp = password
                    password = ""
                }
                else if(count == 4 && onConfirmation){
                    if(password == passwordTemp){
                        var editor = preference.edit()
                        editor.putString("PIN",password)
                        editor.commit()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"Password not matched!",Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        onConfirmation = true
                        uncheckPasswordViews()
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
                if(count== 4 && !onConfirmation){
                    binding.demoText.text = "Confirm Password"
                    onConfirmation = true
                    uncheckPasswordViews()
                    count = 0
                    passwordTemp = password
                    password = ""
                }
                else if(count == 4 && onConfirmation){
                    if(password == passwordTemp){
                        var editor = preference.edit()
                        editor.putString("PIN",password)
                        editor.commit()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"Password not matched!",Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        onConfirmation = true
                        uncheckPasswordViews()
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
                if(count== 4 && !onConfirmation){
                    binding.demoText.text = "Confirm Password"
                    onConfirmation = true
                    uncheckPasswordViews()
                    count = 0
                    passwordTemp = password
                    password = ""
                }
                else if(count == 4 && onConfirmation){
                    if(password == passwordTemp){
                        var editor = preference.edit()
                        editor.putString("PIN",password)
                        editor.commit()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"Password not matched!",Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        onConfirmation = true
                        uncheckPasswordViews()
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
                if(count== 4 && !onConfirmation){
                    binding.demoText.text = "Confirm Password"
                    onConfirmation = true
                    uncheckPasswordViews()
                    count = 0
                    passwordTemp = password
                    password = ""
                }
                else if(count == 4 && onConfirmation){
                    if(password == passwordTemp){
                        var editor = preference.edit()
                        editor.putString("PIN",password)
                        editor.commit()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"Password not matched!",Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        onConfirmation = true
                        uncheckPasswordViews()
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
                if(count== 4 && !onConfirmation){
                    binding.demoText.text = "Confirm Password"
                    onConfirmation = true
                    uncheckPasswordViews()
                    count = 0
                    passwordTemp = password
                    password = ""
                }
                else if(count == 4 && onConfirmation){
                    if(password == passwordTemp){
                        var editor = preference.edit()
                        editor.putString("PIN",password)
                        editor.commit()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"Password not matched!",Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        onConfirmation = true
                        uncheckPasswordViews()
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
                if(count== 4 && !onConfirmation){
                    binding.demoText.text = "Confirm Password"
                    onConfirmation = true
                    uncheckPasswordViews()
                    count = 0
                    passwordTemp = password
                    password = ""
                }
                else if(count == 4 && onConfirmation){
                    if(password == passwordTemp){
                        var editor = preference.edit()
                        editor.putString("PIN",password)
                        editor.commit()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"Password not matched!",Toast.LENGTH_SHORT).show()
                        password = ""
                        count = 0
                        onConfirmation = true
                        uncheckPasswordViews()
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
                if(password == passwordTemp){
                    var editor = preference.edit()
                    editor.putString("PIN",password)
                    editor.commit()
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Wrong Password",Toast.LENGTH_SHORT).show()
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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSIONCODE && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"Permission Granted!",Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this,"Permission not Granted!",Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
