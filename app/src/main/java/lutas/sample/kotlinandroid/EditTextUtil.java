package lutas.sample.kotlinandroid;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 *
 */
public class EditTextUtil {

    // 1. create callback interface
    interface Callback {
        public void onChanged(String text);
    }

    // 2. pass object and callback
    public static void setOnTextChangedListener(EditText editText, final Callback callback) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                callback.onChanged(s.toString());
            }
        });
    }
}
