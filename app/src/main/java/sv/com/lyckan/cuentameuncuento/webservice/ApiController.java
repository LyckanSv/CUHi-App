package sv.com.lyckan.cuentameuncuento.webservice;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import sv.com.lyckan.cuentameuncuento.R;
import sv.com.lyckan.cuentameuncuento.pojos.Histories;
import sv.com.lyckan.cuentameuncuento.test.UserAdapter;

public class ApiController {

    private Retrofit retrofit = null;
    private View view = null;
    private Context context;

    public ApiController(View view){
        this.view = view;
        this.context = view.getContext();
    }

    //Interfas de llamadas
    public interface Controller{
        @GET("/datos")
        Call<Histories> getHistories();
    }

    //Retorna todos los cuentos
    public void getHistories (String baseUrl) {
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
                RecyclerView recycler = (RecyclerView) view.findViewById(R.id.recycler);
                recycler.setHasFixedSize(true);

                LinearLayoutManager lManager = new LinearLayoutManager(context);
                recycler.setLayoutManager(lManager);

//                UserAdapter adapter = new UserAdapter(items);
//                recycler.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Histories> call, Throwable t) {

            }
        });
    }




}
