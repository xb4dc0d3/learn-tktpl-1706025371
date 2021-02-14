package id.ac.ui.cs.mobileprogramming.nux.helloworld;

import com.google.gson.annotations.SerializedName;

public class WifiModel {

    @SerializedName("ssid")
    String ssid;

    @SerializedName("capabilities")
    String capabilities;

    @SerializedName("frequency")
    int frequency;

    @SerializedName("level")
    int level;

    public WifiModel(String ssid, String capabilities, int frequency, int level) {
        this.ssid = ssid;
        this.capabilities = capabilities;
        this.frequency = frequency;
        this.level = level;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }


    public String getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(String capabilities) {
        this.capabilities = capabilities;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
