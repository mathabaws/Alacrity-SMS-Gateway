package xyz.vukovicc.alacritysms.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import xyz.vukovicc.alacritysms.views.MainActivity;

public class SplashActivity extends AppCompatActivity {
    private final String TAG = "SPLASH_ACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_splash);*/
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        try {
            Log.d(TAG, "Workin good..");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finish();
    }
}
