package user.domain.net.meal2go;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Database {
    Database(){



    }
   public void authUser(String username, String password)
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("user").child("123").child("first_name").setValue("NoName");
    }
}
