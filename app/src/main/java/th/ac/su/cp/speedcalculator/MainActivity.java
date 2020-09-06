package th.ac.su.cp.speedcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calBtn = findViewById(R.id.calculate_btn);
        calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText distanceText = findViewById(R.id.distance_text);


                EditText timeText = findViewById(R.id.time_text);


                if ( distanceText.getText().toString().length()==0 || timeText.getText().toString().length()==0) {
                    Toast t = Toast.makeText(MainActivity.this, R.string.no_data, Toast.LENGTH_LONG);
                    t.show();
                } else {
                    String distanceTextStr = distanceText.getText().toString();
                    String timeTextStr = timeText.getText().toString();
                    double timeTextDouble = Double.parseDouble(timeTextStr);
                    double distanceTextDouble = Double.parseDouble(distanceTextStr);
                    if (timeTextDouble <= 0) {
                        Toast t = Toast.makeText(MainActivity.this, R.string.time_error, Toast.LENGTH_LONG);
                        t.show();
                    } else {
                        double resultDouble = distanceTextDouble / timeTextDouble * 3.6;
                        TextView resultTextView = findViewById(R.id.result_text);
                        String resultStr = String.format(
                                Locale.getDefault(), "%.2f", resultDouble
                        );
                        resultTextView.setText(resultStr);
                        if (resultDouble > 80) {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle(R.string.app_name);
                            dialog.setMessage(R.string.over);
                            dialog.setPositiveButton("ํYES", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                            dialog.show();
                        }
                    }
                }
            }

        });
        Button clearBtn = findViewById(R.id.clear_btn);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText distanceText = findViewById(R.id.distance_text);
                EditText timeText = findViewById(R.id.time_text);
                TextView resultTextView = findViewById(R.id.result_text);
                distanceText.setText(null);
                timeText.setText(null);
                resultTextView.setText(null);
            }
        });
    }


}