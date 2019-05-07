package bookpeon.cutprice.com.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;

import bookpeon.cutprice.com.MainActivity;
import bookpeon.cutprice.com.R;

import bookpeon.cutprice.com.network.NetworkManager;
import bookpeon.cutprice.com.statusbar.StatusBarUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static bookpeon.cutprice.com.util.CommonContents.FONT_EXTRA_BOLD_PATH;



public class ActivityLoginInAndSignUp extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = ActivityLoginInAndSignUp.class.getSimpleName();

    /**------------------------------------------------------------------------------------------------
     * Start Block - Private Variables
     **------------------------------------------------------------------------------------------------*/
    private Context context;
    private ImageView iv_back;
    private TextView txtTitleLeft,txtTitleRight,txtForgetPassword;
    ProgressDialog progressDialog ;
    private EditText edtLoginEmail,edtLoginPass,edtRegUsername,edtRegEmail,edtRegPass,edtRegConfirmPass;
    private CheckBox checkboxSignUp;
    private Button btnLogin,btnSignUp;
    //Google plus sign-in
  //  GoogleSignInHelper googleSignInHelper;
    // Facebook plus sign-in
 //    FbConnectHelper fbConnectHelper;

    RelativeLayout relGoogleLogin,relFBLogin;
    //Calling view
    private View linLogin,linSignUp;
    private boolean isEdit=true;
    //Enum type
   // ViewSettingType viewSettingType;
    //Background task
    public Typeface typeface;
    String token="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_login_sign_up);

        //StatusBarUtils.setTransparent(this);

        //initialize User Interface
        initUI();
        //init CheckNetwork
        initCheckNetwork();
    }



    /**------------------------------------------------------------------------------------------------
     * Start Block - Init UI Methods
     **------------------------------------------------------------------------------------------------*/

    private void initUI() {
        typeface = Typeface.createFromAsset(getApplicationContext().getAssets(),FONT_EXTRA_BOLD_PATH);
        iv_back = (ImageView) findViewById( R.id.iv_back);
        txtTitleLeft = (TextView) findViewById(R.id.txt_title_left);
        txtTitleRight = (TextView) findViewById(R.id.txt_title_right);
        txtForgetPassword = (TextView) findViewById(R.id.txt_forget_password);
        linLogin =  findViewById(R.id.lin_login);
        linSignUp =  findViewById(R.id.lin_sign_up);
        // Login UI instance
        edtLoginEmail = (EditText)findViewById( R.id.edt_login_email );
        edtLoginEmail.setText( "shasthonet02@gmail.com" );
        edtLoginPass = (EditText)findViewById( R.id.edt_login_pass );
        edtLoginPass.setText( "12345678" );
        btnLogin = (Button) findViewById( R.id.btn_login );
      // Registration UI instance
        edtRegUsername = (EditText)findViewById( R.id.edt_reg_username );
        edtRegEmail = (EditText)findViewById( R.id.edt_reg_email );
        edtRegPass = (EditText)findViewById( R.id.edt_reg_pass );
        checkboxSignUp = (AppCompatCheckBox)findViewById( R.id.checkbox_sign_up );
        btnSignUp = (Button) findViewById( R.id.btn_signup );
        relGoogleLogin = (RelativeLayout)findViewById( R.id.rel_google_login );
        relFBLogin = (RelativeLayout)findViewById( R.id.rel_fb_login );
        // set font
        txtForgetPassword.setTypeface( typeface );
        btnLogin.setTypeface( typeface );
        btnSignUp.setTypeface( typeface );
        // click listener
        btnSignUp.setOnClickListener( this );
        btnLogin.setOnClickListener( this );
        iv_back.setOnClickListener( this );
        txtTitleRight.setOnClickListener( this );
        txtForgetPassword.setOnClickListener( this );
        relGoogleLogin.setOnClickListener( this );
        relFBLogin.setOnClickListener( this );
        //getIntent data
        //handleNewIntent(getIntent());
    }
    /*------------------------------------------------------------------------------------------------
     * End Block - Init UI Methods
     **------------------------------------------------------------------------------------------------*/





    /************************
     *  This method will be called
     *  for Checking network is available or not
     ************************/
    private void initCheckNetwork() {

        if (!NetworkManager.isConnected(getApplicationContext())){
            Log.e( "check",">>>" );
        } else {
          //  requestAllTicketFestivallist();
            Log.e( "AllTicketFestival",">>>" );

        }
    }

    /**------------------------------------------------------------------------------------------------
     * Start Block - Override Methods
     **------------------------------------------------------------------------------------------------*/
    @Override
    protected void onResume() {
       // adapterProduct.notifyDataSetChanged();
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.iv_back:

                if(txtTitleLeft.getText().toString().equalsIgnoreCase( "Sign In" )){
                    onBackPressed();
                } else {
                    txtTitleLeft.setText( "Sign In" );
                    txtTitleRight.setText( "Sign Up" );
                    linLogin.setVisibility( View.VISIBLE );
                    linSignUp.setVisibility( View.GONE );
                }

                break;
            case R.id.txt_title_right:

                    if (isEdit) {
                        isEdit = false;
                        txtTitleLeft.setText( "Create Account" );
                        txtTitleRight.setText( "Sign In" );
                        linLogin.setVisibility( View.GONE );
                        linSignUp.setVisibility( View.VISIBLE );
                        //  ViewAnimationUtils.expand( linLogin );
                    } else {
                        isEdit = true;
                        txtTitleLeft.setText( "Sign In" );
                        txtTitleRight.setText( "Sign Up" );
                        linLogin.setVisibility( View.VISIBLE );
                        linSignUp.setVisibility( View.GONE );
                        //  ViewAnimationUtils.expand( linSignUp );
                    }

                break;

//            case R.id.rel_google_login:
//                googleSignInHelper.signIn();
//                break;
//
//            case  R.id.rel_fb_login:
//                fbConnectHelper.connect();
//                break;

            case R.id.btn_login:
                Intent intentHome = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentHome);
              //  validationUserFieldLogin();
                break;

            case R.id.btn_signup:
               // validationUserFieldReg();
                break;

