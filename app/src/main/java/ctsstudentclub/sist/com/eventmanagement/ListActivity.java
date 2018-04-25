package ctsstudentclub.sist.com.eventmanagement;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Bundle bundle;
    ListView listView;
    List<Event> eventlist;
    String userid,role;
    JSONParser jsonParser;
    String URL = "rishikumar.online/event_manager/api.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        bundle = getIntent().getExtras();

        userid = bundle.getString("user_id");
        role = bundle.getString("role");

        listView = (ListView) findViewById(R.id.listView);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if(role.equals("1")) {
            Menu nav_menu = navigationView.getMenu();
            nav_menu.findItem(R.id.nav_approve).setVisible(true);
        }
        navigationView.setNavigationItemSelectedListener(this);

        Toast.makeText(getApplicationContext(),"Role ".concat(role).concat(" User id").concat(userid),Toast.LENGTH_SHORT).show();


        UpdateList updateList = new UpdateList();
        updateList.execute();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBod" +
            "y")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        bundle = getIntent().getExtras();

        int id = item.getItemId();

        if (id == R.id.nav_wishlist) {
            Toast.makeText(getApplicationContext(),"Wishlist Clicked",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_addevent) {
            Toast.makeText(getApplicationContext(),"Add Event Clicked",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_events) {
            Toast.makeText(getApplicationContext(),"Edit Event Clicked",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_unapprovedevents) {
            Toast.makeText(getApplicationContext(),"View Unapproved Clicked",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_manage) {
            Intent ea = new Intent(getApplicationContext(),EaccountActivity.class);
            ea.putExtras(bundle);
            startActivity(ea);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private class UpdateList extends AsyncTask<String , String , JSONObject> {

        @Override
        protected void onPreExecute(){

            super.onPreExecute();
        }

        @Override
        protected JSONObject doInBackground(String... args) {
                String needdata = new String("1");

                ArrayList params = new ArrayList();
                params.add(new BasicNameValuePair("needdata", needdata));

            JSONObject result = jsonParser.makeHttpRequest(URL, "POST", params);

            return result;
        }
        protected void onPostExecute(JSONObject result){
            try {
                Log.i("Json", result.getString("event_name"));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    class EventAdapter extends ArrayAdapter<Event>{
        List<Event> eventList;

        public EventAdapter(List<Event> eventList){
            super(ListActivity.this, R.layout.layout_event_list, eventList);
            this.eventList = eventList;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = getLayoutInflater();
            View listViewItem = inflater.inflate(R.layout.layout_event_list, null, true);

            TextView textViewName = listViewItem.findViewById(R.id.textViewName);

            final Event event = eventList.get(position);

            textViewName.setText(event.getEventname());
            return listViewItem;
        }
    }
}
