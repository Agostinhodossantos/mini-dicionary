package dicionary.co.mz

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var search = findViewById<EditText>(R.id.edSearch);

        search.addTextChangedListener(textWatcher)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this, AddwordActivity::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById(R.id.rv_words) as RecyclerView

        // adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val words = ArrayList<Word>()

        for(i in 1..10) {
            words.add(Word("Changana", "Portugues", "Changana Ex", "Portugues ex", "type", "dd","uid"))
        }
        val adapter = Adapter(words,this)
        recyclerView.adapter = adapter

    }


}

object textWatcher : TextWatcher {
    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
      Log.d("TAG", s.toString())
    }


    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }
}

