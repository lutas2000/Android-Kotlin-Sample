package lutas.sample.kotlinandroid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 和Kotlin Fragment比較看看有何不同
 */
public class JavaFragment extends Fragment implements Reportable {

    private static final String TAG = "JavaFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_child, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button backButton = view.findViewById(R.id.back_btn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new MainFragment());
            }
        });

        TextView textView = view.findViewById(R.id.content_tv);
        textView.setText("Java Fragment");

        EditText editText = view.findViewById(R.id.editText);
        EditTextUtil.setOnTextChangedListener(editText, new EditTextUtil.Callback() {
            @Override
            public void onChanged(String text) {
                Log.d(TAG, "text changed: "+ text);
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        Activity parentActivity = getActivity();
        // Type check
        if (parentActivity instanceof MainActivity) {
            // cast
            ((MainActivity) parentActivity).replaceFragment(fragment);
        }
    }

    @Override
    public void report() {
        Log.d(TAG, "report");
    }
}
