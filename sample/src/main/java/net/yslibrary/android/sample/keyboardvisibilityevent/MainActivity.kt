package net.yslibrary.android.sample.keyboardvisibilityevent

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener
import net.yslibrary.android.keyboardvisibilityevent.Unregistrar

class MainActivity : AppCompatActivity() {

    private lateinit var keyboardStatus: TextView

    private lateinit var textField: EditText

    private lateinit var buttonUnregister: Button

    private lateinit var unregistrar: Unregistrar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        keyboardStatus = findViewById(R.id.keyboard_status)
        textField = findViewById(R.id.text_field)
        buttonUnregister = findViewById(R.id.btn_unregister)

        /*
          You can also use {@link KeyboardVisibilityEvent#setEventListener(Activity, KeyboardVisibilityEventListener)}
          if you don't want to unregister the event manually.
         */
        unregistrar = KeyboardVisibilityEvent.registerEventListener(
            this,
            object : KeyboardVisibilityEventListener {
                override fun onVisibilityChanged(isOpen: Boolean) {
                    updateKeyboardStatusText(isOpen)
                }
            })

        updateKeyboardStatusText(KeyboardVisibilityEvent.isKeyboardVisible(this))

        buttonUnregister.setOnClickListener { unregister() }
    }

    @SuppressLint("SetTextI18n")
    private fun updateKeyboardStatusText(isOpen: Boolean) {
        keyboardStatus.text = "keyboard is ${if (isOpen) "visible" else "hidden"}"
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

    private fun unregister() {
        unregistrar.unregister()
    }

    override fun onDestroy() {
        super.onDestroy()

        unregistrar.unregister()
    }
}
