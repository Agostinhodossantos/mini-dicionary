package dicionary.co.mz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class AddwordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addword)

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


        }
    }

    fun checkFiels(word: String?): Boolean {
        if(word.isNullOrBlank()){
            return false
        }else {
            return true
        }
    }
}