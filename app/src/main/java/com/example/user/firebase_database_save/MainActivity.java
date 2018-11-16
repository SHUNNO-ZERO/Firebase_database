package com.example.user.firebase_database_save;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTextnamee;
    Button buttonadd;
    Spinner spinnergenres;
    ListView listViewartists;


    DatabaseReference databaseartist;


    List<artisty> artistyList;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        databaseartist= FirebaseDatabase.getInstance().getReference("artists");

        editTextnamee=findViewById(R.id.editTextname);
        buttonadd=findViewById(R.id.buttonAddartist);
        spinnergenres=findViewById(R.id.spinnerGeneres);
        listViewartists=findViewById(R.id.listviewartists);


        artistyList=new ArrayList<>();



        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addartist();



            }
        });




    }


    @Override
    protected void onStart() {
        super.onStart();


        databaseartist.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



                artistyList.clear();
                for(DataSnapshot artistsnapchat:dataSnapshot.getChildren()){

                    artisty artist=artistsnapchat.getValue(artisty.class);

                    artistyList.add(artist);


                }

               artist_list adapter= new artist_list(MainActivity.this,artistyList);
                listViewartists.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    private void addartist(){

        String name= editTextnamee.getText().toString().trim();
        String genre=spinnergenres.getSelectedItem().toString();



        if(!TextUtils.isEmpty(name)){


           String id=  databaseartist.push().getKey();
           artisty artist= new artisty(id,name,genre );
            databaseartist.child(id).setValue(artist);

            Toast.makeText(this,"artist added",Toast.LENGTH_LONG).show();



        }else {

            Toast.makeText(this,"you should enter a text", Toast.LENGTH_LONG).show();

        }



    }


}
