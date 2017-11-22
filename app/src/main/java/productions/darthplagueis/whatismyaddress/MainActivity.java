package productions.darthplagueis.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button01, button02;
    private static final String ADDRESS_SHARED_PREFERENCES = "address_shared_preferences";
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.main_edittext);
        button01 = (Button) findViewById(R.id.main_01_button);
        button02 = (Button) findViewById(R.id.main_02_button);

        preferences = getApplicationContext().getSharedPreferences(ADDRESS_SHARED_PREFERENCES, MODE_PRIVATE);

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = preferences.edit();
                String emailAddress = editText.getText().toString();
                editor.putString(emailAddress, emailAddress);
                editor.commit();
                editText.setText(null);
            }
        });
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                intent.putExtra("emailKey", ADDRESS_SHARED_PREFERENCES);
                startActivity(intent);
            }
        });
    }
}
