package duongdd.se06000.p2plendingapplication.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import org.json.JSONObject;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import duongdd.se06000.p2plendingapplication.model.InvestorInvest;
import duongdd.se06000.p2plendingapplication.model.ListInvestedCompany;
import duongdd.se06000.p2plendingapplication.repository.LendingService;
import duongdd.se06000.p2plendingapplication.model.CompanyDisbursement;
import duongdd.se06000.p2plendingapplication.model.InvestmentCompanyDetail;
import duongdd.se06000.p2plendingapplication.model.InvestorDetail;
import duongdd.se06000.p2plendingapplication.model.ListCallingInvestment;
import duongdd.se06000.p2plendingapplication.model.ListInvestmentCompany;
import duongdd.se06000.p2plendingapplication.model.ListSearchInvestment;
import duongdd.se06000.p2plendingapplication.model.WalletInformation;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.util.ClientApi;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LendingRepositoryImp implements LendingRepository{
    public static String TOKEN = "";

    @Override
    public void login(String username, String password, final CallBackData<String> callBackData) {
        JSONObject customer = new JSONObject();
        try {
            customer.put("username", username);
            customer.put("password", password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ClientApi clientApi = new ClientApi();
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), customer.toString());
        Call<ResponseBody> call = clientApi.LendingService().loginToken(body);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        if(response.code() == 200){
                            String body = response.body().string();
                            if(!body.isEmpty()){
                                TOKEN = body;
                                callBackData.onSuccess(TOKEN);
                            }


                        }else{
                            callBackData.onFail("Sai tài khoản hoặc mật khẩu");
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    @Override
    public void getWalletInfo(String token,final CallBackData<WalletInformation> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> call = clientApi.LendingService().getWalletInfo(token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200){
                    try {
                        String body = response.body().string();
                        Type type = new TypeToken<WalletInformation>(){}.getType();
                        WalletInformation walletInformation = new Gson().fromJson(body,type);
                        if(walletInformation != null){
                            callBackData.onSuccess(walletInformation);
                        }else{
                            callBackData.onFail("Tài khoản không tồn tại");
                        }
                    }catch (Exception e){
                        callBackData.onFail("Tài khoản không tồn tại");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBackData.onFail("Tài khoản không tồn tại");
            }
        });
    }

    @Override
    public void getListInvestmentCompany(String token, int page, final CallBackData<List<ListInvestmentCompany>> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> call = clientApi.LendingService().getListInvestment(token, page);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200){
                    try {
                        String body = response.body().string();
                        Type type = new TypeToken<List<ListInvestmentCompany>>(){}.getType();
                        List<ListInvestmentCompany> listInvestmentCompanies = new Gson().fromJson(body,type);

                        if(listInvestmentCompanies != null){
                            callBackData.onSuccess(listInvestmentCompanies);
                        }else{
                            callBackData.onFail("Không có đầu tư nào");
                        }
                    }catch (Exception e){
                        callBackData.onFail("Không có đầu tư nào");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBackData.onFail("Không có đầu tư nào");
            }
        });
    }


    @Override
    public void getInvestorDetail(String token, int investorID, final CallBackData<InvestorDetail> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> call = clientApi.LendingService().getInvestorDetail(token, investorID);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200){
                    try {
                        String body = response.body().string();
                        Type type = new TypeToken<InvestorDetail>(){}.getType();
                        InvestorDetail investorDetail = new Gson().fromJson(body,type);
                        if(investorDetail != null){
                            callBackData.onSuccess(investorDetail);
                        }else{
                            callBackData.onFail("Tài khoản không tồn tại");
                        }
                    }catch (Exception e){
                        callBackData.onFail("Tài khoản không tồn tại");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBackData.onFail("Tài khoản không tồn tại");
            }
        });
    }

    @Override
    public void getInvestmentCompanyDetail(String token, int investmentCompanyID, final CallBackData<InvestmentCompanyDetail> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> call = clientApi.LendingService().getInvestmentCompanyDetail(token, investmentCompanyID);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200){
                   try {
                       String body = response.body().string();
                       Type type = new TypeToken<InvestmentCompanyDetail>(){}.getType();
                       InvestmentCompanyDetail investmentCompanyDetail = new Gson().fromJson(body,type);
                       if(investmentCompanyDetail != null){
                           callBackData.onSuccess(investmentCompanyDetail);
                       }else{
                           callBackData.onFail("Thương vụ không tồn tại");
                       }
                   }catch (Exception e){
                       callBackData.onFail("Thương vụ không tồn tại");
                   }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBackData.onFail("Thương vụ không tồn tại");
            }
        });
    }

    @Override
    public void getListCallingInvestment(String token, int id, int page,final CallBackData<List<ListCallingInvestment>> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> call = clientApi.LendingService().getListCallingInvestment(token, id, page);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200){
                    try {
                        String body = response.body().string();
                        Type type = new TypeToken<List<ListCallingInvestment>>(){}.getType();
                        List<ListCallingInvestment> listCallingInvestments = new Gson().fromJson(body,type);

                        if(listCallingInvestments != null){
                            callBackData.onSuccess(listCallingInvestments);
                        }else{
                            callBackData.onFail("Không có thương vụ nào");
                        }
                    }catch (Exception e){
                        callBackData.onFail("Không thương vụ nào");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBackData.onFail("Không thương vụ nào");
            }
        });
    }

    @Override
    public void getListSearchInvestment(String token, String keyword, String career, int page,final CallBackData<List<ListSearchInvestment>> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> call = clientApi.LendingService().getListSearchInvestment(token, keyword,career, page);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200){
                    try {
                        String body = response.body().string();
                        Type type = new TypeToken<List<ListSearchInvestment>>(){}.getType();
                        List<ListSearchInvestment> listSearchInvestments = new Gson().fromJson(body,type);

                        if(listSearchInvestments != null){
                            callBackData.onSuccess(listSearchInvestments);
                        }else{
                            callBackData.onFail("Không có thương vụ nào");
                        }
                    }catch (Exception e){
                        callBackData.onFail("Không thương vụ nào");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                        callBackData.onFail("Không thương vụ nào");
            }
        });
    }

    @Override
    public void getPaymentAllDisbursement(String token, int borrowerID, int investmentCompanyID, int companyDisbursementID,final CallBackData<CompanyDisbursement> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> call = clientApi.LendingService().paymentAllDisbursement(token, borrowerID, investmentCompanyID, companyDisbursementID);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200){
                    try {
                        String body = response.body().string();
                        Type type = new TypeToken<CompanyDisbursement>(){}.getType();
                        CompanyDisbursement companyDisbursement = new Gson().fromJson(body,type);
                        if(companyDisbursement != null){
                            callBackData.onSuccess(companyDisbursement);
                        }else{
                            callBackData.onFail("Thương vụ không tồn tại");
                        }
                    }catch (Exception e){
                        callBackData.onFail("Thương vụ không tồn tại");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBackData.onFail("Thương vụ không tồn tại");
            }
        });
    }

    @Override
    public void getPaymentDebtDisbursement(String token, int borrowerID, int investmentCompanyID, int companyDisbursementID,final CallBackData<CompanyDisbursement> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> call = clientApi.LendingService().paymentDebtDisbursement(token, borrowerID, investmentCompanyID, companyDisbursementID);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200){
                    try {
                        String body = response.body().string();
                        Type type = new TypeToken<CompanyDisbursement>(){}.getType();
                        CompanyDisbursement companyDisbursement = new Gson().fromJson(body,type);
                        if(companyDisbursement != null){
                            callBackData.onSuccess(companyDisbursement);
                        }else{
                            callBackData.onFail("Thương vụ không tồn tại");
                        }
                    }catch (Exception e){
                        callBackData.onFail("Thương vụ không tồn tại");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBackData.onFail("Thương vụ không tồn tại");
            }
        });
    }

    @Override
    public void getPaymentDisbursement(String token, int borrowerID, int investmentCompanyID, BigDecimal money, int companyDisbursementID,final CallBackData<CompanyDisbursement> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> call = clientApi.LendingService().paymentDisbursement(token, borrowerID, investmentCompanyID, money, companyDisbursementID);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200){
                    try {
                        String body = response.body().string();
                        Type type = new TypeToken<CompanyDisbursement>(){}.getType();
                        CompanyDisbursement companyDisbursement = new Gson().fromJson(body,type);
                        if(companyDisbursement != null){
                            callBackData.onSuccess(companyDisbursement);
                        }else{
                            callBackData.onFail("Thương vụ không tồn tại");
                        }
                    }catch (Exception e){
                        callBackData.onFail("Thương vụ không tồn tại");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBackData.onFail("Thương vụ không tồn tại");
            }
        });
    }

    @Override
    public void investorInvest(String token, int borrowerID, int investmentCompanyID, BigDecimal money,final CallBackData<InvestorInvest> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> call = clientApi.LendingService().investorInvest(token, borrowerID, investmentCompanyID, money);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200){
                    try {
                        String body = response.body().string();
                        Type type = new TypeToken<InvestorInvest>(){}.getType();
                        InvestorInvest investorInvest = new Gson().fromJson(body,type);
                        if(investorInvest != null){
                            callBackData.onSuccess(investorInvest);
                        }else{
                            callBackData.onFail("Số tiền không hợp lệ");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBackData.onFail("Số tiền không hợp lệ");
            }
        });
    }

    @Override
    public void getListInvestedCompany(String token, int page,final CallBackData<List<ListInvestedCompany>> callBackData) {
        ClientApi clientApi = new ClientApi();
        Call<ResponseBody> call = clientApi.LendingService().getListInvested(token, page);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200){
                    try {
                        String body = response.body().string();
                        Type type = new TypeToken<List<ListInvestedCompany>>(){}.getType();
                        List<ListInvestedCompany> listInvestedCompanies = new Gson().fromJson(body,type);

                        if(listInvestedCompanies != null){
                            callBackData.onSuccess(listInvestedCompanies);
                        }else{
                            callBackData.onFail("Không có đầu tư nào");
                        }
                    }catch (Exception e){
                        callBackData.onFail("Không có đầu tư nào");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBackData.onFail("Không có đầu tư nào");
            }
        });
    }
}
