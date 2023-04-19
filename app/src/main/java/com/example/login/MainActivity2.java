package com.example.login;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.json.JSONObject;

public class MainActivity2 extends AppCompatActivity {
    private TextView textView;
    Button fragment1,fragment2,fragment3,fragment4;
    TextView textView_username,textView_password;
    Button btnLogout;
    Button btncontinue;


    SharedPreferences sharedPreferences;

    private Button btnbottomsheet1;
    private BottomSheetDialog bottomSheetDialog;
    Button btncustomalert1;


    private static final String SHARED_PREF_NAME="mypref";
    private static final String SHARED_PREF_USERNAME="name";
    private static final String SHARED_PREF_PASs="password";



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        textView_username = findViewById(R.id.usernames);
        textView_password = findViewById(R.id.Password);
        btnLogout = findViewById(R.id.logut);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String Usernames = sharedPreferences.getString(SHARED_PREF_USERNAME, null);
        String password = sharedPreferences.getString(SHARED_PREF_PASs, null);
        if (Usernames != null || password != null) {
            textView_username.setText("fullname -" + Usernames);
            textView_password.setText("password -" + password);
        }
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(MainActivity2.this, "logout successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


        textView = findViewById(R.id.login1);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String Username = bundle.getString("lahari");
            // textView.setText(Username);
        }

        fragment1 = findViewById(R.id.button1);
        fragment2 = findViewById(R.id.button2);
        fragment3 = findViewById(R.id.button3);
        fragment4=findViewById(R.id.btnrecycler);
        fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new frag1());
            }
        });
        fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new frag2());
            }
        });
        fragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new frag3());
            }
        });
        fragment4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer,new fragRecyclerview()).commit();

            }
        });
        btnbottomsheet1=findViewById(R.id.bottombutton);
        btnbottomsheet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog= new BottomSheetDialog(MainActivity2.this,R.style.Bottomsheettheme);
                View sheetview = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottomsheet,null);
                sheetview.findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity2.this, "share is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                sheetview.findViewById(R.id.location).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity2.this, "location is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                sheetview.findViewById(R.id.comment).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity2.this, "comment is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                sheetview.findViewById(R.id.message1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity2.this, "message is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                sheetview.findViewById(R.id.programming).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity2.this, "programming is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                sheetview.findViewById(R.id.getlink).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity2.this, "get the link is clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                bottomSheetDialog.setContentView(sheetview);
                bottomSheetDialog.show();
            }
        });
        btncustomalert1=findViewById(R.id.custombutton);
        btncustomalert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(MainActivity2.this);
                builder.setTitle("Alert");
                builder.setMessage("alert box");
                builder.setCancelable(false);
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity2.this, "Good job", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity2.this, "exit", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });
                android.app.AlertDialog dialog = builder.create();
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        dialog.getWindow().setBackgroundDrawableResource(R.color.red);

                    }
                });
                builder.show();

            }
        });
        TextView tv=(TextView)  findViewById(R.id.hello);
        String url ="https://reqres.in/api/users/2";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                tv.setText(response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv.setText("error ");
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);



    }


    public void showAlertDialog(View view) {
        btncontinue = findViewById(R.id.continues);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);


        alert.setTitle("Android Studio");
        alert.setMessage("Do you want continue?");
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity2.this, "Good job", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity2.this, "EXIT", Toast.LENGTH_SHORT).show();
            }
        });
    alert.create().show();

    }


    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.buttonLay,fragment);
        fragmentTransaction.commit();
    }
}