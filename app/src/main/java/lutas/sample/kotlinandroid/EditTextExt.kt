package lutas.sample.kotlinandroid

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * 示範Extension Function和Callback
 */
fun EditText.setOnTextChangedListener(onChanged: (String?) -> Unit) {
    addTextChangedListener(object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            onChanged(s?.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    })
}