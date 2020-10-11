package id.ac.ui.cs.mobileprogramming.nux.helloworld.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import id.ac.ui.cs.mobileprogramming.nux.helloworld.BuildConfig;
import id.ac.ui.cs.mobileprogramming.nux.helloworld.MainActivity;
import id.ac.ui.cs.mobileprogramming.nux.helloworld.databinding.FragmentCarListBinding;
import id.ac.ui.cs.mobileprogramming.nux.helloworld.viewmodel.CarViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CarListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarListFragment extends Fragment {

    public static final String TAG = BuildConfig.APPLICATION_ID+"CarListFragment";

    private FragmentCarListBinding mBinding;

    private CarViewModel mViewModel;

    public CarListFragment(){
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        this.mBinding = FragmentCarListBinding.inflate(inflater, container, false);
        return this.mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mViewModel = new ViewModelProvider(requireActivity()).get(CarViewModel.class);

        this.mBinding.carList.setAdapter(
                new ArrayAdapter<>(
                        this.getActivity(),
                        android.R.layout.simple_list_item_1,
                        this.mViewModel.getCarList()
                )
        );

        this.mBinding.carList.setOnItemClickListener((parent, view, position, id) -> {
            TextView textView = (TextView) view;
            this.mViewModel.selectCar(textView.getText().toString());
            ((MainActivity) requireActivity()).displayCarDetailFragment();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.mBinding = null;
    }
}