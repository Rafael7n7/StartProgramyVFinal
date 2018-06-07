package startprogramy.studio.com.startprogramy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

import classes.*;
import classes.AdvertisingEmpresa;
import fragments.Inicio;

public class DetalheEmpresa extends AppCompatActivity {

    public RecyclerView recyclerView;
    public Inicio.CustomAdapter adapter;

    public ViewFlipper vFlipper;

    List<AdvertisingEmpresa> lstAdvertisingEmpresa;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_empresa);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_id_detalhe);

        vFlipper = (ViewFlipper) findViewById(R.id.pager);
        int images[] = {R.mipmap.logomaodevaca, R.mipmap.lindoambiente};

        for(int image:images){
            flipperImages(image);
        }


        lstAdvertisingEmpresa = new ArrayList<>();
        lstAdvertisingEmpresa.add(new AdvertisingEmpresa("Peixe","Categoria", "Descrição",R.mipmap.peixemaodevaca));
        lstAdvertisingEmpresa.add(new AdvertisingEmpresa("Pizza de Queijo Mussarela","Categoria", "Descrição",R.mipmap.cimidamaodevacas));
        lstAdvertisingEmpresa.add(new AdvertisingEmpresa("Pizza Portuguesa","Categoria", "Descrição",R.mipmap.comidamao1));
        lstAdvertisingEmpresa.add(new AdvertisingEmpresa("Pizza Nordestina","Categoria", "Descrição",R.mipmap.pizzaria));
        lstAdvertisingEmpresa.add(new AdvertisingEmpresa("Pizza","Categoria", "Descrição",R.mipmap.pizza));
        lstAdvertisingEmpresa.add(new AdvertisingEmpresa("Pizza","Categoria", "Descrição",R.mipmap.pizza2));
        lstAdvertisingEmpresa.add(new AdvertisingEmpresa("Pizza","Categoria", "Descrição",R.mipmap.pizza1));
        lstAdvertisingEmpresa.add(new AdvertisingEmpresa("Pizza","Categoria", "Descrição",R.mipmap.pizzaria));




        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstAdvertisingEmpresa);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(myAdapter);



    }



    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        vFlipper.addView(imageView);
        vFlipper.setFlipInterval(3000);
        vFlipper.setAutoStart(true);

        vFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        vFlipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }


}





