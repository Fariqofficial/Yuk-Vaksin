package it.pradita.ac.yukvaksin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.pradita.ac.yukvaksin.R;
import it.pradita.ac.yukvaksin.model.Data;

public class ListPendaftarAdapter extends RecyclerView.Adapter<ListPendaftarAdapter.ViewHolder> {

    private Context context;
    private List<Data> dataList;

    public ListPendaftarAdapter(Context context, List<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_peserta_vaksin, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data data = dataList.get(position);
        holder.tv_nama.setText(data.getNama());
        holder.tv_umur.setText(String.valueOf(data.getUmur()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nama, tv_umur;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_nama = itemView.findViewById(R.id.namaPeserta);
            tv_umur = itemView.findViewById(R.id.umurPeserta);

        }
    }
}
