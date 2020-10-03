package id.ac.ui.cs.mobileprogramming.nux.helloworld;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/***
 * @Deprecated
 * Loaders have been deprecated as of Android P (API 28).
 * The recommended option for dealing with loading data while handling the Activity and Fragment
 * lifecycles is to use a combination of ViewModels and LiveData
 */
public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private EditText mBookName;
    private TextView mBookResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBookName = findViewById(R.id.text_bar_bookname);
        mBookResult = (TextView) findViewById(R.id.book_result);

        //If the loader exists, initialize it.
        // You only want to reassociate the loader to the activity if a query has already been executed.
        if (getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }
    }

    public void searchBookName(View view) {
        String queryBookName = mBookName.getText().toString();

        // Hide keyboard after entering the text
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
        // Check connectivity of network connection
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected() && queryBookName.length() != 0) {

            // If the network is connected start a FetchUsername AsyncTask.
            Bundle queryBundle = new Bundle();
            queryBundle.putString("queryBookName", queryBookName);
            getSupportLoaderManager().restartLoader(0, queryBundle, this);

            mBookResult.setText("");
            mBookResult.setText(R.string.loading);

        } else {
            if (queryBookName.length() == 0) {

                // if input empty show no search
                mBookResult.setText("");
                mBookResult.setText(R.string.no_search_term);
            } else {
                // if not network connection show the text
                mBookResult.setText("");
                mBookResult.setText(R.string.no_network);
            }
        }
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String queryBookname = "";

        if (args != null) {
            queryBookname = args.getString("queryBookName");
        }
        return new FetchBook(this, queryBookname);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            Thread.sleep(3000);
            // If both are found, display the result.
            if (data != null && !data.contains("java.io.Buffered")) {
                mBookResult.setText(data);
            }
            else {
                mBookResult.setText(R.string.not_found);
            }
        } catch (Exception e) {
            mBookResult.setText(R.string.not_found);
            e.printStackTrace();
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
        // Do nothing
    }

    @Override
    // Override backpress button and show popup
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}