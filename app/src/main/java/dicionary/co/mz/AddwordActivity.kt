package dicionary.co.mz

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class AddwordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addword)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = "Adicionar palavras"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvWord = findViewById(R.id.tvWordCng) as EditText
        val tvMeaningPt = findViewById(R.id.tvMeaning) as EditText
        val tvSynonym = findViewById(R.id.tvSynonym) as EditText
        val tvWordClass = findViewById(R.id.tvClass) as EditText;
        val tvExampleCng = findViewById(R.id.tvExampleCng) as EditText;
        val tvExamplePt = findViewById(R.id.tvExamplePt) as EditText;
        val btnAdd = findViewById(R.id.btnAdd) as Button;

        btnAdd.setOnClickListener {
            var wordCng: String = tvWord.text.toString()
            var meaningPt: String = tvMeaningPt.text.toString()
            var synonymCng: String = tvSynonym.text.toString()
            var wordClass: String = tvWordClass.text.toString();
            var exampleCng: String = tvExampleCng.text.toString();
            var examplePt: String = tvExamplePt.text.toString();

            if(checkFiels(wordCng)) {
                tvWord.requestFocus();
                tvWord.setHintTextColor(Color.RED)
            } else if(checkFiels(meaningPt)) {
                tvMeaningPt.requestFocus()
                tvMeaningPt.setHintTextColor(Color.RED)
            } else if(checkFiels(exampleCng)) {
                tvExampleCng.requestFocus();
                tvExampleCng.setHintTextColor(Color.RED)
            } else if(checkFiels(examplePt)) {
                tvExamplePt.requestFocus()
                tvExamplePt.setHintTextColor(Color.RED)
            } else {
                // all things is good
                var uid = UUID.randomUUID().toString();
                var word = Word(wordCng, meaningPt, exampleCng , examplePt ,wordClass,synonymCng, uid);
                Toast.makeText(this, word.toString() , Toast.LENGTH_LONG).show()
            }
        }
    }

    fun checkFiels(word: String?): Boolean {
        if(word.isNullOrBlank()){
            return true
        }else {
            return false
        }
    }
}