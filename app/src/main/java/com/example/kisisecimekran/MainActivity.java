package com.example.kisisecimekran;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.Manifest;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private static final String TAG="CUSTONLISTVIEW";
    private ArrayList<Person> persons;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private PersonRecyclerAdapter personRecyclerAdapter;
    public static final int REQUEST_READ_CONTACTS=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)==
                PackageManager.PERMISSION_GRANTED)
        {
            getAllContacts();
        }
        else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},REQUEST_READ_CONTACTS);
        }
    }

    private void getAllContacts() {
    }

    private void viewSettings() {
        recyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        personRecyclerAdapter=new PersonRecyclerAdapter(persons);
        recyclerView.setAdapter(personRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        MenuItem searchItem=menu.findItem(R.id.app_bar_search);
        SearchView searchView=(SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        ArrayList<Person> newPersons=new ArrayList<>();
        for(Person person:persons){
            if(person.getName().toLowerCase(Locale.ROOT).contains(newText.toLowerCase(Locale.ROOT)));
            newPersons.add(person);
        }
        personRecyclerAdapter.setPersons(newPersons);
        personRecyclerAdapter.notifyDataSetChanged();
        return true;
    }
}