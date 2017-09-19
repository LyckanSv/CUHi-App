package sv.com.lyckan.cuentameuncuento.pojos;

import android.databinding.BaseObservable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Histories{

    @SerializedName("histories")
    @Expose
    private List<History> histories = null;

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

}