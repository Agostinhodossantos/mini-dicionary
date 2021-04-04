package dicionary.co.mz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class WordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var word =  intent.getSerializableExtra("word") as Word
        setContentView(R.layout.activity_word)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = word.changanaWord
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        val tvWord = findViewById(R.id.tvWord) as TextView
        val tvMeaningPt = findViewById(R.id.tvMeaning) as TextView
        val tvSynonym = findViewById(R.id.tvSynonym) as TextView
        val tvWordClass = findViewById(R.id.tvClass) as TextView
        val tvExampleCng = findViewById(R.id.tvExampleCng) as TextView
        val tvExamplePt = findViewById(R.id.tvExamplePt) as TextView

        tvWord.text = word.changanaWord
        tvMeaningPt.text = word.portuguesWord
        tvSynonym.text = word.synonym
        tvWordClass.text = word.wordType
        tvExampleCng.text = word.changanaExample
        tvExamplePt.text = word.portuguesExample


    }
}