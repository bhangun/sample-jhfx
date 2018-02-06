package com.example.demo.views

import tornadofx.Controller
import tornadofx.observable
import java.io.File
import java.nio.charset.Charset
import no.tornado.fxsample.workspace.DocumentViewModel
import no.tornado.fxsample.workspace.TextEditorFragment

/**
 * Created by miguelius on 04/09/2017.
 */
class EditorController : Controller() {

    /**
     * random quotes from resource quotes.txt
     */
    private val quotes = File(javaClass.getResource("quotes.txt").toURI()).readLines(Charset.forName("UTF-8"))

    /**
     * the list of open text editors
     */
    val editorModelList = mutableListOf<TextEditorFragment>().observable()

    fun newEditor(): TextEditorFragment {
        val newFile = DocumentViewModel()
        newFile.title.value = "New file ${editorModelList.size}"
        newFile.commit()

        val editor = TextEditorFragment(newFile)
        editorModelList.add(editor)

        return editor
    }

    /**
     * provides a random quote
     */
    fun quote(): String = quotes[(Math.random() * quotes.size).toInt()]

}
