package lutas.sample.kotlinandroid

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class KotlinFragment: Fragment(), Reportable {

    private val TAG = "KotlinFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_child, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backButton = view.findViewById<Button>(R.id.back_btn)
        backButton.setOnClickListener {
            replaceFragment(MainFragment())
        }

        val textView = view.findViewById<TextView>(R.id.content_tv)
        textView.text = "Kotlin Fragment"

        /**
         * 示範Extension Function
         */
        val editText = view.findViewById<EditText>(R.id.editText)
        editText.setOnTextChangedListener {
            val msg = it ?: "null"
            Log.d(TAG, "text changed: $msg")
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val parentActivity = getActivity()
        // Type check
        if (parentActivity is MainActivity) {
            // Smart cast
            parentActivity.replaceFragment(fragment)
        }
    }

    override fun report() {
        Log.d(TAG, "report!")
    }
}