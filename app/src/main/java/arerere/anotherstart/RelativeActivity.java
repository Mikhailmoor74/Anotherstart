package arerere.anotherstart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RelativeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private TextView action;
    private BottomNavigationView bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);

        action = findViewById(R.id.action);
        bottom = findViewById(R.id.navigation);

        bottom.setOnNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.bottomGit) {
            action.setText("GIT");
            return true;
        } else if (item.getItemId() == R.id.bottomABC) {
            action.setText("ABC");
            return true;
        } else if (item.getItemId() == R.id.bottomMenu) {
            action.setText("Menu");
            return true;
        }
        return false;
    }
}
