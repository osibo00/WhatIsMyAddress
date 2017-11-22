package productions.darthplagueis.whatismyaddress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    private TextView textView01, textView02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        textView01 = (TextView) findViewById(R.id.display_01_textview);
        textView02 = (TextView) findViewById(R.id.display_02_textview);

        Intent intent = getIntent();
        String email = intent.getStringExtra("displaytext");
        textView01.setText(email);

        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < email.length(); i++) {
            characters.add(email.charAt(i));
        }
        int numCharacters = characters.size();
        String charNumber = String.valueOf(numCharacters);

        textView02.setText(charNumber);
    }
}
