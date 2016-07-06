package activity.ui.com.fragmentstudy.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import activity.ui.com.fragmentstudy.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.main_fragment_class_btn).setOnClickListener(this);
        findViewById(R.id.main_fragment_animation_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()) {
            case R.id.main_fragment_class_btn:
                it.setClass(this, FragmentClassActivity.class);
                break;
            case R.id.main_fragment_animation_btn:
                it.setClass(this, FragmentAnimationActivity.class);
                break;
        }
        startActivity(it);
    }
}
