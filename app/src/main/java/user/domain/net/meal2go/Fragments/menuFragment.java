package user.domain.net.meal2go.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import user.domain.net.meal2go.Adapters.MenuAdapter;
import user.domain.net.meal2go.Classes.Category;
import user.domain.net.meal2go.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class menuFragment extends Fragment {

    ListView listView;


    public menuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_menu, container, false);
        Category menu_category[]  = new Category[2];
        menu_category[0] = new Category(24,"Pizza","R.id.logo");
        menu_category[1] = new Category(13,"Snacks","R.id.logo");

        MenuAdapter list = new MenuAdapter(getActivity(),menu_category);
        listView = view.findViewById(R.id.menu_list);
        listView.setAdapter(list);

        return view;
    }


}
