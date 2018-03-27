package ctsstudentclub.sist.com.eventmanagement;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
        editadd = (EditText)findViewById(R.id.address);

        aoi = (RadioGroup)findViewById(R.id.aoi);

        btnsubmit = (Button)findViewById(R.id.submit);

        GetData getData = new GetData();
        getData.execute(userid);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    int selectedId = aoi.getCheckedRadioButtonId();
                    RadioButton radioButton = (RadioButton) findViewById(selectedId);
                    UpdateAcc updateAcc = new UpdateAcc();
                    updateAcc.execute(editname.getText().toString(), editemail.getText().toString(), editdob.getText().toString(), editadd.getText().toString(),
                            editreg.getText().toString(), radioButton.getText().toString());
            }
        });

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
                    editadd = (EditText)findViewById(R.id.address);

                    editname.setText(result.getString("name"));
                    editemail.setText(result.getString("email"));
                    //editreg.setText(result.getString("reg"));
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
    private class UpdateAcc extends AsyncTask<String , String , JSONObject>{
        @Override
        protected void onPreExecute(){

            super.onPreExecute();
        }

        @Override
        protected JSONObject doInBackground(String... args) {

            Bundle bundle = getIntent().getExtras();

            String id = bundle.getString("user_id");

            String name = args[0],
                    email = args[1],
                    dob = args[2],
                    address = args[3],
                    reg = args[4],
                    aoi = args[5];

            Log.i("Params Recieved","Params Success");

            ArrayList params = new ArrayList();
            params.add(new BasicNameValuePair("name",name));
            params.add(new BasicNameValuePair("email",email));
            params.add(new BasicNameValuePair("dob",dob));
            params.add(new BasicNameValuePair("address",address));
            params.add(new BasicNameValuePair("reg",reg));
            params.add(new BasicNameValuePair("aoi",aoi));
            params.add(new BasicNameValuePair("id",id));
            params.add(new BasicNameValuePair("update","true"));

            Log.i("List","List Success");
            JSONObject json = jsonParser.makeHttpRequest(URL,"POST",params);

            Log.i("POST Request","Posted");

            return json;

        }

        @Override
        protected void onPostExecute(JSONObject result){
            try {
                if (result != null) {
                    Toast.makeText(getApplicationContext(), result.getString("message"), Toast.LENGTH_LONG).show();
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
