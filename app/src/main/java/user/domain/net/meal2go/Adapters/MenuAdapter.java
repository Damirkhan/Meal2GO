package user.domain.net.meal2go.Adapters;

import android.content.Context;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;

import user.domain.net.meal2go.Classes.Category;
import user.domain.net.meal2go.Fragments.menuFragment;
import user.domain.net.meal2go.R;


public class MenuAdapter extends ArrayAdapter {
    private final Activity context;

    private final String[] imageIDarray;

    private final String[] nameArray;

    private final int[] counterArray;

    public MenuAdapter(Activity context, Category[] menu) {
        super(context, R.layout.menu_item,menu);

        this.context = context;

        imageIDarray = new String[menu.length];
        nameArray = new String[menu.length];
        counterArray = new int[menu.length];

        for (int i=0;i<menu.length;i++){
            imageIDarray[i] = menu[i].getCategory_photo();
            nameArray[i] = menu[i].getCategory_name();
            counterArray[i] = menu[i].getCount();
        }
    }




    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.menu_item, null,true);

        TextView nameTextField = rowView.findViewById(R.id.category_name);
        TextView countField = rowView.findViewById(R.id.category_count);
        BootstrapCircleThumbnail imageView = rowView.findViewById(R.id.category_image);

//
//        ViewGroup.LayoutParams params = rowView.getLayoutParams();
//
//        // Set the height of the Item View
//        params.height = 200;
//        rowView.setLayoutParams(params);

        nameTextField.setText(nameArray[position]);
        countField.setText(counterArray[position]+" items");
//        imageView.setImageResource(imageIDarray[position]);
        imageView.setImageResource(R.drawable.logo);
        return rowView;

    }

}
