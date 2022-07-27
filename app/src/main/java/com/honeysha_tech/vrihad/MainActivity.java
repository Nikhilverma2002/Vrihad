package com.honeysha_tech.vrihad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import java.util.Objects;
import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {

    SmoothBottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Window window = MainActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.bg_color));


        if (getSupportFragmentManager().findFragmentById(R.id.container) != null) {
            getSupportFragmentManager()
                    .beginTransaction().
                    remove(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.container))).commit();
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new Home())
                .commit();


        bottomBar=findViewById(R.id.bottomBar);
        bottomBar.setItemActiveIndex(0);
        bottomBar.setOnItemSelectedListener((OnItemSelectedListener) i -> {
            if (i == 0) {
                bottomBar.setItemActiveIndex(0);
                if (getSupportFragmentManager().findFragmentById(R.id.container) != null) {
                    getSupportFragmentManager()
                            .beginTransaction().
                            remove(Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.container))).commit();
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new Home())
                        .commit();
            } else if (i == 1) {
                bottomBar.setItemActiveIndex(1);
                if (MainActivity.this.getSupportFragmentManager().findFragmentById(R.id.container) != null) {
                    MainActivity.this.getSupportFragmentManager()
                            .beginTransaction().
                            remove(Objects.requireNonNull(MainActivity.this.getSupportFragmentManager().findFragmentById(R.id.container))).commit();
                }
                MainActivity.this.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new Quiz(), "list_announcement")
                        .commit();
            } else if (i == 2) {
                bottomBar.setItemActiveIndex(2);
                if (MainActivity.this.getSupportFragmentManager().findFragmentById(R.id.container) != null) {
                    MainActivity.this.getSupportFragmentManager()
                            .beginTransaction().
                            remove(Objects.requireNonNull(MainActivity.this.getSupportFragmentManager().findFragmentById(R.id.container))).commit();
                }
                MainActivity.this.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new Profile(), "list_announcement")
                        .commit();
            }
            return false;
        });
    }
}