package com.example.nurad.finalprojejtandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List<Produk> lstProduk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //=================== kontent menu list (Recycler View) =====================
        lstProduk = new ArrayList<>();
        lstProduk.add(new Produk("Teh 1",
                "Category: Paket",
                "Nasi\n" +
                        "Sayap\n" +
                        "Es Teh",
                8000,R.drawable.paketsayap));
        lstProduk.add(new Produk("Teh 2",
                "Category: Paket",
                "Nasi\n" +
                        "Paha Bawah\n" +
                        "Es Teh",
                10000,R.drawable.ppahab));
        lstProduk.add(new Produk("Teh 3",
                "Category: Paket",
                "Nasi\n" +
                        "Dada\n" +
                        "Es Teh",
                12000,R.drawable.pdada));
        lstProduk.add(new Produk("Teh 4",
                "Category: Paket",
                "Nasi\n" +
                        "Paha Atas\n" +
                        "Es Teh",
                9000,R.drawable.ppahaa));
        lstProduk.add(new Produk("Paha Atas",
                "Category: Item",
                "\n" +
                        "\n" +
                        "",
                5000,R.drawable.pa));
        lstProduk.add(new Produk("Paha Bawah",
                "Category: Item",
                "\n" +
                        "\n" +
                        "",
                4500,R.drawable.pb));
        lstProduk.add(new Produk("Dada",
                "Category: Item",
                "\n" +
                        "\n" +
                        "",
                5000,R.drawable.dada));
        lstProduk.add(new Produk("Burger",
                "Category: Item",
                "B\n" +
                        "lengkap" +
                        "",
                15000,R.drawable.burger));
        lstProduk.add(new Produk("French Fries",
                "Category: Item",
                "\n" +
                        "" +
                        "",
                7000,R.drawable.kentang));
        lstProduk.add(new Produk("Spagheti",
                "Category: Item",
                "\n" +
                        "" +
                        "",
                12000,R.drawable.spag));
        lstProduk.add(new Produk("Sup",
                "Category: Item",
                "\n" +
                        "" +
                        "",
                9000,R.drawable.sup));
        lstProduk.add(new Produk("Rice",
                "Category: Item",
                "\n" +
                        "" +
                        "",
                3000,R.drawable.rice));
        lstProduk.add(new Produk("Es Teh",
                "Category: Drink",
                "\n" +
                        "" +
                        "",
                2500,R.drawable.tea));
        lstProduk.add(new Produk("Air Mineral",
                "Category: Drink",
                "\n" +
                        "" +
                        "",
                2000,R.drawable.botol));
        lstProduk.add(new Produk("Botol Sosro",
                "Category: Drink",
                "\n" +
                        "" +
                        "",
                5000,R.drawable.sosro));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstProduk);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);
        //=================== kontent menu list (Recycler View) =================
    }



  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Profile) {
            startActivity(new Intent(MainActivity.this, Profile.class));
        } else if (id == R.id.nav_TentangApp) {
            //startActivity(new Intent(MainActivity.this, TentangAplikasi.class));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setMessage("Aplikasi ini memudahkan anda untuk memesan\n");
            builder.setNegativeButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //if user select "No", just cancel this dialog and continue with app
                    dialog.cancel();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();

        } else {
            startActivity(new Intent(MainActivity.this, Bantuan.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }


}
