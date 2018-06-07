package fragments;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import mvc.Login;
import startprogramy.studio.com.startprogramy.R;

import java.util.ArrayList;
import java.util.List;

import classes.Raffle;
import de.hdodenhof.circleimageview.CircleImageView;

public class Sorteios extends Fragment {

    public RecyclerView recyclerView;
    public LinearLayoutManager mLayoutManagerLinear;
    public CustomAdapter adapter;

    public List<Raffle> lSorteio= new ArrayList<>();

    public Sorteios() {}

    public static Sorteios newInstance(int idcid) {
        Sorteios fragment = new Sorteios();
        Bundle args = new Bundle();
        args.putInt("idcid", idcid);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sorteios, container, false);
        final int idcid = getArguments().getInt("idcid");

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_sorteios);

        mLayoutManagerLinear = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManagerLinear);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        lSorteio.add(new Raffle(1,R.mipmap.coca, R.mipmap.sort,"Concorra a todos esses premios.",true));
        lSorteio.add(new Raffle(1,R.mipmap.submarino, R.mipmap.sort2,"Concorra a todos esses premios.",true));
        lSorteio.add(new Raffle(1,R.mipmap.americanas, R.mipmap.sort,"Concorra a todos esses premios.",true));
        lSorteio.add(new Raffle(1,R.mipmap.coca, R.mipmap.sort2,"Concorra a todos esses premios.",true));
        lSorteio.add(new Raffle(1,R.mipmap.submarino, R.mipmap.sort,"Concorra a todos esses premios.",true));
        lSorteio.add(new Raffle(1,R.mipmap.americanas, R.mipmap.sort2,"Concorra a todos esses premios.",true));
        lSorteio.add(new Raffle(1,R.mipmap.coca, R.mipmap.sort,"Concorra a todos esses premios.",true));




        atualizaRecyclerView();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    public void atualizaRecyclerView() {
        adapter = new CustomAdapter(getActivity(),lSorteio);
        recyclerView.setAdapter(adapter);
    }


    /***
     *  Adapter do RecyclerView
     *  ***/
    public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private final List<Raffle> lSorteio;
        private final Context context;

        public CustomAdapter(Context context, List<Raffle> lSorteio) {
            this.context = context;
            this.lSorteio = lSorteio;
        }

        @Override
        public int getItemCount() {
            return this.lSorteio != null ? this.lSorteio.size() : 0;
        }

        @Override
        public int getItemViewType(int position) {
            return 1;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.list_sorteio, viewGroup, false);
            ContratacaoViewHolder holder = new ContratacaoViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
            final Raffle ruffle = lSorteio.get(position);
            ContratacaoViewHolder fholder = (ContratacaoViewHolder) holder;

            fholder.iv_sorteio.setImageResource(ruffle.getImage());
            fholder.civ_sorteio.setImageResource(ruffle.getImageCircle());
            fholder.tv_sorteio.setText(ruffle.getDescription());

            fholder.button_sorteio.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {


                  Intent i = new Intent(getActivity(), Login.class);
                    i.putExtra("COD_CATEGORY", ruffle.getId());
                    getActivity().startActivity(i);
                }
            });
        }

        public class ContratacaoViewHolder extends RecyclerView.ViewHolder {
            private final LinearLayout llGeneralSort;
            private final RelativeLayout rlGeneralSort;
            private final ImageView iv_sorteio;
            private final CircleImageView civ_sorteio;
            private final TextView tv_sorteio;
            private final Button button_sorteio;

            public ContratacaoViewHolder(View itemView) {
                super(itemView);
                llGeneralSort = (LinearLayout) itemView.findViewById(R.id.llGeneralSort);
                rlGeneralSort = (RelativeLayout) itemView.findViewById(R.id.rlGeneralSort);
                iv_sorteio = (ImageView) itemView.findViewById(R.id.iv_sorteio);
                civ_sorteio =(CircleImageView) itemView.findViewById((R.id.civ_sorteio));
                tv_sorteio = (TextView) itemView.findViewById(R.id.tv_sorteio);
                button_sorteio = (Button) itemView.findViewById((R.id.button_sorteio));
            }


        }

        public int converteDpToPx(int dp){
            Resources r = context.getResources();
            return (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    dp,
                    r.getDisplayMetrics()
            );
        }
    }


}