package com.example.crudapi.data.imageListView;

import android.app.ListActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudapi.R;


public class ListViewImageActivity extends ListActivity {
    private ListView listView;
    private String natureNames[] = {
            "India",
            "China",
            "Nepal",
            "United States",
            "South Korea",
            "Indonesia",
            "Japan"
    };

    private String personNames[] = {
            "Monica",
            "Celine",
            "Kay",
            "Caren",
            "Kim",
            "Jake",
            "Mei"


    };

    private Integer imageid[] = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list_view_image );

        // Setting header
        TextView textView = new TextView( this );
        textView.setTypeface( Typeface.DEFAULT_BOLD );
        textView.setText( "List of Countries" );

        ListView listView = findViewById( android.R.id.list );
        listView.addHeaderView( textView );

        // For populating list data
        // For populating list data
        ImageListView imageListView = new ImageListView( this, natureNames, personNames, imageid );
        listView.setAdapter( imageListView );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText( getApplicationContext(), "You Selected " + natureNames[position - 1] + " as Country", Toast.LENGTH_SHORT ).show();
            }
        } );
    }

}