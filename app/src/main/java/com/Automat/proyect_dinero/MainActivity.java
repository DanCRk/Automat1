package com.Automat.proyect_dinero;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.Automat.proyect_dinero.fragments.GlosarioFragment;
import com.Automat.proyect_dinero.fragments.MainFragment;
import com.Automat.proyect_dinero.fragments.ManufacturaFragment;
import com.Automat.proyect_dinero.fragments.MaterialesFragment;
import com.Automat.proyect_dinero.fragments.MetrologiaFragment;
import com.Automat.proyect_dinero.fragments.TornoFragment;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    TextView textView;

    // Variables para cargar el fragment principal

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciar las weas locas

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView =findViewById(R.id.navigationView);

        // Establecer evento onclick al navigationView

        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        // Cargar fragment principal

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new MainFragment());
        fragmentTransaction.commit();

        /*  PARA QUE EL MENU SELECCIONADO CAMBIE DE COLOR PERO NO C ARREGLARLO

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        MenuItem menuItem = navigationView.getMenu().getItem(0);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);*/
        
    }

    // Al presionar BACK si el menu esta desplegado se cierre

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    // Cargar fragment al hacer click en la opcion indicada en el navigation drawer

    @SuppressLint("SetTextI18n")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        textView = findViewById(R.id.texto_toolbar);
        drawerLayout.closeDrawer(GravityCompat.START);
        if (menuItem.getItemId() == R.id.home){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new MainFragment());
            fragmentTransaction.commit();
            textView.setText("PRINCIPAL");
        }
        if (menuItem.getItemId() == R.id.metrologia){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new MetrologiaFragment());
            fragmentTransaction.commit();
            textView.setText("METROLOGIA");
        }
        if (menuItem.getItemId() == R.id.materiales){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new MaterialesFragment());
            fragmentTransaction.commit();
            textView.setText("MATERIALES");
        }
        if (menuItem.getItemId() == R.id.manufactura){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new ManufacturaFragment());
            fragmentTransaction.commit();
            textView.setText("MANUFACTURA");
        }
        if (menuItem.getItemId() == R.id.torno_fresa){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new TornoFragment());
            fragmentTransaction.commit();
            textView.setText("TORNO Y FRESA");
        }
        if (menuItem.getItemId() == R.id.glosario){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new GlosarioFragment());
            fragmentTransaction.commit();
            textView.setText("GLOSARIO");
        }
        /* ACTUALIZACION
        if (menuItem.getItemId() == R.id.unidades){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new UnidadesFragment());
            fragmentTransaction.commit();
            textView.setText("UNIDADES");
        }
         */
        /* ACTUALIZACION
        if (menuItem.getItemId() == R.id.simbologia){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new SimbologiaFragment());
            fragmentTransaction.commit();
            textView.setText("SIMBOLOGIA");
        }
        */

        // Cargar la actividad de Ayuda

        if (menuItem.getItemId() == R.id.ayuda){
            startActivity(new Intent(MainActivity.this, AyudaActivity.class));
        }

        // Agregar la accion para compartir la app

        if (menuItem.getItemId() == R.id.compartir){
            Intent compartir = new Intent(Intent.ACTION_SEND);
            compartir.setType("text/plain");
            String mensaje = "Comparte la app con tus amigos: https://play.google.com/store/apps/details?id=com.Automat.proyect_dinero)";
            compartir.putExtra(Intent.EXTRA_SUBJECT,"App prrona");
            compartir.putExtra(Intent.EXTRA_TEXT, mensaje);
            startActivity(Intent.createChooser(compartir,"Compartir via"));
        }

        // Direccionar a una URL

        if (menuItem.getItemId() == R.id.faceB){
            Uri uri =Uri.parse("https://facebook.com/FutureFiix");
            Intent intent =new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }

        // Direccionar a una URL

        if (menuItem.getItemId() == R.id.pagina_web){
            Uri uri =Uri.parse("https://dancrkyt.wixsite.com/future-fix");
            Intent intent =new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        if (menuItem.getItemId() == R.id.acerca_de){
            startActivity(new Intent(MainActivity.this, AcercadeActivity.class));
        }
        /*
        if (menuItem.getItemId() == R.id.manufactura){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new ManufaturaFragment());
            fragmentTransaction.commit();
            textView.setText("MANUFACTURA");
        }
        */
        return false;
    }
}