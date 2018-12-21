package user.domain.net.meal2go;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.Executor;

import user.domain.net.meal2go.Activities.AuthActivity;

import static android.support.constraint.Constraints.TAG;

public class Database {
    private int login_status = 0;
    private int signup_status = 0;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();



    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    public Database(){



    }
    public void check(){
    mDatabase.child("user").child("123").child("user_name").setValue("Added");
    }
    public int createAccount(String email, String password) {


        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();
                            signup_status = 1;

                        } else {
                            // If sign in fails, display a message to the user.
                            signup_status = 0;
                        }

                        // [START_EXCLUDE]
                       // hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
        // [END create_user_with_email]
        return signup_status;
    }

    public int signIn(String email, String password) {





        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener( new AuthActivity(),
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();
                            login_status = 1;
                        }
                        else
                        {
                            login_status = 0;
                        }


                       // hideProgressDialog();

                    }
                });
        // [END sign_in_with_email]
        return login_status;
    }


}
