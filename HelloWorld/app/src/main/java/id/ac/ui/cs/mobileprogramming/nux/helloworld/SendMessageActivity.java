package id.ac.ui.cs.mobileprogramming.nux.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SendMessageActivity extends AppCompatActivity {

    private String mNonAvailableFeatureText = "Currently this feature is not available";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
    }

    @SuppressLint("ShowToast")
    public void sendMessage(View view) {
        Toast.makeText(getApplicationContext(), mNonAvailableFeatureText, Toast.LENGTH_SHORT).show();
    }
}