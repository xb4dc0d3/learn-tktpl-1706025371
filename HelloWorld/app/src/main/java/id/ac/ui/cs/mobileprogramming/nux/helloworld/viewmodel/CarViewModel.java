package id.ac.ui.cs.mobileprogramming.nux.helloworld.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.nux.helloworld.models.Car;
import id.ac.ui.cs.mobileprogramming.nux.helloworld.repositories.CarRepository;

public class CarViewModel extends ViewModel {

    private final MutableLiveData<String> selectedCar = new MutableLiveData<>();
    private CarRepository mRepository = CarRepository.getInstance();

    public void selectCar(String name) {
        this.selectedCar.setValue(name);
    }

    public LiveData<String> getSelectedCar() {
        return this.selectedCar;
    }

    public List<String> getCarList() {
        return this.mRepository.getCars();
    }

    public Car getCarDetails(String name) {
        return this.mRepository.getCarDetails(name);
    }
}
