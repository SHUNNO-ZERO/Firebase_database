package com.example.user.firebase_database_save;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class artist_list extends ArrayAdapter<artisty> {

    private Activity context;
    private List<artisty> artistlistt;


    public artist_list(Activity context,List<artisty>artistlistt){
        super(context,R.layout.list_layout,artistlistt);


        this.context=context;
        this.artistlistt=artistlistt;






    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();

        View listviewitem=inflater.inflate(R.layout.list_layout,null,true);

        TextView  textviewname=(TextView) listviewitem.findViewById(R.id.textViewname);
        TextView  texviewgenre=(TextView) listviewitem.findViewById(R.id.textViewgenre);

         artisty artisty=  artistlistt.get(position);

         textviewname.setText(artisty.getArtistname());
         texviewgenre.setText(artisty.getArtistgenre());

         return listviewitem;







    }
}
