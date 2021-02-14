package id.ac.ui.cs.mobileprogramming.nux.helloworld;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class FetchBook extends AsyncTaskLoader<String> {

    private String mBookName;

    public FetchBook(Context context, String bookName) {
        super(context);
        mBookName = bookName;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.getBookName(mBookName);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        // Force an asynchronous load. Unlike {@link #startLoading()} this will ignore a previously
        // loaded data set and load a new one
        forceLoad();
    }
}
