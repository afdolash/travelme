package com.pens.travelme.travelme.api;

import com.codesch.afdolash.meetpoint.model.Event;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Afdolash on 11/13/2017.
 */

public class ApiServices {
    public static String BASE_URL = "http://muhibush.xyz/api_trme/index.php/Api/";

    public static PostService service_post = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiServices.PostService.class);

    public static GetService service_get = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiServices.GetService.class);

    public static DeleteService service_delete = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiServices.DeleteService.class);

    public interface PostService {
        @FormUrlEncoded
        @POST("recomendation")
        Call<Event> postTravel(
                @Field("jenis_layanan") String jenis_layanan,
                @Field("wisata_jenis") String wisata_jenis,
                @Field("wisata_jumlah_anak") int wisata_jumlah_anak,
                @Field("wisata_jumlah_dewasa") int wisata_jumlah_dewasa,
                @Field("budget_wisata") int budget_wisata
        );

        @FormUrlEncoded
        @POST("recomendation")
        Call<Event> postHotel(
                @Field("jenis_layanan") String jenis_layanan,
                @Field("kamar_jumlah") int kamar_jumlah,
                @Field("kamar_jumlah_hari") int kamar_jumlah_hari,
                @Field("budget_kamar") int budget_kamar
        );

        @FormUrlEncoded
        @POST("recomendation")
        Call<Event> postResto(
                @Field("jenis_layanan") String jenis_layanan,
                @Field("menu_porsi") int menu_porsi,
                @Field("budget_menu") int budget_menu
        );
    }

    public interface GetService {

    }

    public interface DeleteService {

    }
}
