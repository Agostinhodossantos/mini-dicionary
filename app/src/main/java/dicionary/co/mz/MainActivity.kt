package dicionary.co.mz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MainActivity : AppCompatActivity() {


    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("word")
    val words = ArrayList<Word>()
    lateinit var recyclerView: RecyclerView
    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this

        var search = findViewById<EditText>(R.id.edSearch);
        search.addTextChangedListener(textWatcher)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this, AddwordActivity::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.rv_words) as RecyclerView

        // adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)



        myRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                words.clear()
                for (postSnapshot in dataSnapshot.children) {
                    val word = postSnapshot.getValue(Word::class.java)
                    if (word != null) {
                        words.add(word)
                    }
                }


                val adapter = Adapter(words,context)
                recyclerView.adapter = adapter
            }


            override fun onCancelled(error: DatabaseError) {

            }
        })






    }


}


object textWatcher : TextWatcher {
    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        if(count > 3) {
            filterText(s.toString())
        }
    }


    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }
}

fun  filterText(s: String) {

}