package com.andrtw.androidbaseproject.ui

import android.os.Bundle
import androidx.fragment.app.commit
import com.andrtw.androidbaseproject.R
import com.andrtw.androidbaseproject.ui.base.AbstractBaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AbstractBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(
                    R.id.fragmentContainer,
                    MainFragment(),
                    MainFragment.TAG
                )
            }
        }
    }
}
