package xyz.vukovicc.alacritysms.views.adapters;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.vukovicc.alacritysms.R;
import xyz.vukovicc.alacritysms.data.Trigger;

 /* Created by matha on 2/4/17.*/


public class TriggerListAdapter extends RecyclerView.Adapter<TriggerListAdapter.ViewHolder> {

    List<Trigger> triggers;

    public TriggerListAdapter(List<Trigger> triggers) {
        this.triggers = triggers;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.trigger_list_title)
        TextView title;
        @BindView(R.id.trigger_list_subtitle)
        TextView subtitle;
        @BindView(R.id.trigger_list_fab_edit)
        FloatingActionButton editTrigger;
        @BindView(R.id.trigger_list_fab_remove)
        FloatingActionButton removeTrigger;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_view_trigger_items, null);
        ViewHolder vh = new ViewHolder(itemView);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Trigger currentTrigger = triggers.get(position);
        holder.title.setText(currentTrigger.getAlias().equals(null) ? currentTrigger.getEmail()
                : currentTrigger.getAlias());
        holder.subtitle.setText("H: "+currentTrigger.getEmailHost() + "PR: "+ currentTrigger.getEmailProtocol());

        holder.editTrigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TRIGGER-OVERVIEW", "Edit trigger pressed");
            }
        });

        holder.removeTrigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TRIGGER-OVERVIEW", "Removetrigger pressed");
            }
        });
    }

    @Override
    public int getItemCount() {
        return triggers.size();
    }
}


