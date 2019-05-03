package lutas.sample.kotlinandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * 用來與KotlinActivity比較用的Java class
 */
public class JavaActivity extends AppCompatActivity {

    private Fragment currentFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(new MainFragment());
    }

    public void replaceFragment(Fragment fragment) {
        currentFragment = fragment;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, fragment);
        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (currentFragment instanceof Reportable) {
            ((Reportable) currentFragment).report();
        }
    }
}


