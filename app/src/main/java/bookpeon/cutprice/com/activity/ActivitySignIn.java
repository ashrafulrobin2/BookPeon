package bookpeon.cutprice.com.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import bookpeon.cutprice.com.R;

import static bookpeon.cutprice.com.util.CommonContents.FONT_EXTRA_BOLD_PATH;

/**
 * @author Md. Hozrot belal
 * Email: belal.cse.brur@gmail.com
 */
public class ActivitySignIn extends AppCompatActivity {

    private TextView tvSigninTitle,tvRequestReg;
    private Button btnRequestLogin;
    Typeface typeface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_login_screen);

      //  initStatusBar();
        initActivityViews();
    }

//    private void initStatusBar() {
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
//        StatusBarUtil.setTransparent(SplashActivity.this);
//    }

    public void initActivityViews() {
        typeface = Typeface.createFromAsset( getApplicationContext().getAssets(), FONT_EXTRA_BOLD_PATH );

        tvSigninTitle = (TextView) findViewById( R.id.tv_signin_title );
        btnRequestLogin = (Button)findViewById( R.id.btn_request_login );
        tvRequestReg = (TextView)findViewById( R.id.tv_request_reg );
        tvSigninTitle.setTypeface( typeface );
        btnRequestLogin.setTypeface( typeface );
        tvRequestReg.setTypeface( typeface );

        btnRequestLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(getApplicationContext(), ActivityHome.class);
                startActivity(intentReg);
            }
        } );

        tvRequestReg.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(getApplicationContext(), ActivityRegister.class);
                startActivity(intentReg);
            }
        } );
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            //  this.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            return true;
        }

        return super.onOptionsItemSelected( item );
    }

}