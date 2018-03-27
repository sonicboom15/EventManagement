package ctsstudentclub.sist.com.eventmanagement;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String URL= "http://www.rishikumar.online/event_manager/login.php";

    EditText editUser , editPassword;
    Button btnSignin , btnRegister , btnForgot;

    JSONParser jsonParser = new JSONParser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUser = (EditText) findViewById(R.id.username);
        editPassword = (EditText) findViewById(R.id.password);

        btnForgot = (Button) findViewById(R.id.forgotpass);
        btnSignin = (Button) findViewById(R.id.login);
        btnRegister = (Button) findViewById(R.id.register);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AttemptLogin attemptLogin = new AttemptLogin();
                attemptLogin.execute(editUser.getText().toString(), editPassword.getText().toString());
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent signup = new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(signup);
            }
        });
    }

    private class AttemptLogin extends AsyncTask<String, String, JSONObject>{

        @Override
        protected void onPreExecute(){

            super.onPreExecute();
        }
        @Override
        protected JSONObject doInBackground(String... args) {

            String username = args[0];
            String password = args[1];

            ArrayList params = new ArrayList();
            params.add(new BasicNameValuePair("username", username));
            params.add(new BasicNameValuePair("password",password));
            JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params);

            return json;
        }

        @Override
        protected void onPostExecute(JSONObject result){
            try {
                if (result != null) {
                    Toast.makeText(getApplicationContext(), result.getString("message"), Toast.LENGTH_LONG).show();
                    if (((result.getString("success")).equals("1"))) {
                        Intent i = new Intent(getApplicationContext(), ListActivity.class);
                        startActivity(i);
                    }

                }
            }catch (JSONException e){
                e.printStackTrace();;
            }
        }
    }
}

