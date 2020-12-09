package id.ac.ui.cs.mobileprogramming.nux.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int clickCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null)
        {
            if (savedInstanceState.containsKey("count"))
            {
                clickCounter = savedInstanceState.getInt("count");
                TextView text = (TextView) findViewById(R.id.textViewNumber);
                text.setText(String.valueOf(clickCounter));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("count", clickCounter);
    }

    public void incrementNumber(View view) {
        clickCounter++;//increment the count
        TextView text = (TextView) findViewById(R.id.textViewNumber);
        text.setText(String.valueOf(clickCounter));
    }
}