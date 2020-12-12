package datnguyen.lab.passioproject.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;

import java.util.concurrent.TimeUnit;

import datnguyen.lab.passioproject.R;

public class PhoneLoginActivity extends AppCompatActivity {
    CountryCodePicker countryCodePicker_107;
    EditText edt_phone_107;
    Button btn_continue_107;
    private FirebaseAuth mAuth_107;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_login);

        countryCodePicker_107 = findViewById(R.id.ccp_107);
        edt_phone_107 = findViewById(R.id.edt_input_phone_107);
        btn_continue_107 = findViewById(R.id.btn_continue_107);
        countryCodePicker_107.registerCarrierNumberEditText(edt_phone_107);

        btn_continue_107.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PhoneLoginActivity.this, OTPManaActivity.class);
                intent.putExtra("mobile",countryCodePicker_107.getFullNumberWithPlus().replace(" ",""));
                startActivity(intent);
            }
        });
    }

    public void back_login(View view) {
        startActivity(new Intent(PhoneLoginActivity.this, WelcomeActivity.class));
    }
}