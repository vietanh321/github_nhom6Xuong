package fpoly.thanhndph45160.nhom6_quanlithuchi;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button btngetstarted = findViewById(R.id.btngetstarted);

        new CountDownTimer(3000,1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(WelcomeActivity.this, DangnhapActivity.class);
                startActivity(intent);


            }
        }.start();

    }
}
