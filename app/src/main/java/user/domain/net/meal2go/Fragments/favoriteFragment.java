package user.domain.net.meal2go.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import user.domain.net.meal2go.Adapters.FoodAdapter;
import user.domain.net.meal2go.Classes.Food;
import user.domain.net.meal2go.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class favoriteFragment extends Fragment {

    private int i=0;
    ListView favoritelistview;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    DatabaseReference foodlist = mDatabase.child("category");


    public favoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_favorite, container, false);

        final Food food_list[]  = new Food[2];
        food_list[0] = new Food(1,121,"This is fucking caption",125,"Margarita",
                "https://firebasestorage.googleapis.com/v0/b/meal2go-32099.appspot.com/o/girl_bw_hair_127085_2160x3840.jpg?alt=media&token=de40683a-d305-4ea1-80b5-2aa2cce5103a");
        food_list[1] = new Food(1,121,"This is fucking caption",125,"Margarita",
                "https://firebasestorage.googleapis.com/v0/b/meal2go-32099.appspot.com/o/girl_bw_hair_127085_2160x3840.jpg?alt=media&token=de40683a-d305-4ea1-80b5-2aa2cce5103a");

//        foodlist.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot data: dataSnapshot.getChildren() ) {
//
//                    food_list[i] = new Food(1,121,"This is fucking caption",125,"Margarita",
//                            "https://firebasestorage.googleapis.com/v0/b/meal2go-32099.appspot.com/o/girl_bw_hair_127085_2160x3840.jpg?alt=media&token=de40683a-d305-4ea1-80b5-2aa2cce5103a");
//                    ++i;
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        FoodAdapter list = new FoodAdapter(getActivity(),food_list);
        favoritelistview = view.findViewById(R.id.favorite_list);
        favoritelistview.setAdapter(list);



        return view;
    }

}
