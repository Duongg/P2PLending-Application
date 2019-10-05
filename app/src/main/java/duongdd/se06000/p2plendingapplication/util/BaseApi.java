package duongdd.se06000.p2plendingapplication.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseApi {
    private Retrofit retrofitAdapter;

    public Retrofit getRetrofitAdapter() {
        return retrofitAdapter;
    }

    public <T> T getService(Class<T> tClass, String url) {

        if (getRetrofitAdapter() == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(80, TimeUnit.SECONDS).build();
//            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
//                  okHttpClient.addInterceptor(new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    Request request = chain.request();
//
//                    Request.Builder newRequest = request.newBuilder().header(
//                            "Authorization",
//                            LendingRepositoryImp.TOKEN
//                    );
//
//                    System.out.println(LendingRepositoryImp.TOKEN);
//                    return chain.proceed(newRequest.build());
//                }
//            });

            retrofitAdapter = new Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return getRetrofitAdapter().create(tClass);
    }

}
