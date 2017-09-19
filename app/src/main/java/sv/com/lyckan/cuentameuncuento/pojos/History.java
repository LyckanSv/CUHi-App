package sv.com.lyckan.cuentameuncuento.pojos;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.graphics.Palette;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import sv.com.lyckan.cuentameuncuento.BR;

public class History extends BaseObservable implements Parcelable{

    @SerializedName("id_history")
    @Expose
    private String idHistory;
    @SerializedName("autor_name")
    @Expose
    private String autorName;
    @SerializedName("autor_id")
    @Expose
    private Integer autorId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("image")
    @Expose
    @Bindable
    private String image;
    @SerializedName("chapters")
    @Expose
    private String chapters;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("rating")
    @Expose
    private Integer rating;

    protected History(Parcel in) {
        idHistory = in.readString();
        autorName = in.readString();
        title = in.readString();
        category = in.readString();
        image = in.readString();
        chapters = in.readString();
        description = in.readString();
        date = in.readString();
    }

    public static final Creator<History> CREATOR = new Creator<History>() {
        @Override
        public History createFromParcel(Parcel in) {
            return new History(in);
        }

        @Override
        public History[] newArray(int size) {
            return new History[size];
        }
    };

    public String getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(String idHistory) {
        this.idHistory = idHistory;
    }

    public String getAutorName() {
        return autorName;
    }

    public void setAutorName(String autorName) {
        this.autorName = autorName;
    }

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
        notifyPropertyChanged(BR.image);
    }

    public String getChapters() {
        return chapters;
    }

    public void setChapters(String chapters) {
        this.chapters = chapters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(idHistory);
        parcel.writeString(autorName);
        parcel.writeString(title);
        parcel.writeString(category);
        parcel.writeString(image);
        parcel.writeString(chapters);
        parcel.writeString(description);
        parcel.writeString(date);
    }
}