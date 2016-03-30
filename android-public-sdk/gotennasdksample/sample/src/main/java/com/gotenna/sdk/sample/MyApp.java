package com.gotenna.sdk.sample;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.gotenna.sdk.GoTenna;
import com.gotenna.sdk.exceptions.GTInvalidAppTokenException;
import com.gotenna.sdk.sample.managers.IncomingMessagesManager;

/**
 * Created on 2/10/16
 *
 * @author ThomasColligan
 */
public class MyApp extends Application
{
    // ================================================================================
    // Class Properties
    // ================================================================================

    private static final String LOG_TAG = "MyApp";
    private static final String GOTENNA_APP_TOKEN = "i6i61v4k4hehip3q6q06bu6gas91asa5";
    private static Context applicationContext;

    // ================================================================================
    // Lifecycle Methods
    // ================================================================================

    @Override
    public void onCreate()
    {
        super.onCreate();

        try
        {
            // Must call setApplicationToken before using any SDK methods
            MyApp.applicationContext = getApplicationContext();
            GoTenna.setApplicationToken(getApplicationContext(), GOTENNA_APP_TOKEN);
            IncomingMessagesManager.getInstance().startListening();
        }
        catch (GTInvalidAppTokenException e)
        {
            // Normally, this will never happen
            Log.w(LOG_TAG, e);
        }
    }

    // ================================================================================
    // Helper Methods
    // ================================================================================

    public static Context getAppContext()
    {
        return applicationContext;
    }
}
