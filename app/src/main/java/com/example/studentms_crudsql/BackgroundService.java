package com.example.studentms_crudsql;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class BackgroundService extends Service {
    private static final String TAG = BackgroundService.class.getSimpleName();
    private static final String CHANNEL_ID = "MyChannel";
    private static final int NOTIFICATION_ID = 1;

    private Handler handler;
    private Runnable runnable;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate()");
        handler = new Handler();
        startBackgroundTask();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void startBackgroundTask() {
        runnable = new Runnable() {
            @Override
            public void run() {
                // Perform background tasks here

                // Check for new events and announcements
                boolean hasNewItems = checkForNewItems();

                if (hasNewItems) {
                    // Display notification
                    showNotification("New Event", "A new event is available");
                }

                // Schedule the next execution after a certain interval (e.g., 10 seconds)
                handler.postDelayed(this, 10000);
            }
        };

        // Schedule the initial execution of the background task
        handler.post(runnable);
    }

    private boolean checkForNewItems() {
        // Implement your logic here to check for new events and announcements
        // Return true if new items are available, false otherwise

        return true; // For demonstration purposes, always return true
    }

    private void showNotification(String title, String message) {
        // Create a PendingIntent to open the application when the notification is clicked
        Intent intent = new Intent(this, EventDetailsActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Create a notification channel (required for Android Oreo and above)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "My Channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        // Build the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent); // Set the PendingIntent

        // Show the notification
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
        // Stop the background task when the service is destroyed
        handler.removeCallbacks(runnable);
    }
}
