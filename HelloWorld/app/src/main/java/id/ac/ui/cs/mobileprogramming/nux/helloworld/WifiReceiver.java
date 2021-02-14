package id.ac.ui.cs.mobileprogramming.nux.helloworld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WifiReceiver extends BroadcastReceiver {
    private WifiManager wifiManager;
    private ListView wifiDeviceList;
    private ApiInterface apiService;


    public WifiReceiver(WifiManager wifiManager, ListView wifiDeviceList) {
        this.wifiManager = wifiManager;
        this.wifiDeviceList = wifiDeviceList;
    }

    public void onReceive(final Context context, Intent intent) {
        String action = intent.getAction();
        apiService = ApiClient.getClient().create(ApiInterface.class);

        if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.equals(action)) {
            List<ScanResult> wifiList = wifiManager.getScanResults();
            ArrayList<String> deviceList = new ArrayList<>();
            for (ScanResult scanResult : wifiList) {

                Call<ResponseBody> call = apiService.addWifi(
                        new WifiModel(
                                scanResult.SSID,
                                scanResult.capabilities,
                                scanResult.frequency,
                                scanResult.level)
                );

                call.enqueue(new Callback<ResponseBody>() {
                     @Override
                     public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                         if (response.isSuccessful()) {
                             Log.d("HTTP POST", "Post Success");
                             Toast.makeText(context.getApplicationContext(), "Post all Wifi Success!", Toast.LENGTH_SHORT).show();
                         }
                     }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(context.getApplicationContext(), "Something's wrong" , Toast.LENGTH_SHORT).show();
                    }
                });
                deviceList.add(scanResult.SSID +
                        "\ncap= " + scanResult.capabilities +
                        "\nfreq= " + scanResult.frequency +
                        "\nlevel= " + scanResult.level
                );
            }

            ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, deviceList.toArray());
            wifiDeviceList.setAdapter(arrayAdapter);
        }
    }
}