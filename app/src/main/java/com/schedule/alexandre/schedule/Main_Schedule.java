package com.schedule.alexandre.schedule;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main_Schedule extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private List<String> parentHeaderInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentHeaderInformation = new ArrayList<String>();
        parentHeaderInformation.add("Lundi");
        parentHeaderInformation.add("Mardi");
        parentHeaderInformation.add("Mercredi");
        parentHeaderInformation.add("Jeudi");
        parentHeaderInformation.add("Vendredi");
        parentHeaderInformation.add("Samedi");
        parentHeaderInformation.add("Dimanche");


        HashMap<String, List<String>> allChildItems = returnGroupedChildItems();
        expandableListView = (ExpandableListView)findViewById(R.id.expandableListView);
        ExpandableListViewAdapter expandableListViewAdapter = new ExpandableListViewAdapter(getApplicationContext(), parentHeaderInformation, allChildItems);

        expandableListView.setAdapter(expandableListViewAdapter);
    }
    private HashMap<String, List<String>> returnGroupedChildItems(){

        HashMap<String, List<String>> childContent = new HashMap<String, List<String>>();

        List<String> lundi = new ArrayList<String>();
        lundi.add("lundi");


        List<String> mardi = new ArrayList<String>();
        mardi.add("mardi");


        List<String> mercredi = new ArrayList<String>();
        mercredi.add("mercredi");


        List<String> jeudi = new ArrayList<String>();
        jeudi.add("jeudi");


        List<String> vendredi = new ArrayList<String>();
        vendredi.add("vendredi");


        List<String> samedi = new ArrayList<String>();
        samedi.add("samedi");


        List<String> dimanche = new ArrayList<String>();
        dimanche.add("dimanche");


        childContent.put(parentHeaderInformation.get(0), lundi);
        childContent.put(parentHeaderInformation.get(1), mardi);
        childContent.put(parentHeaderInformation.get(2), mercredi);
        childContent.put(parentHeaderInformation.get(3), jeudi);
        childContent.put(parentHeaderInformation.get(4), vendredi);
        childContent.put(parentHeaderInformation.get(5), samedi);
        childContent.put(parentHeaderInformation.get(6), dimanche);

        return childContent;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main__schedule, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
