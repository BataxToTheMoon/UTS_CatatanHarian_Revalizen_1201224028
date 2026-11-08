package com.example.uts_catatanharian.ui.auth

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uts_catatanharian.R
import com.example.uts_catatanharian.data.database.AppDatabase_137
import com.example.uts_catatanharian.data.entity.UserEntity_028
import com.example.uts_catatanharian.data.repository.UserRepository_028
import com.example.uts_catatanharian.utils.HashUtils_106
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterActivity_028 : AppCompatActivity() {

    private lateinit var userRepository: UserRepository_028

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val userDao = AppDatabase_137.getDatabase_137(this).userDao_028()
        userRepository = UserRepository_028(userDao)

        val etUsername = findViewById<TextInputEditText>(R.id.et_reg_username_028)
        val etPassword = findViewById<TextInputEditText>(R.id.et_reg_password_028)
        val etConfirmPassword = findViewById<TextInputEditText>(R.id.et_reg_confirm_password_028)
        val btnRegister = findViewById<MaterialButton>(R.id.btn_register_028)
        val tvToLogin = findViewById<android.widget.TextView>(R.id.tv_to_login_028)

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Password dan konfirmasi password tidak cocok", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            CoroutineScope(Dispatchers.IO).launch {
                val existingUser = userRepository.getUserByUsername_028(username)
                if (existingUser != null) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@RegisterActivity_028, "Username sudah digunakan", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    val salt = HashUtils_106.generateSalt()
                    val passwordHash = HashUtils_106.hashPassword(password, salt)
                    val newUser = UserEntity_028(username = username, passwordHash = passwordHash, salt = salt)
                    userRepository.registerUser_028(newUser)

                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@RegisterActivity_028, "Registrasi Berhasil. Silakan Login", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            }
        }

        tvToLogin.setOnClickListener {
            finish()
        }
    }
}
