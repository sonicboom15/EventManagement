package ctsstudentclub.sist.com.eventmanagement;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class SignupActivity extends AppCompatActivity {

    String URL= "http://www.rishikumar.online/event_manager/login.php";

    EditText editName, editdob , editcollege , editdept , editroll , editemail , edityear , editaoi, editphone , editpassword , editconfirm;
    Button register;

    JSONParser jsonParser = new JSONParser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editName = findViewById(R.id.name);
        editdob = findViewById(R.id.dob);
        editcollege = findViewById(R.id.collage);
        editdept = findViewById(R.id.dept);
        editroll = findViewById(R.id.roll);
        editemail = findViewById(R.id.email);
        edityear = findViewById(R.id.year);
        editaoi = findViewById(R.id.phone);
        editphone = findViewById(R.id.phone);
        editpassword = findViewById(R.id.password);
        editconfirm = findViewById(R.id.confirm);


        final Calendar calendar = Calendar.getInstance();


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String format = "MM/dd/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                editdob.setText(
                        sdf.format(calendar.getTime())
                );
            }
        };

        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendDetails senddetails = new SendDetails();
                senddetails.execute(editName.getText().toString(),editdob.getText().toString(),editcollege.getText().toString()
                        ,editdept.getText().toString(),editroll.getText().toString(),editemail.getText().toString()
                        ,edityear.getText().toString(),editaoi.getText().toString(),editphone.getText().toString()
                        ,editpassword.getText().toString(),editconfirm.getText().toString());
            }
        });

        editdob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SignupActivity.this, date, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
    private class SendDetails extends AsyncTask<String,String,JSONObject>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }
        @Override
        protected JSONObject doInBackground(String... args) {

            String name = args[0];
            String dob = args[1];
            String college = args[2];
            String dept = args[3];
            String roll = args[4];
            String email = args[5];
            String year = args[6];
            String aoi = args[7];
            String phone = args[8];
            String password = args[9];
            String confirm = args[10];

            if(password.equals(confirm)) {
                ArrayList params = new ArrayList();
                params.add(new BasicNameValuePair("name", name));
                params.add(new BasicNameValuePair("dob",dob));
                params.add(new BasicNameValuePair("college",college));
                params.add(new BasicNameValuePair("dept",dept));
                params.add(new BasicNameValuePair("roll",roll));
                params.add(new BasicNameValuePair("email",email));
                params.add(new BasicNameValuePair("year",year));
                params.add(new BasicNameValuePair("aoi",aoi));
                params.add(new BasicNameValuePair("phone",phone));
                params.add(new BasicNameValuePair("password", password));
                JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params);
                return json;
            }
            else{
                return null;
            }
        }
        @Override
        protected void onPostExecute(JSONObject result){
            try{
                if(result.equals(null)){
                    Toast.makeText(SignupActivity.this, "Check Password", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
























