package sv.com.lyckan.cuentameuncuento.adapter;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import sv.com.lyckan.cuentameuncuento.R;

public class ImageBindingAdapter {

    @BindingAdapter({"bind:image"})
    public static void loadImage(ImageView imageView, String url) {
        if (!url.equals("")) {
            Picasso.with(imageView.getContext()).load(url).into(imageView);
        }
    }



}

