package id.ac.ui.cs.mobileprogramming.nux.helloworld.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import id.ac.ui.cs.mobileprogramming.nux.helloworld.R;

public class WelcomeActivity extends AppCompatActivity {

    // Load library of native-lib.cpp
    static {
        System.loadLibrary("native-lib");
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String setUsername(String username);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

    }

    public void startMainActivity(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        EditText editTextUsername = (EditText) findViewById(R.id.editTextUsername);

        // Implement from native lib
        String username = setUsername(editTextUsername.getText().toString());
        intent.putExtra("username", username);
        Log.d("Name: ", username);

        startActivity(intent);
    }
}