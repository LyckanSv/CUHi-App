package sv.com.lyckan.cuentameuncuento;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ScreenSlidePageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String message = getArguments().getString(EXTRA_MESSAGE);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        TextView titulo = (TextView) rootView.findViewById(R.id.titulePage);
        titulo.setText(message);
        return rootView;
    }

    public static final ScreenSlidePageFragment newInstance(String message)
    {
        ScreenSlidePageFragment f = new ScreenSlidePageFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }
}
