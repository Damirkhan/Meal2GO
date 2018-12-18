package user.domain.net.meal2go;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener,BottomNavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Meal2GO");
        toolbar.setTitleMarginStart(270);
        //toolbar.setLogo(R.drawable.logo);

        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this, drawerLayout,
                        toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

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
                break;
            case R.id.nav_favorite:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new favoriteFragment()).commit();
                break;
            case R.id.nav_orders:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new orderFragment()).commit();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new profileFragment()).commit();
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new aboutFragment()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void CartPressAction(View view) {
    }
}