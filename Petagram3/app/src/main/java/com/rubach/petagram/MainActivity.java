package com.rubach.petagram;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> Mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toolbar miActionBar=(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        //muestro el logo
        getSupportActionBar().setLogo(R.drawable.cat_footprint_48);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final ActionBar ab = getSupportActionBar();
        //ab.setHomeAsUpIndicator(R.drawable.ic_menu); // set a custom icon for the default home button
        ab.setDisplayShowHomeEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        //muestro los objetos vertical
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //configuro que se muestra asi en el recicleview
        listaMascotas.setLayoutManager(llm);
        //cargo las mascotas
        InicializarListaMascotas();
        //cargo el adaptador
        inicializarAdaptador();
    }

    public void onClickSiguiente(View v){
        Intent intent=new Intent(this,DetalleActivity.class);
        startActivity(intent);
    }
    public void InicializarListaMascotas(){

        Mascotas=new ArrayList<Mascota>();

        Mascotas.add(new Mascota("Gato",4, R.drawable.pet1));
        Mascotas.add(new Mascota("Perro",5, R.drawable.pet2));
        Mascotas.add(new Mascota("Tom",4, R.drawable.pet3));
        Mascotas.add(new Mascota("Jerry",3, R.drawable.pet4));
        Mascotas.add(new Mascota("Spice",2, R.drawable.pet5));

    }
    public void inicializarAdaptador(){
        //crea uno objeto y le pasa la lista
        MascotaAdaptador adaptador=new MascotaAdaptador(Mascotas,this);
        //asigno el adaptador.
        listaMascotas.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_favorite:
                //al seleccionar, voy a la activity detalle.
                Intent intent=new Intent(this, DetalleActivity.class);
                this.startActivity(intent);
            return true;
            case R.id.action_about:
                Toast.makeText(this,"by Ronald Ubach, Coursera",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
