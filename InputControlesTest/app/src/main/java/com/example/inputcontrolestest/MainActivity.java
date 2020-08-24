package com.example.inputcontrolestest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_mobile,et_email,et_password;
    TextView tv;
    RadioButton r_female,r_male;

    String gender;

    CheckBox ch_java,ch_android,ch_python;

    Spinner sp;

    String selectedBranch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.nameEditText);
        et_mobile = findViewById(R.id.mobileEdittext);
        et_email = findViewById(R.id.emailEditText);
        et_password = findViewById(R.id.passwordEditText);
        r_male = findViewById(R.id.maleRadioButton);
        r_female = findViewById(R.id.femaleRadioButton);
        ch_java = findViewById(R.id.javaCheckbox);
        ch_android = findViewById(R.id.androidCheckbox);
        ch_python = findViewById(R.id.pythonCheckbox);
        sp = findViewById(R.id.branchesSpinner);
        tv = findViewById(R.id.dataTextView);
    }

    public void submit(View view) {
        String name = et_name.getText().toString();
        String mobile = et_mobile.getText().toString();
        String email = et_email.getText().toString();
        String pass = et_password.getText().toString();
       /* if(name.isEmpty() || mobile.isEmpty()||email.isEmpty()||pass.isEmpty()){
            Toast.makeText(this, "Please enter the values", Toast.LENGTH_SHORT).show();

        }*/

        if(r_male.isChecked()){
            gender = r_male.getText().toString();
        }

        if(r_female.isChecked()){
            gender = r_female.getText().toString();
        }

        StringBuilder builder=new StringBuilder();
        if(ch_java.isChecked()){
            builder.append(ch_java.getText().toString()+",");
        }

        if(ch_android.isChecked()){
            builder.append(ch_android.getText().toString()+",");
        }
        if(ch_python.isChecked()){
            builder.append(ch_python.getText().toString());
        }

        if(sp.getSelectedItemPosition()==0){
            Toast.makeText(this, "Please select the branch", Toast.LENGTH_SHORT).show();
        }else{
            selectedBranch = sp.getSelectedItem().toString();
        }


        tv.setText(name+"\n"+mobile+"\n"+email+"\n"+pass+"\n"+gender+"\n"+builder+"\n"+selectedBranch);



    }
}