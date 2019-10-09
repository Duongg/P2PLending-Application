package duongdd.se06000.p2plendingapplication.repository;

import java.math.BigDecimal;


import duongdd.se06000.p2plendingapplication.util.ConfigApi;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface LendingService {

    @POST(ConfigApi.Api.LOGIN)
    Call<ResponseBody> login(@Query("username") String username, @Query("password") String password);

    @POST(ConfigApi.Api.LOGIN_TOKEN)
    @Headers("Content-Type:application/json")
    Call<ResponseBody> loginToken(@Body RequestBody requestBody);

    @GET(ConfigApi.Api.INFO_WALLET)
    Call<ResponseBody> getWalletInfo(@Header("Authorization") String authorization);

    @GET(ConfigApi.Api.LIST_INVESTMENT)
    Call<ResponseBody> getListInvestment(@Header("Authorization") String authorization, @Query("page") int page);

    @GET(ConfigApi.Api.VIEW_INVESTOR_DETAIL)
    Call<ResponseBody> getInvestorDetail(@Header("Authorization") String authorization, @Query("investorDetailsID") int investorDetailsID);

    @GET(ConfigApi.Api.DETAIL_INVESTMENT)
    Call<ResponseBody> getInvestmentCompanyDetail(@Header("Authorization") String authorization,
                                                  @Query("investmentCompanyID") int investmentCompanyID);

    @GET(ConfigApi.Api.LIST_CALLING_INVESTMENT)
    Call<ResponseBody> getListCallingInvestment(@Header("Authorization") String authorization, @Query("id") int id,
                                                @Query("page") int page);


    @GET(ConfigApi.Api.SEARCH_INVESTMENT)
    Call<ResponseBody> getListSearchInvestment(@Header("Authorization") String authorization, @Query("keyword") String keyword,
                                               @Query("career") String career,
                                               @Query("page") int page);

    @PUT(ConfigApi.Api.PAYMENT_ALL)
    Call<ResponseBody> paymentAllDisbursement(@Header("Authorization") String authorization, @Query("borrowerID") int borrowerID,
                                              @Query("investmentCompanyID") int investmentCompanyID,
                                              @Query("companyDisbursementID") int companyDisbursementID);
    @PUT(ConfigApi.Api.PAYMENT_DEBT)
    Call<ResponseBody> paymentDebtDisbursement(@Header("Authorization") String authorization, @Query("borrowerID") int borrowerID,
                                               @Query("investmentCompanyID") int investmentCompanyID,
                                               @Query("companyDisbursementID") int companyDisbursementID);

    @PUT(ConfigApi.Api.PAYMENT_DISBURSEMENT)
    Call<ResponseBody> paymentDisbursement(@Header("Authorization") String authorization, @Query("borrowerID") int borrowerID,
                                           @Query("investmentCompanyID") int investmentCompanyID,
                                           @Query("money") BigDecimal money,
                                           @Query("companyDisbursementID") int companyDisbursementID);

    @POST(ConfigApi.Api.INVESTOR_INVEST)
    Call<ResponseBody> investorInvest(@Header("Authorization") String authorization,
                                           @Query("borrowerID") int borrowerID,
                                           @Query("investmentCompanyID") int investmentCompanyID,
                                           @Query("money") BigDecimal money);

    @GET(ConfigApi.Api.LIST_INVESTED)
    Call<ResponseBody> getListInvested(@Header("Authorization") String authorization, @Query("page") int page);

}
