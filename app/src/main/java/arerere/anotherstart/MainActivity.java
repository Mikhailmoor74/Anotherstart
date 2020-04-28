package arerere.anotherstart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private Button buttonOn;
    private Button buttonOff;
    private Button buttonTsar;
    private Button buttonIntent;
    private CheckBox checkBox;

    private PopupMenu popupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOn = findViewById(R.id.buttonOn);
        buttonOff = findViewById(R.id.buttonOff);
        buttonTsar = findViewById(R.id.buttonTsar);
        checkBox = findViewById(R.id.checkBox);
        buttonTsar.setVisibility(View.GONE);
        buttonIntent = findViewById(R.id.buttonIntent);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    buttonTsar.setVisibility(View.GONE);

                } else {
                    buttonOn.setText("Whaaat?");
                    buttonOff.setText("Omg it's works");
                    buttonTsar.setVisibility(View.VISIBLE);
                    buttonTsar.setText("DEFAULT");
                }
            }
        });

        popupMenu = new PopupMenu(this, findViewById(R.id.options));
        popupMenu.inflate(R.menu.popup);
        popupMenu.setOnMenuItemClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.addMenu:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
                break;
            case R.id.nextMenu:
                Intent intent = new Intent(MainActivity.this, RelativeActivity.class);
                startActivity(intent);
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    public void On(View view) {
        checkBox.setChecked(true);
    }

    public void Off(View view) {
        checkBox.setChecked(false);
    }


    public void Default(View view) {
        checkBox.setChecked(false);
        buttonOn.setText("Button On");
        buttonOff.setText("Button Off");
    }

    public void NewIntent(View view) {

        Intent intent = new Intent(MainActivity.this, RelativeActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        if (item.getItemId() == R.id.popup_quit) {
            Toast.makeText(this, "Quit", Toast.LENGTH_LONG).show();
        }

        return false;
    }

    public void options(View view) {
        popupMenu.show();
    }
}
