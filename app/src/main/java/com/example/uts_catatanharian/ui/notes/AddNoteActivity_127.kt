package com.example.uts_catatanharian.ui.notes

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.uts_catatanharian.R
import com.example.uts_catatanharian.data.database.AppDatabase_137
import com.example.uts_catatanharian.data.entity.NoteEntity_088
import com.example.uts_catatanharian.data.repository.NoteRepository_137
import com.example.uts_catatanharian.utils.SessionManager_106
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddNoteActivity_127 : AppCompatActivity() {

    private lateinit var noteRepository: NoteRepository_137
    private lateinit var sessionManager: SessionManager_106
    private var currentUserId: Long = -1L

    private lateinit var etTitle: TextInputEditText
    private lateinit var etDate: TextInputEditText
    private lateinit var etContent: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_add_127)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Tambah Catatan"
        toolbar.setNavigationOnClickListener { finish() }

        sessionManager = SessionManager_106(this)
        currentUserId = sessionManager.getUserId()

        val noteDao = AppDatabase_137.getDatabase_137(this).noteDao_137()
        noteRepository = NoteRepository_137(noteDao)

        etTitle = findViewById(R.id.et_title_127)
        etDate = findViewById(R.id.et_date_127)
        etContent = findViewById(R.id.et_content_127)

        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        etDate.setText(dateFormat.format(calendar.time))

        etDate.setOnClickListener {
            DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    calendar.set(year, month, dayOfMonth)
                    etDate.setText(dateFormat.format(calendar.time))
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        val btnSave = findViewById<MaterialButton>(R.id.btn_save_127)
        btnSave.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val date = etDate.text.toString().trim()
            val content = etContent.text.toString().trim()

            if (title.isEmpty() || content.isEmpty()) {
                Toast.makeText(this, "Judul dan isi catatan tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newNote = NoteEntity_088(
                user_id = currentUserId,
                judul = title,
                isi = content,
                tanggal = date
            )

            CoroutineScope(Dispatchers.IO).launch {
                noteRepository.insertNote_137(newNote)
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@AddNoteActivity_127, "Catatan berhasil ditambahkan", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}
