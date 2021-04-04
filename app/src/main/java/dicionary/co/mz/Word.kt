package dicionary.co.mz

import java.io.Serializable

data class Word (
        val changanaWord: String ="",
        val portuguesWord: String ="",
        val changanaExample: String ="",
        val portuguesExample: String ="",
        val wordType: String ="",
        val synonym: String ="",
        val uid: String =""):Serializable