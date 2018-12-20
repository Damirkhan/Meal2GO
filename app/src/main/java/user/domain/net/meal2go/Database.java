package user.domain.net.meal2go;

import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Database {
    Database(){



    }
    private int count_number = 0;

    // This function for checking user is exist or not. Return true or false on success
    public boolean loginCheck(final String username, final String password)
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        Query query = myRef.child("user");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    if ((data.child(username).exists()) && (data.child(password).exists())) {
                       count_number = 2;
                    } else {
                        count_number = 1;
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        if(count_number == 2)
        {
            return true;
        }

        return false;
        }
}
