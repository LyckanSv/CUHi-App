package sv.com.lyckan.cuentameuncuento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class LoginActivity extends AppCompatActivity {

    //Linking
    @BindView(R.id.button_login)
    Button btnLogin;
    @BindView(R.id.label_button_logup)
    TextView btnLogup;
    @BindView(R.id.email_editText)
    EditText email;
    @BindView(R.id.pass_emailText)
    EditText password;

    AwesomeValidation mAwesomeValidation = new AwesomeValidation(BASIC);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mAwesomeValidation.addValidation(this, email.getId(), Patterns.EMAIL_ADDRESS, R.string.error_mail);
        mAwesomeValidation.addValidation(this, password.getId(), "([\\w]{8,32})", R.string.error_pass);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    private boolean validate(){
//        if (mAwesomeValidation.validate()) {
//            ///Si es valido intentaremos hacer la consulta al servidor
//            requestToService(email.getText().toString(), password.getText().toString());
//        }

        if (true) {
            ///Si es valido intentaremos hacer la consulta al servidor
            requestToService(email.getText().toString(), password.getText().toString());
        }
        return false;
    }

    private void requestToService(String email, String password){
        //TODO: Esta funcion consultara al servidor
        String token = "";

        //Se debe de de guardar los datos antes de iniciar
        //saveDataUser();
        start();
    }

    private void saveDataUser(String name, String image, String token){
        //TODO: Esta clase guardara los datos del usuario en las preferencias
    }

    public void start(){
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);

        Intent intent = new Intent(this, ReadFragmentActivity.class);
        intent.putExtra("chapters", 10);
        startActivity(intent);
    }
}
