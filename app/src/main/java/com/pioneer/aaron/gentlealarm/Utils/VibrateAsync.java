package com.pioneer.aaron.gentlealarm.Utils;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Vibrator;

/**
 * Created by Aaron on 7/1/15.
 */
public class VibrateAsync extends AsyncTask {
    private long[] pattern = {1000, 50};
    private Context context;
    private Vibrator vibrate;

    public VibrateAsync(Context context) {
        this.context = context;
        vibrate = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }

    @Override
    protected Object doInBackground(Object[] params) {
        for (int i = 0; i < 99999; ++i) {
            long sleepTime = 0;
            if (pattern[0] >= 20) {
                pattern[0] -= 10;
            }
            vibrate.vibrate(pattern, -1);

            try {
                for (int j = 0; j < pattern.length; ++j) {
                    sleepTime += pattern[j];
                }
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (isCancelled()) {
                return null;
            }
        }
        return null;
    }


}