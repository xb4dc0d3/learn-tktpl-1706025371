package id.ac.ui.cs.mobileprogramming.nux.helloworld.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.ui.cs.mobileprogramming.nux.helloworld.BuildConfig;
import id.ac.ui.cs.mobileprogramming.nux.helloworld.R;
import id.ac.ui.cs.mobileprogramming.nux.helloworld.databinding.FragmentCarDetailsBinding;
import id.ac.ui.cs.mobileprogramming.nux.helloworld.models.Car;
import id.ac.ui.cs.mobileprogramming.nux.helloworld.viewmodel.CarViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CarDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarDetailsFragment extends Fragment {

    private CarViewModel mViewModel;

    private FragmentCarDetailsBinding mBinding;

    public static final String TAG = BuildConfig.APPLICATION_ID+"CarDetailsFragment";

    public CarDetailsFragment() {
        // Required empty public constructor
    }

    private void setCarDetails(Car car) {
        this.mBinding.name.setText(car.getName());
        String typeText = "Type: " + car.getType();
        String ccText = "CC: " + car.getCC();
        String merkText = "Merk: " + car.getMerk();
        String descriptionTxt = "Description: "+ car.getDescription();
        this.mBinding.type.setText(typeText);
        this.mBinding.cc.setText(ccText);
        this.mBinding.merk.setText(merkText);
        this.mBinding.description.setText(descriptionTxt);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mViewModel = new ViewModelProvider(requireActivity()).get(CarViewModel.class);
        this.mViewModel.getSelectedCar().observe(this, item -> {
            Car car = mViewModel.getCarDetails(item);
            this.setCarDetails(car);
        });
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        this.mBinding = FragmentCarDetailsBinding.inflate(inflater, container, false);
        return this.mBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.mBinding = null;
    }

}