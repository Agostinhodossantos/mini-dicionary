package dicionary.co.mz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class Adapter (val wordList: ArrayList<Word> ): RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return wordList.size
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.bindItems(wordList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(word: Word) {
            val textViewWord = itemView.findViewById<TextView>(R.id.tvWord)
            val cardView = itemView.findViewById<CardView>(R.id.cardView)

            textViewWord.text = word.changanaWord


        }
    }


}