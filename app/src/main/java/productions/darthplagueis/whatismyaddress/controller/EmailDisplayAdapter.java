package productions.darthplagueis.whatismyaddress.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import productions.darthplagueis.whatismyaddress.R;
import productions.darthplagueis.whatismyaddress.model.EmailDisplay;
import productions.darthplagueis.whatismyaddress.view.DisplayEmailViewHolder;

/**
 * Created by oleg on 11/21/17.
 */

public class EmailDisplayAdapter extends RecyclerView.Adapter<DisplayEmailViewHolder> {

    private List<EmailDisplay> emailDisplayList;

    public EmailDisplayAdapter(List<EmailDisplay> emailDisplayList) {
        this.emailDisplayList = emailDisplayList;
    }

    @Override
    public DisplayEmailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_itemview, parent, false);
        return new DisplayEmailViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(DisplayEmailViewHolder holder, int position) {
        EmailDisplay emailDisplay = emailDisplayList.get(position);
        holder.onBind(emailDisplay);
    }

    @Override
    public int getItemCount() {
        return emailDisplayList.size();
    }
}
