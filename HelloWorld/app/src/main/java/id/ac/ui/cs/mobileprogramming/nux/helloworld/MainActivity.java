package id.ac.ui.cs.mobileprogramming.nux.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import id.ac.ui.cs.mobileprogramming.nux.helloworld.fragments.CarDetailsFragment;
import id.ac.ui.cs.mobileprogramming.nux.helloworld.fragments.CarListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            CarListFragment fragment = new CarListFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, fragment, CarListFragment.TAG)
                    .commit();
        }
    }

    public void displayCarDetailFragment() {
        CarDetailsFragment fragment = new CarDetailsFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment, CarDetailsFragment.TAG)
                .addToBackStack(CarDetailsFragment.TAG)
                .commit();
    }
}