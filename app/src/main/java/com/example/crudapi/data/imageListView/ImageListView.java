package com.example.crudapi.data.imageListView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.crudapi.R;

public class ImageListView extends ArrayAdapter {
    private String[] countryNames;
    private String[] capitalNames;
    private Integer[] imageid;
    private Activity context;

    public ImageListView(Activity context, String[] countryNames, String[] capitalNames, Integer[] imageid) {
        super( context, R.layout.row_item, countryNames );
        this.context = context;
        this.countryNames = countryNames;
        this.capitalNames = capitalNames;
        this.imageid = imageid;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.row_item, null, true);
        TextView textViewCountry = (TextView) row.findViewById( R.id.textViewNature );
        TextView textViewCapital = (TextView) row.findViewById( R.id.textViewName );
        ImageView imageFlag = (ImageView) row.findViewById( R.id.imageView );

        textViewCountry.setText( countryNames[position] );
        textViewCapital.setText( capitalNames[position] );
        imageFlag.setImageResource( imageid[position] );
        return row;
    }
}