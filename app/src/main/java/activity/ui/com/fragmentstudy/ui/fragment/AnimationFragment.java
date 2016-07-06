package activity.ui.com.fragmentstudy.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import activity.ui.com.fragmentstudy.R;

/**
 * Created by Administrator on 2016/7/6.
 */
public class AnimationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animation, container, false);
        return view;
    }

    public String getMsg() {
        TextView fragmentTv = (TextView) getView().findViewById(R.id.fragment_tv);

        return fragmentTv.getText().toString();
    }
}
