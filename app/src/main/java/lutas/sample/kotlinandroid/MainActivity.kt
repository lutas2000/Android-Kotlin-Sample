package lutas.sample.kotlinandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

class MainActivity : AppCompatActivity() {

    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(MainFragment())
    }

    fun replaceFragment(fragment: Fragment) {
        currentFragment = fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, fragment)
        transaction.commit()
    }

    override fun onDestroy() {
        super.onDestroy()

        /**
         * Safe Cast
         */
        // (currentFragment as? Reportable)?.report()

        /**
         * Type Check and Smart Cast
         */
        currentFragment?.let {
            if (it is Reportable) it.report()
        }
    }
}
