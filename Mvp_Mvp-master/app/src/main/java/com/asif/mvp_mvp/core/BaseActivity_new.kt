package com.asif.mvp_mvp.core

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

abstract class BaseActivity_new: AppCompatActivity() {

    abstract fun setLayoutId_new(): Int
    abstract fun setToolbar_new(): Toolbar
    abstract val isHomeUpButtonEnable_new: Boolean


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId_new())
      //  setActionBar(setToolbar(), isHomeUpButtonEnable)
        Logger.addLogAdapter(AndroidLogAdapter())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setActionBar(toolbar: Toolbar, isHomeUpButtonEnable: Boolean) {
       // setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(isHomeUpButtonEnable)
        supportActionBar?.setHomeButtonEnabled(isHomeUpButtonEnable)
    }

    fun showToast(text_new: String) {
        Toast.makeText(this, text_new, Toast.LENGTH_SHORT).show()
    }
}