package id.ac.ui.cs.mobileprogramming.nux.helloworld;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {


     /**
     * @POST(".") means root path of endpoint
     * @param body of WifiMode
     */
    @POST(".")
    Call<ResponseBody> addWifi(@Body WifiModel data);
}