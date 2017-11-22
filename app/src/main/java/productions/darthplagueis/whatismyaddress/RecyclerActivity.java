package productions.darthplagueis.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import productions.darthplagueis.whatismyaddress.controller.EmailDisplayAdapter;
import productions.darthplagueis.whatismyaddress.model.EmailDisplay;

public class RecyclerActivity extends AppCompatActivity {

    private SharedPreferences getPreferences;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_recyclerview);

        Intent intent = getIntent();
        getPreferences = getApplicationContext().getSharedPreferences(intent.getStringExtra("sharedpref"), MODE_PRIVATE);

        ArrayList<String> prefList = new ArrayList<>();

        Map<String, ?> keys = getPreferences.getAll();
        for (Map.Entry<String, ?> entry : keys.entrySet()) {
            prefList.add(entry.getValue().toString());
        }

        List<EmailDisplay> emailDisplayList = new ArrayList<>();

        for (String email : prefList) {
            emailDisplayList.add(new EmailDisplay(email));
        }

        EmailDisplayAdapter adapter = new EmailDisplayAdapter(emailDisplayList);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }
}
