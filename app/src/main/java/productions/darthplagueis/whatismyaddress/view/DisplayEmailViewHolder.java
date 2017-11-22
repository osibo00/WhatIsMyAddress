package productions.darthplagueis.whatismyaddress.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import productions.darthplagueis.whatismyaddress.DisplayActivity;
import productions.darthplagueis.whatismyaddress.R;
import productions.darthplagueis.whatismyaddress.model.EmailDisplay;

/**
 * Created by oleg on 11/21/17.
 */

public class DisplayEmailViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;
    private final Context context;

    public DisplayEmailViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.recycler_textview);
        context = itemView.getContext();
    }

    public void onBind(EmailDisplay emailDisplay) {
        textView.setText(emailDisplay.getEmail());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DisplayActivity.class);
                intent.putExtra("displaytext", textView.getText().toString());
                context.startActivity(intent);
            }
        });
    }
}
