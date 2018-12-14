package com.example.emergencyphone.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.emergencyphone.R;
import com.example.emergencyphone.model.TeaItem;

import java.util.List;

public class TeaListAdapter extends ArrayAdapter<TeaItem> {

    private Context mContext;
    private int mResource;
    private List<TeaItem> mTeaItemList;

    public TeaListAdapter(@NonNull Context context,
                          int resource,
                          @NonNull List<TeaItem> teaItemList) {
        super(context, resource, teaItemList);
        this.mContext = context;
        this.mResource = resource;
        this.mTeaItemList = teaItemList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResource, parent, false);

        TextView titleTextView = view.findViewById(R.id.title_text_view);
        TextView numberTextView = view.findViewById(R.id.number_text_view);
        TextView locationTextView = view.findViewById(R.id.location_edit_text);



        TeaItem teaItem = mTeaItemList.get(position);
        String title = teaItem.title;
        String number = teaItem.number;
        String location = teaItem.location;

        titleTextView.setText(title);
        numberTextView.setText(number);
        locationTextView.setText(location);

        AssetManager am = mContext.getAssets();


        return view;
    }
}
