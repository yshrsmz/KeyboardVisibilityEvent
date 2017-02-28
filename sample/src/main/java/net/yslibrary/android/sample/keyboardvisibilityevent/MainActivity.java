package net.yslibrary.android.sample.keyboardvisibilityevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import net.yslibrary.android.keyboardvisibilityevent.Deregister;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

public class MainActivity extends AppCompatActivity {

    TextView mKeyboardStatus;

    EditText mTextField;

    Deregister mDeregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mKeyboardStatus = (TextView) findViewById(R.id.keyboard_status);
        mTextField = (EditText) findViewById(R.id.text_field);

        mDeregister = KeyboardVisibilityEvent.setEventListener(this, new KeyboardVisibilityEventListener() {
            @Override
            public void onVisibilityChanged(boolean isOpen) {
                updateKeyboardStatusText(isOpen);
            }
        });

        updateKeyboardStatusText(KeyboardVisibilityEvent.isKeyboardVisible(this));

        findViewById(R.id.deregister).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                deRegister();
            }
        });
    }

    private void updateKeyboardStatusText(boolean isOpen) {
        mKeyboardStatus.setText(String.format("keyboard is %s", (isOpen ? "visible" : "hidden")));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void deRegister(){
        mDeregister.deRegister();
    }

    @Override protected void onDestroy() {
        super.onDestroy();

        mDeregister.deRegister();
    }
}
