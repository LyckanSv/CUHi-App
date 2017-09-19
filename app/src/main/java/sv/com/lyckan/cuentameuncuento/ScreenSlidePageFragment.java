package sv.com.lyckan.cuentameuncuento;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ScreenSlidePageFragment extends Fragment {

    SpeakRequest speakRequest;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String image = getArguments().getString("image");
        final String body = getArguments().getString("body");
        String num = getArguments().getString("pos");
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        speakRequest = new SpeakRequest(getContext());

        ImageView img = (ImageView) rootView.findViewById(R.id.imageChapter);
        TextView bodyTxt = (TextView) rootView.findViewById(R.id.body);
        TextView numPage = (TextView) rootView.findViewById(R.id.numPage);
        final ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.imageButton2);

        try {
            Picasso.with(getContext()).load(image).into(img);
            bodyTxt.setText(body);
            numPage.setText(num);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    speakRequest.speak(body);
                }
            });
        }catch (Exception e){
            bodyTxt.setText(getResources().getString(R.string.error_load));
        }


        return rootView;
    }

    public static final ScreenSlidePageFragment newInstance(String image, String body, String pos)
    {
        ScreenSlidePageFragment f = new ScreenSlidePageFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString("image", image);
        bdl.putString("body", body);
        bdl.putString("pos", pos);
        f.setArguments(bdl);
        return f;
    }


}
