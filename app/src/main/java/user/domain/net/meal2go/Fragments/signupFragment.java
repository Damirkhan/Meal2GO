package user.domain.net.meal2go.Fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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

import user.domain.net.meal2go.Activities.MainActivity;
import user.domain.net.meal2go.Database;
import user.domain.net.meal2go.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class signupFragment extends Fragment {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    EditText signup_name;
    EditText signup_email;
    EditText signup_password;
    Button signup_btn;
    TextView signup_login;

    public signupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        signup_name = view.findViewById(R.id.signup_name);
        signup_email = view.findViewById(R.id.signup_email);
        signup_password = view.findViewById(R.id.signup_password);
        signup_btn = view.findViewById(R.id.signup_btn);
        signup_login = view.findViewById(R.id.signup_login);


        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        return view;
    }



    public void signup() {

        if (!validate()) {
            onSignupFailed();
            return;
        }

        signup_btn.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(getActivity(),
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = signup_name.getText().toString();
        final String email = signup_email.getText().toString();
        final String password = signup_password.getText().toString();

        // TODO: Implement your own signup logic here.
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                       createAccount(email,password);
                        //
                        progressDialog.dismiss();
                    }
                }, 3000);
    }



    public void onSignupSuccess() {
        signup_btn.setEnabled(true);
        getActivity().setResult(getActivity().RESULT_OK, null);
        Intent intent = new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
    }

    public void onSignupFailed() {
        Toast.makeText(getActivity().getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        signup_btn.setEnabled(true);
    }

    public void createAccount(String email, String password) {


        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();
                            onSignupSuccess();

                        } else {
                            // If sign in fails, display a message to the user.
                            onSignupFailed();
                        }

                        // [START_EXCLUDE]
                        // hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
        // [END create_user_with_email]
    }
    public boolean validate() {
        boolean valid = true;

        String name = signup_name.getText().toString();
        String email = signup_email.getText().toString();
        String password = signup_password.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            signup_name.setError("at least 3 characters");
            valid = false;
        } else {
            signup_name.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signup_email.setError("enter a valid email address");
            valid = false;
        } else {
            signup_email.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            signup_password.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            signup_password.setError(null);
        }

        return valid;
    }
}
