package sv.com.lyckan.cuentameuncuento.adapter;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import sv.com.lyckan.cuentameuncuento.R;
import sv.com.lyckan.cuentameuncuento.ReadFragmentActivity;
import sv.com.lyckan.cuentameuncuento.databinding.HistoriesResumeMainRowBinding;

import sv.com.lyckan.cuentameuncuento.pojos.History;


public class HistoriesAdapter extends RecyclerView.Adapter<HistoriesAdapter.HistoriesViewHolder> {

    private List<History> items = new ArrayList<>();
    Context context;

    public HistoriesAdapter(List<History> histories, Context context){
        items.addAll(histories);
        this.context = context;
    }


    public class HistoriesViewHolder extends RecyclerView.ViewHolder{
        private HistoriesResumeMainRowBinding binding;

        public HistoriesViewHolder(HistoriesResumeMainRowBinding binding) {
            super(binding.getRoot());
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("Adapter", "ok");
                }
            });
            this.binding = binding;
        }

        public void bind(History history){
            binding.setHistory(history);
            binding.executePendingBindings();
        }

    }

    @Override
    public HistoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        HistoriesResumeMainRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.histories_resume_main_row,parent, false );
        return new HistoriesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final HistoriesViewHolder holder, final int position) {
        History history = items.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(context, ReadFragmentActivity.class);
                intent.putExtra("parametro", items.get(position));


                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity) context, (View)holder.binding.imageView2, "profile");

                context.startActivity(intent, options.toBundle());
            }
        });
        holder.bind(history);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }




}
