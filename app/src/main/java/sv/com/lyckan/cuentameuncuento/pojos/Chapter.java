package sv.com.lyckan.cuentameuncuento.pojos;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import sv.com.lyckan.cuentameuncuento.BR;


public class Chapter extends BaseObservable implements Parcelable {

    @SerializedName("chapter")
    @Expose
    private Integer chapter;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("body")
    private String body;



    protected Chapter(Parcel in) {
        image = in.readString();
        body = in.readString();

    }

    public static final Creator<Chapter> CREATOR = new Creator<Chapter>() {
        @Override
        public Chapter createFromParcel(Parcel in) {
            return new Chapter(in);
        }

        @Override
        public Chapter[] newArray(int size) {
            return new Chapter[size];
        }
    };

    public Integer getChapter() {
        return chapter;
    }

    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(image);
        parcel.writeString(body);
    }
}