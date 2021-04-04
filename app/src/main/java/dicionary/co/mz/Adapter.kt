package dicionary.co.mz

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class Adapter (val wordList: ArrayList<Word>, val context: Context): RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return wordList.size
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.bindItems(wordList[position], context)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(word: Word, context: Context) {
            val textViewWord = itemView.findViewById<TextView>(R.id.tvWord)
            val cardView = itemView.findViewById<CardView>(R.id.cardView)

            textViewWord.text = word.changanaWord
            cardView.setOnClickListener {
                val intent = Intent(context, WordActivity::class.java)
                intent.putExtra("word", word)
                context.startActivity(intent)
            }


        }
    }


}