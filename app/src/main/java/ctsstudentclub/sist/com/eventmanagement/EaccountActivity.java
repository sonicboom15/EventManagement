package ctsstudentclub.sist.com.eventmanagement;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EaccountActivity extends AppCompatActivity {

    String URL = "http://www.rishikumar.online/event_manager/getdata.php";

    JSONParser jsonParser = new JSONParser();

    EditText editname, editemail, editdob, editreg, editphno, editadd, editpass, editcpass;

    RadioGroup aoi;

    Button btnsubmit;

    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eaccount);

        Bundle bundle = getIntent().getExtras();

        String userid = bundle.getString("user_id");

        editname = (EditText)findViewById(R.id.name);
        editemail = (EditText)findViewById(R.id.email);
        editdob = (EditText)findViewById(R.id.dob);
        editreg = (EditText)findViewById(R.id.regno);
        editphno = (EditText)findViewById(R.id.contactnumber);
        editadd = (EditText)findViewById(R.id.address);

        aoi = (RadioGroup)findViewById(R.id.aoi);

        btnsubmit = (Button)findViewById(R.id.submit);

        GetData getData = new GetData();
        getData.execute(userid);

    }
    private class GetData extends AsyncTask<String,String,JSONObject>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }
        @Override
        protected JSONObject doInBackground(String... args) {
            String userid = args[0];
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("id",userid));
            JSONObject json = jsonParser.makeHttpRequest(URL,"POST",arrayList);
            return json;
        }
        @Override
        protected void onPostExecute(JSONObject result){
            try {
                if (result != null) {
                    editname = (EditText)findViewById(R.id.name);
                    editemail = (EditText)findViewById(R.id.email);
                    editdob = (EditText)findViewById(R.id.dob);
                    editreg = (EditText)findViewById(R.id.regno);
                    editphno = (EditText)findViewById(R.id.contactnumber);
                    editadd = (EditText)findViewById(R.id.address);

                    editname.setText(result.getString("name"));
                    editemail.setText(result.getString("email"));
                    //editreg.setText(result.getString("reg"));
                    editphno.setText(result.getString("phno"));
                    editadd.setText(result.getString("address"));

                }
                else{
                    Toast.makeText(getApplicationContext(),"Unable to Retrive data from the server",Toast.LENGTH_SHORT).show();
                }
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
    }
}
