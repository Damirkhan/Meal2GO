package user.domain.net.meal2go.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import user.domain.net.meal2go.Classes.Food;
import user.domain.net.meal2go.R;


public class FoodAdapter extends ArrayAdapter {
    private final Activity context;

    private final String[] imageIDarray;

    private final String[] nameArray;

    private final double[] costArray;
    Button add_to_cart;

    public FoodAdapter(Activity context, Food[] foodlist) {
        super(context, R.layout.food_item, foodlist);

        this.context = context;

        imageIDarray = new String[foodlist.length];
        nameArray = new String[foodlist.length];
        costArray = new double[foodlist.length];

        for (int i = 0; i < foodlist.length; i++) {
            imageIDarray[i] = foodlist[i].getFood_photo();
            nameArray[i] = foodlist[i].getFood_name();
            costArray[i] = foodlist[i].getFood_cost();
        }
    }




    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.food_item, null,true);

        TextView nameTextField = rowView.findViewById(R.id.food_name);
        TextView countField = rowView.findViewById(R.id.food_price);
        ImageView imageView = rowView.findViewById(R.id.food_image);
        add_to_cart = rowView.findViewById(R.id.add_to_cart);

        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (add_to_cart.getBackground().equals(R.drawable.btn_ok_white)) {
                    add_to_cart.setBackground(context.getResources().getDrawable(R.drawable.btn_ok_yellow));

                } else {
                    v.setBackground(context.getResources().getDrawable(R.drawable.btn_ok_white));

                }
            }
        });

//
//        ViewGroup.LayoutParams params = rowView.getLayoutParams();
//
//        // Set the height of the Item View
//        params.height = 200;
//        rowView.setLayoutParams(params);

        nameTextField.setText(nameArray[position]);
        countField.setText(costArray[position]+" sums");
//        imageView.setImageResource(imageIDarray[position]);
        imageView.setImageResource(R.drawable.logo);
        return rowView;

    }
}