package user.domain.net.meal2go.Activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.lang.reflect.Field;

import user.domain.net.meal2go.Adapters.MenuAdapter;
import user.domain.net.meal2go.Classes.Category;
import user.domain.net.meal2go.Fragments.FoodFragment;
import user.domain.net.meal2go.R;
import user.domain.net.meal2go.Fragments.aboutFragment;
import user.domain.net.meal2go.Fragments.favoriteFragment;
import user.domain.net.meal2go.Fragments.menuFragment;
import user.domain.net.meal2go.Fragments.orderFragment;
import user.domain.net.meal2go.Fragments.profileFragment;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener,BottomNavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
    ImageButton cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        cart = findViewById(R.id.cart_button);
        toolbar.setTitle("Meal2GO");
        toolbar.setTitleMarginStart(270);


        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);


        Field mDragger = null;
        try {
            mDragger = drawerLayout.getClass().getDeclaredField("mLeftDragger");

        mDragger.setAccessible(true);
        ViewDragHelper draggerObj = (ViewDragHelper) mDragger.get(drawerLayout);

        Field mEdgeSize = draggerObj.getClass().getDeclaredField("mEdgeSize");
        mEdgeSize.setAccessible(true);
        int edge = mEdgeSize.getInt(draggerObj);

        mEdgeSize.setInt(draggerObj, edge * 10  );
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this, drawerLayout,
                        toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,new menuFragment()).commit();

        //control navigationView
        navigationView = findViewById(R.id.nav_view);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        if(savedInstanceState==null){
            navigationView.setNavigationItemSelectedListener(this);
            navigationView.setCheckedItem(R.id.nav_menu);
            bottomNavigationView.setOnNavigationItemSelectedListener(this);
            bottomNavigationView.setSelectedItemId(R.id.nav_menu);
        }





    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_menu:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new menuFragment()).commit();
                bottomNavigationView.setVisibility(View.VISIBLE);
                bottomNavigationView.setOnNavigationItemSelectedListener(null);
                bottomNavigationView.setSelectedItemId(R.id.nav_menu);
                bottomNavigationView.setOnNavigationItemSelectedListener(this);
                navigationView.setCheckedItem(menuItem);
                break;
            case R.id.nav_favorite:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new favoriteFragment()).commit();
                bottomNavigationView.setOnNavigationItemSelectedListener(null);
                bottomNavigationView.setSelectedItemId(R.id.nav_favorite);
                bottomNavigationView.setOnNavigationItemSelectedListener(this);
                bottomNavigationView.setVisibility(View.VISIBLE);
                navigationView.setCheckedItem(menuItem);
                break;
            case R.id.nav_orders:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new orderFragment()).commit();
                bottomNavigationView.setVisibility(View.VISIBLE);
                bottomNavigationView.setOnNavigationItemSelectedListener(null);
                bottomNavigationView.setSelectedItemId(R.id.nav_orders);
                bottomNavigationView.setOnNavigationItemSelectedListener(this);
                navigationView.setCheckedItem(menuItem);
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new profileFragment()).commit();
                bottomNavigationView.setVisibility(View.GONE);
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new aboutFragment()).commit();
                bottomNavigationView.setVisibility(View.GONE);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void CartPressAction(View view) {
        Intent intent = new Intent(this,CartActivity.class);
        startActivity(intent);
    }

    public void moveToFoodsAction(View v){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new FoodFragment()).commit();

    }





}