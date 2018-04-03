package ctsstudentclub.sist.com.eventmanagement;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class ListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Bundle bundle;

    String userid,role;

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


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if(role.equals("1")) {
            Menu nav_menu = navigationView.getMenu();
            nav_menu.findItem(R.id.nav_approve).setVisible(true);
        }
        navigationView.setNavigationItemSelectedListener(this);

        Toast.makeText(getApplicationContext(),"Role ".concat(role).concat(" User id").concat(userid),Toast.LENGTH_SHORT).show();

        ArrayAdapter<Event> adapter = new ArrayAdapter<>(this,
                android.R.layout.content_list, eventList);
        yourListView.setAdapter(adapter);

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

    @SuppressWarnings("StatementWithEmptyBody")
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
        protected JSONObject doInBackground(String... strings) {
            return null;
        }
        protected void onPostExecute(JSONObject result){
            try {
                if (result != null) {
                    Toast.makeText(getApplicationContext(), result.getString("message"), Toast.LENGTH_LONG).show();
                    if (((result.getString("success")).equals("1"))) {
                        List<Event> eventList = new ArrayList<>();
                        JSONArray events = json
                                .getJSONArray(TAG_COUPONS); // JSON Array
                        for (JSONObject event : (Iterable<JSONObject>) events) {
                            String etext = event.get("etext");
                            String ename = event.get("ename");
                            String userid = event.get("euserid");
                            String sdate = event.get("sdate");
                            String edate = event.get("edate");
                            String addr = event.get("addr");
                            eventList.add(new Event(ename,etext,euserid,sdate,edate,addr));
                        }
                    }

                }
            }catch (JSONException e){
                e.printStackTrace();;
            }
        }
    }
    public class Event {
        private String eventname;
        private String eventtext;
        private String userid;
        private String sdate;
        private String edate;
        private String addr;


        public Coupon(String ename,String etext,String euserid,String sdate,String edate,String addr) {
            eventname = ename;
            eventtext = etext;
            userid = euserid;
            sdate = this.sdate;
            edate = this.edate;
            addr = this.addr;
        }

        public String getEventName() {
            return eventname;
        }
        public String getEventText() {
            return eventtext;
        }
        public String getUserid() {
            return userid;
        }
        public String getSdate() {
            return sdate;
        }
        public String getEdate(){
            return edate;
        }
        public String getAddr(){
            return addr;
        }
    }
}
