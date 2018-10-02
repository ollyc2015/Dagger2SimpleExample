package uk.co.oliverbcurtis.dagger2example;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends BaseActivity {

    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textview1);

        prefs.edit().putInt("Number", 6).apply();

        textView1.setBackgroundColor(res.getColor(android.R.color.holo_red_dark));

        //Get the int held in the String "Number", if nothing found, return 0
        Log.d("DEBUG_TAG", "onCreate: The value of Number is : " + prefs.getInt("Number", 0));
    }
}
