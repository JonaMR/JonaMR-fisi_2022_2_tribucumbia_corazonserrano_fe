package com.example.myapplication;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface Jsonpagos {


    @GET("eduapp/pagoMatricula/archivo/1")
    Call<Boolean> getBolleano();
   /* @PUT ("eduapp/pagoMatricula/aprobarMatricula/1")
    Call<Estudiante> postEstudiante(@Body Estudiante estudiante);*/

    @POST ("eduapp/pagoMatricula/subirArchivo/1")
    Call<stripe> postPagoMatricula(@Body stripe PagosStripe);

    @GET("eduapp/pagoMatricula/validarMatriculaPendiente/1")
    Call<Boolean> getBolleanop();

    @PUT("api/stripe/paymentIntent/createpayment/71")

    Call<stripe> getPagar(@Body stripe PagosStripe);

}
