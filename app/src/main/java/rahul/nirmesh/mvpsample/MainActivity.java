package rahul.nirmesh.mvpsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;
import rahul.nirmesh.mvpsample.presenter.ILoginPresenter;
import rahul.nirmesh.mvpsample.presenter.LoginPresenter;
import rahul.nirmesh.mvpsample.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText edit_email, edit_password;
    Button btn_login;

    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_email = findViewById(R.id.edit_email);
        edit_password = findViewById(R.id.edit_password);
        btn_login = findViewById(R.id.btn_login);

        loginPresenter = new LoginPresenter(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLogin(edit_email.getText().toString(),
                        edit_password.getText().toString());
            }
        });
    }

    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show();
    }
}
