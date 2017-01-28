package dsardy.in.sharedpreferencedemo;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnAdd , btnSub ;
    TextView display;
    int count;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        ed = sharedPreferences.edit();



        //link the ui

        btnAdd = (Button)findViewById(R.id.buttonAdd);
        btnSub = (Button)findViewById(R.id.buttonSub);
        display = (TextView)findViewById(R.id.tv_countDisplay);

        //retrive initial count

        count = sharedPreferences.getInt("count",0);
        display.setText("Count: "+count);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count++;
                display.setText("Count: "+count);

            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count--;
                display.setText("Count: "+count);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        ed.putInt("count",count);
        ed.commit();
    }
}
