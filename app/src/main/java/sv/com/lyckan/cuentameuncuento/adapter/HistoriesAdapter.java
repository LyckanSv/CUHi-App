package sv.com.lyckan.cuentameuncuento.adapter;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sv.com.lyckan.cuentameuncuento.R;
import sv.com.lyckan.cuentameuncuento.databinding.HistoriesResumeMainRowBinding;
import sv.com.lyckan.cuentameuncuento.databinding.RowUserBinding;
import sv.com.lyckan.cuentameuncuento.pojos.Histories;
import sv.com.lyckan.cuentameuncuento.pojos.History;
import sv.com.lyckan.cuentameuncuento.test.User;

public class HistoriesAdapter extends RecyclerView.Adapter<HistoriesAdapter.HistoriesViewHolder> {

    private List<History> items = new ArrayList<>();

    public HistoriesAdapter(List<History> histories){
        items.addAll(histories);
    }


    public class HistoriesViewHolder extends RecyclerView.ViewHolder{
        private HistoriesResumeMainRowBinding binding;

        public HistoriesViewHolder(HistoriesResumeMainRowBinding binding) {
            super(binding.getRoot());
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
    public void onBindViewHolder(HistoriesViewHolder holder, int position) {
        History history = items.get(position);
        holder.bind(history);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
