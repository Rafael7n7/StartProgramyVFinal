package startprogramy.studio.com.startprogramy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import classes.Companies;


public class Empresa extends AppCompatActivity {

    public RecyclerView recyclerView;
    public LinearLayoutManager mLayoutManagerLinear;
    public CustomAdapter adapter;

    public List<Companies> lCompanies= new ArrayList<>();

    int codCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);

        codCategory = this.getIntent().getIntExtra("COD_CATEGORY", 0);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_guiaEmpresa);

        mLayoutManagerLinear = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManagerLinear);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);


        lCompanies.add(new Companies(1,"Mão de Vaca", "Restaurante", "998877665", R.mipmap.logomaodevaca));
        lCompanies.add(new Companies(2,"Sirigado do Pedro", "Vendas", "998877665", R.mipmap.sirigado));
        lCompanies.add(new Companies(1,"Mão de Vaca", "Restaurante", "998877665", R.mipmap.logomaodevaca));
        lCompanies.add(new Companies(2,"Sirigado do Pedro", "Vendas", "998877665", R.mipmap.sirigado));
        lCompanies.add(new Companies(1,"Mão de Vaca", "Restaurante", "998877665", R.mipmap.logomaodevaca));
        lCompanies.add(new Companies(2,"Sirigado do Pedro", "Vendas", "998877665", R.mipmap.sirigado));
        lCompanies.add(new Companies(1,"Mão de Vaca", "Restaurante", "998877665", R.mipmap.logomaodevaca));
        lCompanies.add(new Companies(2,"Sirigado do Pedro", "Vendas", "998877665", R.mipmap.sirigado));




        atualizaRecyclerView();
    }

    public void atualizaRecyclerView() {
        adapter = new CustomAdapter(this,lCompanies);
        recyclerView.setAdapter(adapter);
    }



    /***
     *  Adapter do RecyclerView
     *  ***/
    public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private final List<Companies> lCompanies;
        private final Context context;

        public CustomAdapter(Context context, List<Companies> lCompanies) {
            this.context = context;
            this.lCompanies = lCompanies;
        }


        @Override
        public int getItemCount() {
            return this.lCompanies != null ? this.lCompanies.size() : 0;
        }

        @Override
        public int getItemViewType(int position) {
            return 1;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.list_empresas, viewGroup, false);
            CustomAdapter.ContratacaoViewHolder holder = new CustomAdapter.ContratacaoViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
            final Companies companies= lCompanies.get(position);
            CustomAdapter.ContratacaoViewHolder fholder = (CustomAdapter.ContratacaoViewHolder) holder;
            fholder.ivCompany.setImageResource(companies.getImage());
            fholder.tvCompany_Emp.setText(companies.getNameCompany());
            fholder.tvCompany_Desc.setText(companies.getNameDescription());
            fholder.tvCompany_telefone.setText(companies.getPhone());

            fholder.llGeneral_listEmp.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Empresa.this, DetalheEmpresa.class);
                    i.putExtra("COD_CATEGORY", companies.getId());
                    startActivity(i);
                }
            });
        }

        public class ContratacaoViewHolder extends RecyclerView.ViewHolder {
            private final LinearLayout llGeneral_listEmp;
            private final ImageView ivCompany;
            private final TextView tvCompany_Emp, tvCompany_Desc, tvCompany_telefone;

            public ContratacaoViewHolder(View itemView) {
                super(itemView);
                llGeneral_listEmp = (LinearLayout) itemView.findViewById(R.id.llGeneral_listEmp);
                ivCompany = (ImageView) itemView.findViewById(R.id.ivCompany);
                tvCompany_Emp = (TextView) itemView.findViewById(R.id.tvCompany_Emp);
                tvCompany_Desc = (TextView) itemView.findViewById(R.id.tvCompany_Desc);
                tvCompany_telefone = (TextView) itemView.findViewById(R.id.tvCompany_telefone);
            }
        }

       /** public int converteDpToPx(int dp){
            Resources r = context.getResources();
            return (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    dp,
                    r.getDisplayMetrics()
            );
        }**/
    }


}
