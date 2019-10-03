package net.yslibrary.android.sample.keyboardvisibilityevent

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener
import net.yslibrary.android.keyboardvisibilityevent.Unregistrar

class MainActivity : AppCompatActivity() {

    internal var mKeyboardStatus: TextView

    internal var mTextField: EditText

    internal var mButtonUnregister: Button

    internal var mUnregistrar: Unregistrar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mKeyboardStatus = findViewById(R.id.keyboard_status)
        mTextField = findViewById(R.id.text_field)
        mButtonUnregister = findViewById(R.id.btn_unregister)

        /*
          You can also use {@link KeyboardVisibilityEvent#setEventListener(Activity, KeyboardVisibilityEventListener)}
          if you don't want to unregister the event manually.
         */
        mUnregistrar = KeyboardVisibilityEvent.registerEventListener(this, object : KeyboardVisibilityEventListener {
            override fun onVisibilityChanged(isOpen: Boolean) {
                updateKeyboardStatusText(isOpen)
            }
        })

        updateKeyboardStatusText(KeyboardVisibilityEvent.isKeyboardVisible(this))

        mButtonUnregister.setOnClickListener { unregister() }
    }

    private fun updateKeyboardStatusText(isOpen: Boolean) {
        mKeyboardStatus.text = String.format("keyboard is %s", if (isOpen) "visible" else "hidden")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    internal fun unregister() {
        mUnregistrar.unregister()
    }

    override fun onDestroy() {
        super.onDestroy()

        mUnregistrar.unregister()
    }
}
