package com.jansek.korfbalstats;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CurrentPlayersListAdapter extends ArrayAdapter<Player> {

    private Context mContext;
    int mResource;

    public CurrentPlayersListAdapter(Context context, int resource, ArrayList<Player> currentPlayers) {
        super(context, resource, currentPlayers);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String playerName = getItem(position).getPlayerName();
        String playerSex = getItem(position).getSex();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        if (playerSex == "H") {
            View vSexIndicator = (View) convertView.findViewById(R.id.sex_idicator);
            vSexIndicator.setBackground(mContext.getResources().getDrawable(R.drawable.listview_sex_indicator_male));
        }
        TextView tvPlayerName = (TextView) convertView.findViewById(R.id.playername_textView);
        TextView tvPlayerSex = (TextView) convertView.findViewById(R.id.playerSex_textView);

        tvPlayerName.setText(playerName);
        tvPlayerSex.setText(playerSex);

        return convertView;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }
}
