package bookpeon.cutprice.com.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;

import bookpeon.cutprice.com.R;

import static bookpeon.cutprice.com.util.CommonContents.FONT_EXTRA_BOLD_PATH;

/**
 * @author Md. Hozrot belal
 * Email: belal.cse.brur@gmail.com
 */
public class ActivitySearch extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView txttoolbar,tvTitle,tvSearch;
    ImageView iv_back,btClear;
    private MaterialRippleLayout mrBack;
    LinearLayout linSearch;
    Typeface typeface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_search_screen );

      //  initStatusBar();
        // Setup ToolBar
        initToolBarSetUp();
        initActivityViews();

    }

    private void initToolBarSetUp() {
        typeface = Typeface.createFromAsset( getApplicationContext().getAssets(), FONT_EXTRA_BOLD_PATH );

        tvTitle = (TextView) findViewById(R.id.tv_title);
        btClear = (ImageView) findViewById(R.id.btn_clear);
        tvSearch = (TextView)findViewById( R.id.tv_search );
        linSearch = (LinearLayout) findViewById( R.id.lin_search );

        // mrBack = (MaterialRippleLayout) findViewById( R.id.mr_back );
        tvTitle.setTypeface( typeface );

        btClear.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        } );

    }

//    private void initStatusBar() {
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
//        StatusBarUtil.setTransparent(SplashActivity.this);
//    }

    public void initActivityViews() {
        linSearch.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(getApplicationContext(), ActivitySearchList.class);
                startActivity(intentReg);
            }
        } );
    }


}