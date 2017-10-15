package sv.com.lyckan.cuentameuncuento.webservice;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.common.util.concurrent.ExecutionError;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import sv.com.lyckan.cuentameuncuento.adapter.HistoriesAdapter;
import sv.com.lyckan.cuentameuncuento.pojos.Histories;
import sv.com.lyckan.cuentameuncuento.pojos.SelectHistory;

public class ApiController {

    private Retrofit retrofit = null;
    RecyclerView recycler = null;
    private Context context = null;


    public ApiController(){

    }

    public ApiController(Context context, RecyclerView recyclerView){
        this.context = context;
        this.recycler = recyclerView;
    }

    //Interfas de llamadas
    public interface Controller{
        @GET("/cuhi/public/index.php/api/historyall")
        Call<Histories> getHistories();

        @GET("{his}.json")
        Call<SelectHistory> getHistory(@Path("his") String history);
    }

    //Retorna todos los cuentos
    public void getHistories(String baseUrl) {
        Controller controller = null;
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        controller= retrofit.create(Controller.class);

        controller.getHistories().enqueue(new Callback<Histories>() {
            @Override
            public void onResponse(Call<Histories> call, Response<Histories> response) {

                try {
                    HistoriesAdapter adapter = new HistoriesAdapter(response.body().getHistories(), context);
                    recycler.setAdapter(adapter);

                }catch (ExecutionError e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Histories> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public Controller getHistorySelected (String baseUrl) {
        final SelectHistory selectHistory;
        Controller controller = null;
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        controller= retrofit.create(Controller.class);

        return  controller;
    }




}
