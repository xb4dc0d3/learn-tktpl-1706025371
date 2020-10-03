package id.ac.ui.cs.mobileprogramming.nux.helloworld;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class FetchUsername extends AsyncTaskLoader<String> {

    private String mUsername;

    public FetchUsername(Context context, String username) {
        super(context);
        mUsername = username;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.getUsername(mUsername);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        // Force an asynchronous load. Unlike {@link #startLoading()} this will ignore a previously
        // loaded data set and load a new one
        forceLoad();
    }
}
