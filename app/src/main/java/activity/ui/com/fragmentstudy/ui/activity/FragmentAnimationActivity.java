package activity.ui.com.fragmentstudy.ui.activity;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import activity.ui.com.fragmentstudy.R;
import activity.ui.com.fragmentstudy.ui.fragment.AnimationFragment;

public class FragmentAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private View weixinLayout, tongxunluLayout, faxianLayout, woLayout;
    private TextView weixinTv, tongxunluTv, faxianTv, woTv;
    private ImageView weixinIv, tongxunluIv, faxianIv, woIv;
    private Fragment fragment1;
    private Fragment fragment2;
    private Fragment fragment3;
    private Fragment fragment4;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_animation);
        init();
        fm = getFragmentManager();
        // 初识状态是显示微信
        weixinIv.setBackgroundResource(R.mipmap.weixin2);
        weixinTv.setTextColor(getResources().getColor(R.color.green));
    }

    private void init() {
        // 注册各IamgeView
        weixinIv = (ImageView) findViewById(R.id.weixin_iv);
        tongxunluIv = (ImageView) findViewById(R.id.tongxunlu_iv);
        faxianIv = (ImageView) findViewById(R.id.faxian_iv);
        woIv = (ImageView) findViewById(R.id.wo_iv);

        // 注册各TextView
        weixinTv = (TextView) findViewById(R.id.weixin_tv);
        tongxunluTv = (TextView) findViewById(R.id.tongxunlu_tv);
        faxianTv = (TextView) findViewById(R.id.faxian_tv);
        woTv = (TextView) findViewById(R.id.wo_tv);

        // 注册各Layout
        weixinLayout = (View) findViewById(R.id.weixin_layout);
        tongxunluLayout = (View) findViewById(R.id.tongxunlu_layout);
        faxianLayout = (View) findViewById(R.id.faxian_layout);
        woLayout = (View) findViewById(R.id.wo_layout);

        // 各Layout注册监听器
        weixinLayout.setOnClickListener(this);
        tongxunluLayout.setOnClickListener(this);
        faxianLayout.setOnClickListener(this);
        woLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.weixin_layout:
                // 如果点的是微信，将微信布局的图片和文字的颜色变为绿色
                weixinIv.setBackgroundResource(R.mipmap.weixin2);
                weixinTv.setTextColor(getResources().getColor(R.color.green));
                // 显示微信的fragment
                showFragment(1);
                break;
            case R.id.tongxunlu_layout:
                tongxunluIv.setBackgroundResource(R.mipmap.tongxunlu2);
                tongxunluTv.setTextColor(getResources().getColor(R.color.green));
                showFragment(2);
                break;
            case R.id.faxian_layout:
                faxianIv.setBackgroundResource(R.mipmap.faxian2);
                faxianTv.setTextColor(getResources().getColor(R.color.green));
                showFragment(3);
                break;
            case R.id.wo_layout:
                woIv.setBackgroundResource(R.mipmap.wo2);
                woTv.setTextColor(getResources().getColor(R.color.green));
                showFragment(4);
                break;
        }
    }

    public void clearState() {
        // 未选中时的图片
        weixinIv.setBackgroundResource(R.mipmap.weixin1);
        tongxunluIv.setBackgroundResource(R.mipmap.tongxunlu1);
        faxianIv.setBackgroundResource(R.mipmap.faxian1);
        woIv.setBackgroundResource(R.mipmap.wo1);
        // 未选中时字体颜色
        weixinTv.setTextColor(getResources().getColor(R.color.black));
        tongxunluTv.setTextColor(getResources().getColor(R.color.black));
        faxianTv.setTextColor(getResources().getColor(R.color.black));
        woTv.setTextColor(getResources().getColor(R.color.black));
    }

    private int index;

    @SuppressLint("NewApi")
    public void showFragment(int index) {
        if (this.index == index) {
            return;
        }
        FragmentTransaction ft = fm.beginTransaction();
        // 该方法可传入的三个参数是：　　TRANSIT_NONE, 　TRANSIT_FRAGMENT_OPEN,
        // TRANSIT_FRAGMENT_CLOSE
        // 分别对应无动画、打开形式的动画和关闭形式的动画。
        // ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        // ft.setCustomAnimations(R.anim.push_left_in,R.anim.push_left_in,R.anim.back_left_in,R.anim.back_right_out);
        if (index - this.index > 0) {
             ft.setCustomAnimations(R.anim.fragment_app_rights_enter, R.anim.fragment_app_rights_exit);
        } else {
            ft.setCustomAnimations(R.anim.fragment_app_left_in, R.anim.fragment_app_left_out);
        }
        // 想要显示一个fragment,先隐藏所有fragment，防止重叠
        hideFragments(ft);
        this.index = index;
        switch (index) {
            case 1:
                // 如果fragment1已经存在则将其显示出来
                if (fragment1 != null)
                    ft.show(fragment1);
                    // 否则添加fragment1，注意添加后是会显示出来的，replace方法也是先remove后add
                else {
                    fragment1 = new AnimationFragment();
                    ft.add(R.id.content, fragment1);
                }
                break;
            case 2:
                if (fragment2 != null)
                    ft.show(fragment2);
                else {
                    fragment2 = new AnimationFragment();
                    ft.add(R.id.content, fragment2);
                }
                break;
            case 3:
                if (fragment3 != null)
                    ft.show(fragment3);
                else {
                    fragment3 = new AnimationFragment();
                    ft.add(R.id.content, fragment3);
                }
                break;
            case 4:
                if (fragment4 != null)
                    ft.show(fragment4);
                else {
                    fragment4 = new AnimationFragment();
                    ft.add(R.id.content, fragment4);
                }
                break;
        }
        ft.commit();
    }

    // 当fragment已被实例化，相当于发生过切换，就隐藏起来
    public void hideFragments(FragmentTransaction ft) {
        if (fragment1 != null)
            ft.hide(fragment1);
        if (fragment2 != null)
            ft.hide(fragment2);
        if (fragment3 != null)
            ft.hide(fragment3);
        if (fragment4 != null)
            ft.hide(fragment4);
    }
}
