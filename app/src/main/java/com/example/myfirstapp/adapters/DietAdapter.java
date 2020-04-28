package com.example.myfirstapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myfirstapp.Diet;
import com.example.myfirstapp.R;

import java.util.ArrayList;

public class DietAdapter extends RecyclerView.Adapter<DietAdapter.DietHolder> {


    private Context context;
    private ArrayList<Diet> diets;

    public DietAdapter(Context context, ArrayList<Diet> diets) {
        this.context = context;
        this.diets = diets;
    }

    @NonNull
    @Override
    public DietHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.diet_item, parent, false);
        return new DietHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DietHolder holder, int position) {
        Diet diet = diets.get(position);
        holder.setInfo(diet);
    }

    @Override
    public int getItemCount() {
        return diets.size();
    }



    class DietHolder extends RecyclerView.ViewHolder {

        private TextView title, desc, link;
        public DietHolder (View v) {
            super(v);
            title = v.findViewById(R.id.diet_itemTitle);
            desc = v.findViewById(R.id.diet_description);
            link = v.findViewById(R.id.learn_more);
        }


        /* Sets info */
        public void setInfo (Diet diet) {
            title.setText(diet.getTitle());
            desc.setText(diet.getDescription());
            link.setText(Html.fromHtml(diet.getLink()));
            link.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }


}
