package com.example.crudapi.navigation;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.crudapi.R;
import com.example.crudapi.data.imageListView.ImageListView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MoviesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoviesFragment extends ListFragment {
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
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MoviesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MovieFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoviesFragment newInstance(String param1, String param2) {
        MoviesFragment fragment = new MoviesFragment();
        Bundle args = new Bundle();
        args.putString( ARG_PARAM1, param1 );
        args.putString( ARG_PARAM2, param2 );
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (getArguments() != null) {
            mParam1 = getArguments().getString( ARG_PARAM1 );
            mParam2 = getArguments().getString( ARG_PARAM2 );
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_movie, container, false );
        initView (view);
        return view;
    }

    private void initView(View view) {
        // Setting header
        TextView textView = new TextView( getActivity() );
        textView.setTypeface( Typeface.DEFAULT_BOLD );
        textView.setText( "List of Countries" );

        ListView listView = view.findViewById( android.R.id.list );
        listView.addHeaderView( textView );

        // For populating list data
        // For populating list data
        ImageListView imageListView = new ImageListView( getActivity(), natureNames, personNames, imageid );
        listView.setAdapter( imageListView );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText( getActivity(), "You Selected " + natureNames[position - 1] + " as Country", Toast.LENGTH_SHORT ).show();
            }
        } );
    }
}