package com.nutriwise.universe.ui.util

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class CustomPasswordEditText: AppCompatEditText {
    constructor(context: Context): super(context){
        init()
    }
    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet){
        init()
    }
    constructor(context: Context, attributeSet: AttributeSet, deffStyle: Int): super (context, attributeSet, deffStyle){
        init()
    }

    private fun init(){
        addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().length < 8) {
                    error = "Minimal 8 Karakter"
                }else{
                    error = null
                }
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().length < 8) {
                    error = "Minimal 8 Karakter"
                }else{
                    error = null
                }
            }
        })
    }
}