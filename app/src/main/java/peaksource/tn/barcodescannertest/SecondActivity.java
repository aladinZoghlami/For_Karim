package peaksource.tn.barcodescannertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import peaksource.tn.barcodescannertest.Utils.Constants;

public class SecondActivity extends AppCompatActivity {

    TextView mytxt;
    String extra = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mytxt = findViewById(R.id.mytxt);
        extra = getIntent().getExtras().getString(Constants.INTENT_TAG);
        mytxt.setText(extra);

    }
}