//            case R.id.txt_forget_password:
//                Intent iForgetPass = new Intent( getApplicationContext(),ActivityResetPassword.class );
//                startActivity( iForgetPass );
//                break;
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        googleSignInHelper.onActivityResult(requestCode, resultCode, data);
//        fbConnectHelper.onActivityResult(requestCode, resultCode, data);

    }

    /*------------------------------------------------------------------------------------------------
     * End Block - Override Methods
     **------------------------------------------------------------------------------------------------*/


    /**------------------------------------------------------------------------------------------------
     * Start Block - This method will be called when login button press,
     * then it must be checked all required validation
     **------------------------------------------------------------------------------------------------*/
    private void validationUserFieldLogin() {
        if (edtLoginPass.length() == 0 ) {
            Toast.makeText(context, "Please Enter Your Email", Toast.LENGTH_SHORT).show();

            return;
        }
        if (edtLoginPass.length() == 0) {
            Toast.makeText(context, "Please Enter Your Password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (NetworkManager.isInternetAvailable(context)){
           // doRequestLogin();
        }
        else{
            internetAlert();
//              Utility.showToast("No internet connection",context);
        }
    }

    /*------------------------------------------------------------------------------------------------
     * End Block - validationUserFieldLogin Methods
     **------------------------------------------------------------------------------------------------*/

    /**------------------------------------------------------------------------------------------------
     * Start Block - This method will be called when registration button press,
     * then it must be checked all required validation
     **------------------------------------------------------------------------------------------------*/
/*
    private void validationUserFieldReg() {

        if (edtRegUsername.length() == 0) {

            Tools.showToast(context,"Please write your full name.");
            edtRegUsername.setHintTextColor( Color.RED);

            return;
        }

        if (edtRegEmail.length() == 0) {
            Tools.showToast(context,"The email must be a valid email address.");
            edtRegEmail.setHintTextColor(Color.RED);

            return;
        }

//        if (edt_sign_up_user_.length() == 0) {
//            edt_sign_up_user_email.setHintTextColor(Color.RED);
//            showToast("Please write your last name.");
//
//            return;
//        }

//        if (edt_sign_up_username.length() < 5) {
//            edt_sign_up_username.setHintTextColor(Color.RED);
//            Tools.showToast(getActivity(),"Please write your username at least 5 character.");
//            return;
//        }

        if (edtRegPass.length() < 6) {

            Tools.showToast(context,"The password must be at least 6 characters.");
            edtRegPass.setHintTextColor(Color.RED);
            return;
        }

        if (edtRegPass.getText().toString().equalsIgnoreCase(edtRegConfirmPass.getText().toString())) {

        } else{
            Tools.showToast(context,"Re type password don't match.");
            edtRegConfirmPass.setHintTextColor( Color.RED);
            edtRegConfirmPass.setText("");
            return;
        }

        if (!checkboxSignUp.isChecked()) {
            Tools.showToast(context,"Please check this box if you want to proceed.");
            checkboxSignUp.setHintTextColor(Color.RED);
            return;
        }

// after check all vallidation call api for sign up request
        if (!NetworkManager.isInternetAvailable(context)){
            internetAlert();
        }else {
            doRequestRegistration();
        }
    }*/

    /*------------------------------------------------------------------------------------------------
     * End Block - validationUserFieldReg Methods
     **------------------------------------------------------------------------------------------------*/



    private void internetAlert() {

        Snackbar snackbar = Snackbar.make(findViewById(R.id.cl_login), getResources().getString(R.string.internet_error_msg), Snackbar.LENGTH_LONG)
                .setAction(getResources().getString(R.string.connect_network_text), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent( Settings.ACTION_SETTINGS));
                    }
                });
        snackbar.show();


    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService( Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}

