package xyz.vukovicc.alacritysms.views.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import xyz.vukovicc.alacritysms.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Matej on 12/3/2016.
 */

public class CommonRecycleAdapter extends RecyclerView.Adapter<CommonRecycleAdapter.ViewHolder> {

    private List<String> itemsData;

    public CommonRecycleAdapter(List<String> itemsData) {
        this.itemsData = itemsData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text) TextView textView;

        public ViewHolder (View itemLayoutView){
            super(itemLayoutView);
            ButterKnife.bind(this, itemLayoutView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater
                .from(parent.getContext()).inflate(R.layout.recycle_vew_common_items, null);
        ViewHolder vh = new ViewHolder(itemLayoutView);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(itemsData.get(position));

    }

    @Override
    public int getItemCount() {
        return itemsData.size();
    }

}
