package zine.co.in;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Register extends Fragment {


    Button b;
    TextView txt;
    EditText txt1, txt2, txt3, txt4;
    Spinner hostel1, branch1;
    String id, name, email, number, hostel, branch,idc;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.register, container, false);

    }
    public void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {



        final View vt = super.getView();
        assert vt != null;
        txt =  vt.findViewById(R.id.uid);
        txt1 =  vt.findViewById(R.id.editText1);
        txt2 =  vt.findViewById(R.id.editText2);
        txt3 =  vt.findViewById(R.id.editText3);
        txt4 =  vt.findViewById(R.id.editText4);
        hostel1 =  vt.findViewById(R.id.spinner1);
        branch1 =  vt.findViewById(R.id.spinner2);
        b = vt.findViewById(R.id.bt1);


        final RequestQueue requestQueue;
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(getContext(), R.style.MyAlertDiallogStyle);
        // final String HttpUrl = "https://testzineapp.000webhostapp.com/insert_record.php";
        final String HttpUrl = "http://zine.co.in/insert2k18.php";


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vt) {
                View focusView = null;

                id = txt1.getText().toString().trim();
                name = txt2.getText().toString().trim();
                number = txt3.getText().toString().trim();
                email = txt4.getText().toString().trim();
                hostel = hostel1.getSelectedItem().toString().trim();
                branch = branch1.getSelectedItem().toString().trim();
                idc=id.toLowerCase();

                if (id.isEmpty()) {
                   // txt.setText("College ID not entered");
                    //txt1.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
                    txt1.setError("College ID empty!");
                    focusView=txt1;
                    focusView.requestFocus();
                } else if (!((idc.length() == 11 && (idc.startsWith("2018u")||idc.startsWith("2017u")))||(idc.length() == 12 && (idc.startsWith("2018ku")||idc.startsWith("2017ku"))) )) {
                    txt1.setError("College ID incorrect!");
                    focusView=txt1;
                    focusView.requestFocus();
                } else if (name.isEmpty()) {
                    txt2.setError("Name empty!");
                    focusView=txt2;
                    focusView.requestFocus();
                } else if (number.isEmpty()) {
                    txt3.setError("Mobile Number empty!");
                    focusView=txt3;
                    focusView.requestFocus();
                } else if (number.length() != 10) {
                    txt3.setError("Mobile Number incorrect!");
                    focusView=txt3;
                    focusView.requestFocus();
                } else if (email.isEmpty()) {
                    txt4.setError("Email empty!");
                    focusView=txt4;
                    focusView.requestFocus();
                } else if (email.indexOf('@') < 0 || email.indexOf('.') < 0) {
                    txt4.setError("Email incorrect!");
                    focusView=txt4;
                    focusView.requestFocus();
                } else {
                    progressDialog.setMessage("Please Wait, Registering");
                    progressDialog.show();
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String ServerResponse) {

                                    // Showing response message coming from server.
                                    progressDialog.dismiss();
                                    //Toast.makeText(getContext(), ServerResponse, Toast.LENGTH_LONG).show();
                                    txt.setText(ServerResponse);

                                    /*  try {
                                     JSONArray j= new JSONArray(ServerResponse);
                                     txt.setText("ID : "+j.getJSONObject(0).getString("id"));
                                     } catch (JSONException e) {
                                     e.printStackTrace();
                                     }
                                     */

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError volleyError) {

                                    // Showing error message if something goes wrong.
                                    progressDialog.dismiss();
                                    txt.setText("Connection Problem, Try Again");
                                    Toast.makeText(getContext(), "Connection Problem, Try Again", Toast.LENGTH_LONG).show();
                                }
                            }) {
                        @Override
                        protected Map<String, String> getParams() {

                            // Creating Map String Params.
                            Map<String, String> params = new HashMap<String, String>();

                            // Adding All values to Params.
                            params.put("College_ID", id);
                            params.put("Name", name);
                            params.put("Mobile_Number", number);
                            params.put("Email_ID", email);
                            params.put("Hosteller", hostel);
                            params.put("Branch", branch);

                            return params;
                        }

                    };
                    stringRequest.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                    // Creating RequestQueue.
                    RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));

                    // Adding the StringRequest object into requestQueue.
                    requestQueue.add(stringRequest);
                    txt1.setText("");
                    txt2.setText("");
                    txt3.setText("");
                    txt4.setText("");



                }
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }


}