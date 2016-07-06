package activity.ui.com.fragmentstudy.ui.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import activity.ui.com.fragmentstudy.R;
import activity.ui.com.fragmentstudy.ui.fragment.MainFragment;

public class FragmentClassActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_class);
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        findViewById(R.id.main_btn).setOnClickListener(this);
        DrawerLayout drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        //关闭
        drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        //打开手势滑动
        drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        //关闭比较暴力 直接移除view 免得碍事
        //drawerlayout.removeViewAt(1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_btn:
                MainFragment mainFragment = (MainFragment) fragmentManager.findFragmentById(R.id.mian_fragment);
                String msg = mainFragment.getMsg();
                show(msg);
                break;
        }
    }

    private void show(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
