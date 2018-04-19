package com.pens.travelme.travelme.api;

import com.pens.travelme.travelme.modal.Kamar;
import com.pens.travelme.travelme.modal.Kuliner;
import com.pens.travelme.travelme.modal.Menu;
import com.pens.travelme.travelme.modal.Packages;
import com.pens.travelme.travelme.modal.Penginapan;
import com.pens.travelme.travelme.modal.Wisata;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
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
        @POST("package_recomendation")
        Call<ArrayList<Packages>> package_recomendation(
                @Field("list_id_wisata") String list_id_wisata,
                @Field("list_id_kamar") String list_id_kamar,
                @Field("list_id_menu") String list_id_menu
        );

        @FormUrlEncoded
        @POST("recomendation")
        Call<ArrayList<Wisata>> get_r_wisata(
                @Field("jenis_layanan") String jenis_layanan,
                @Field("wisata_jenis") String wisata_jenis,
                @Field("wisata_jumlah_anak") int wisata_jumlah_anak,
                @Field("wisata_jumlah_dewasa") int wisata_jumlah_dewasa,
                @Field("jumlah_motor") int jumlah_motor,
                @Field("jumlah_mobil") int jumlah_mobil,
                @Field("jumlah_bus") int jumlah_bus,
                @Field("budget_wisata") Double budget_wisata
        );

        @FormUrlEncoded
        @POST("recomendation")
        Call<ArrayList<Kamar>> get_r_kamar(
                @Field("jenis_layanan") String jenis_layanan,
                @Field("kamar_jumlah") int kamar_jumlah,
                @Field("kamar_jumlah_hari") int kamar_jumlah_hari,
                @Field("budget_kamar") Double budget_kamar
        );

        @FormUrlEncoded
        @POST("recomendation")
        Call<ArrayList<Menu>> get_r_menu(
                @Field("jenis_layanan") String jenis_layanan,
                @Field("menu_porsi") int menu_porsi,
                @Field("budget_menu") Double budget_menu
        );

        @FormUrlEncoded
        @POST("all_kuliner")
        Call<ArrayList<Kuliner>> get_all_kuliner(@Field("id") int id);

        @FormUrlEncoded
        @POST("all_wisata")
        Call<ArrayList<Wisata>> get_all_wisata(@Field("id") int id);

        @FormUrlEncoded
        @POST("all_penginapan")
        Call<ArrayList<Penginapan>> get_all_penginapan(@Field("id") int id);
    }

    public interface GetService {

    }

    public interface DeleteService {

    }
}
