package peaksource.tn.barcodescannertest;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import peaksource.tn.barcodescannertest.Utils.Constants;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{


    Button btnClickMe;
    EditText myedit;
    String editContent = "";
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClickMe = findViewById(R.id.btnClickMe);
        myedit = findViewById(R.id.myedit);
        resultText = findViewById(R.id.resultText);
        resultText.setText("");
        btnClickMe.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnClickMe)
        {
            Toast.makeText(MainActivity.this,"I have been clicked",Toast.LENGTH_LONG).show();
            editContent = myedit.getText().toString();
            goToNextActivity();
        }

    }

    private void goToNextActivity()
    {
        Intent i = new Intent(MainActivity.this,SimpleScannerActivity.class);
        i.putExtra(Constants.INTENT_TAG,editContent);
        //startActivity(i);
            startActivityForResult(i,Constants.REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_CODE && resultCode == Constants.RESULT_CODE && data != null)
        {
            resultText.setText(data.getExtras().getString(Constants.BAR_CODE_INTENT_TAG));
        }
     //   Log.e("resultCalled","res");
    }
}
