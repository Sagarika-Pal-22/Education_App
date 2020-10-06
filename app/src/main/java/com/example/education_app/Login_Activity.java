package com.example.education_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.education_app.Model.MyBounceInterpolator;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;
import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_STATIC_DP;

public class Login_Activity extends AppCompatActivity {

    LinearLayout register;
    CardView card_login;
    Button button_login;
    EditText edt_email,edt_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        register = findViewById(R.id.register);
        card_login = findViewById(R.id.card_login);
        button_login = findViewById(R.id.button_login);
        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Activity.this,Registration_Activity.class));
            }
        });
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(Login_Activity.this, R.anim.bounce);
                MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
                myAnim.setInterpolator(interpolator);
                card_login.startAnimation(myAnim);
                startActivity(new Intent(Login_Activity.this,MainActivity.class));
//                if (edt_email.getText().toString().equals("")){
//                    edt_email.setError("Registered email is required");
//                }else if (edt_password.getText().toString().equals("")){
//                    edt_password.setError("Registered password id required");
//                }else {
//                    startActivity(new Intent(Login_Activity.this,MainActivity.class));
//                }
            }
        });







    }
}