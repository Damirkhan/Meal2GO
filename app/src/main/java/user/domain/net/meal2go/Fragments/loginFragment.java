package user.domain.net.meal2go.Fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

import user.domain.net.meal2go.Activities.AuthActivity;
import user.domain.net.meal2go.Activities.MainActivity;
import user.domain.net.meal2go.Database;
import user.domain.net.meal2go.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class loginFragment extends Fragment {


    private static final String TAG = "loginFragment";
    private static final int REQUEST_SIGNUP = 0;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    EditText login_email;
    EditText login_password;
    Button login_btn;
    TextView login_signup;


    public loginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_login, container, false);

       login_email = view.findViewById(R.id.login_email);
       login_password = view.findViewById(R.id.login_password);
       login_btn = view.findViewById(R.id.login_btn);
       login_signup = view.findViewById(R.id.login_signup);


        login_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        return view;

    }


    public void login() {

        if (!validate()) {
            onLoginFailed();
            return;
        }

        login_btn.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        final String email = login_email.getText().toString();
        final String password = login_password.getText().toString();

        // TODO: Implement your own authentication logic here.


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        signIn(email,password);
                        progressDialog.dismiss();
                    }
                }, 3000);
    }



    public boolean validate() {
        boolean valid = true;

        String email = login_email.getText().toString();
        String password = login_password.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            login_email.setError("Enter a valid email address");
            valid = false;
        } else {
            login_email.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            login_password.setError("Between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            login_password.setError(null);
        }

        return valid;
    }



    public void onLoginSuccess() {
        login_btn.setEnabled(true);
        Intent intent = new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
    }

    public void onLoginFailed() {
        Toast.makeText(getActivity().getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        login_btn.setEnabled(true);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == getActivity().RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                getActivity().finish();
            }
        }
    }


    public void signIn(String email, String password) {





        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(getActivity(),
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();

                            onLoginSuccess();
                           // login_status = 1;
                        }
                        else
                        {
                            //login_status = 0;
                            onLoginFailed();

                        }


                        // hideProgressDialog();

                    }
                });
        // [END sign_in_with_email]
       // return login_status;
    }


}
