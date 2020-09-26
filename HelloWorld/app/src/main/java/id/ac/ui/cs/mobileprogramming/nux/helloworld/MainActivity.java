package id.ac.ui.cs.mobileprogramming.nux.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import id.ac.ui.cs.mobileprogramming.nux.helloworld.Utils.ChangeTextUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessageActivity(View view) {
        Intent intent = new Intent(this, SendMessageActivity.class);
        startActivity(intent);
    }

    public void changeText(View view) {
        ChangeTextUtils chg = new ChangeTextUtils();
        TextView textView = findViewById(R.id.text_hello_world);
        textView.setText(chg.generateText());
    }
}