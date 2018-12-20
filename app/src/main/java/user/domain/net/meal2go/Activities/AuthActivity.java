package user.domain.net.meal2go.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import user.domain.net.meal2go.R;
import user.domain.net.meal2go.Fragments.loginFragment;
import user.domain.net.meal2go.Fragments.signupFragment;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_auth,new loginFragment()).commit();

    }

    public void CreateAccountAction(View view) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_auth,new signupFragment()).commit();
    }

    public void LoginAction(View view) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_auth,new loginFragment()).commit();

    }



}
