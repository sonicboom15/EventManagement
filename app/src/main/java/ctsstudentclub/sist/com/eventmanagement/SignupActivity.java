package ctsstudentclub.sist.com.eventmanagement;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SignupActivity extends AppCompatActivity {

    EditText editname = (EditText)findViewById(R.id.name),
            editemail = (EditText)findViewById(R.id.email),
            editdob = (EditText)findViewById(R.id.dob),
            editreg = (EditText)findViewById(R.id.regno),
            editphno = (EditText)findViewById(R.id.contactnumber),
            editadd = (EditText)findViewById(R.id.address),
            editpass = (EditText)findViewById(R.id.password),
            editcpass = (EditText)findViewById(R.id.cpassword);

    RadioButton technical = (RadioButton)findViewById(R.id.tech),
            nontech = (RadioButton)findViewById(R.id.nontech);

    Button btnsubmit = (Button)findViewById(R.id.submit);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editpass.getText().toString().equals(editcpass.getText().toString())) {
                    AttemptSignUp attemptSignUp = new AttemptSignUp();
                    attemptSignUp.execute(editname.getText().toString(), editemail.getText().toString(), editdob.getText().toString(), editadd.getText().toString(),
                            editphno.getText().toString(), editreg.getText().toString(), editpass.getText().toString());
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
                    pass = args[6];

        }
    }
}
