package lutas.sample.kotlinandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * 為了比較Kotlin和Java的不同，這邊特別用Java來寫
 */
public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button javaButton = view.findViewById(R.id.java_btn);
        javaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new JavaFragment());
            }
        });

        Button kotlinButton = view.findViewById(R.id.kotlin_btn);
        kotlinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new KotlinFragment());
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentActivity activity = getActivity();
        // 檢查parent是否為MainActivity，然後才cast
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).replaceFragment(fragment);
        }
    }
}
