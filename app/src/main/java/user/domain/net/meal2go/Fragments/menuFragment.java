package user.domain.net.meal2go.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import user.domain.net.meal2go.Adapters.MenuAdapter;
import user.domain.net.meal2go.Classes.Category;
import user.domain.net.meal2go.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class menuFragment extends Fragment {
    private int i=0;
    ListView listView;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    DatabaseReference category = mDatabase.child("category");

    public menuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_menu, container, false);
        final Category menu_category[]  = new Category[2];
        menu_category[1] = new Category(13,"Snacks","R.id.logo");
        category.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data: dataSnapshot.getChildren() ) {
                    
                    menu_category[i] = new Category(24,"Pizza","R.id.logo");
                    ++i;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        MenuAdapter list = new MenuAdapter(getActivity(),menu_category);
        listView = view.findViewById(R.id.menu_list);
        listView.setAdapter(list);

        return view;
    }


}
