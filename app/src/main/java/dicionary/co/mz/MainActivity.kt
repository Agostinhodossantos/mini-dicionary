package dicionary.co.mz

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.rv_words) as RecyclerView

        // adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val words = ArrayList<Word>()

        for(i in 1..10) {
            words.add(Word("Changana", "Portugues", "Changana Ex", "Portugues ex", "type", "uid"))
        }
        val adapter = Adapter(words)
        recyclerView.adapter = adapter
    }


}