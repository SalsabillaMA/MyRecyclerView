package id.sch.smktelkom.www.myrecyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import id.sch.smktelkom.www.myrecyclerview.R;
import id.sch.smktelkom.www.myrecyclerview.model.Animal;

public class CardViewAnimalAdapter extends RecyclerView.Adapter<CardViewAnimalAdapter.CardViewViewHolder> {
    private ArrayList<Animal> listAnimal;

    public CardViewAnimalAdapter(ArrayList<Animal> list) {
        this.listAnimal = list;
    }


    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_animal, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        Animal animal = listAnimal.get(position);
        Glide.with(holder.itemView.getContext())
                .load(animal.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvName.setText(animal.getName());
        holder.tvFrom.setText(animal.getDetail());
        holder.btnFavorite.setOnClickListener(new
                                                      View.OnClickListener() {
                                                          @Override
                                                          public void onClick(View v) {
                                                              Toast.makeText(holder.itemView.getContext(), "Favorite " +
                                                                      listAnimal.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                                                          }
                                                      });

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(),
                        "Share " + listAnimal.get(holder.getAdapterPosition()).getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Kamu" +
                                "memilih " + listAnimal.get(holder.getAdapterPosition()).getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listAnimal.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvFrom;
        Button btnFavorite, btnShare;

        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_detail);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }

    }
}