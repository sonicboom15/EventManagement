package ctsstudentclub.sist.com.eventmanagement;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class SignupActivity extends AppCompatActivity {

    String URL = "http://www.rishikumar.online/event_manager/signup.php";

    JSONParser jsonParser = new JSONParser();

    EditText editname, editemail, editdob, editreg, editphno, editadd, editpass, editcpass;

    RadioGroup aoi;

    Button btnsubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editname = (EditText)findViewById(R.id.name);
        editemail = (EditText)findViewById(R.id.email);
        editdob = (EditText)findViewById(R.id.dob);
        editreg = (EditText)findViewById(R.id.regno);
        editphno = (EditText)findViewById(R.id.contactnumber);
        editadd = (EditText)findViewById(R.id.address);
        editpass = (EditText)findViewById(R.id.password);
        editcpass = (EditText)findViewById(R.id.cpassword);

        aoi = (RadioGroup)findViewById(R.id.aoi);

        btnsubmit = (Button)findViewById(R.id.submit);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editpass.getText().toString().equals(editcpass.getText().toString())) {
                    int selectedId = aoi.getCheckedRadioButtonId();
                    RadioButton radioButton = (RadioButton) findViewById(selectedId);
                    AttemptSignUp attemptSignUp = new AttemptSignUp();
                    attemptSignUp.execute(editname.getText().toString(), editemail.getText().toString(), editdob.getText().toString(), editadd.getText().toString(),
                            editphno.getText().toString(), editreg.getText().toString(), editpass.getText().toString(), radioButton.getText().toString());
                }else {
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private class AttemptSignUp extends AsyncTask<String , String , JSONObject>{
        @Override
        protected void onPreExecute(){

            super.onPreExecute();
        }

        @Override
        protected JSONObject doInBackground(String... args) {

            String name = args[0],
                    email = args[1],
                    dob = args[2],
                    address = args[3],
                    phno = args[4],
                    reg = args[5],
                    pass = args[6],
                    aoi = args[7];

            Log.i("Params Recieved","Params Success");

            ArrayList params = new ArrayList();
            params.add(new BasicNameValuePair("name",name));
            params.add(new BasicNameValuePair("email",email));
            params.add(new BasicNameValuePair("dob",dob));
            params.add(new BasicNameValuePair("address",address));
            params.add(new BasicNameValuePair("phno",phno));
            params.add(new BasicNameValuePair("reg",reg));
            params.add(new BasicNameValuePair("password",pass));
            params.add(new BasicNameValuePair("aoi",aoi));

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
                    if (((result.getString("success")).equals("1"))) {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
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
