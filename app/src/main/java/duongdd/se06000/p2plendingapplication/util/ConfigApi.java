package duongdd.se06000.p2plendingapplication.util;

public class ConfigApi {

    public static final String BASE_URL = "https://lending-app-fu.herokuapp.com";
   // public static final String BASE_URL = "http://10.0.2.3:8080";
    public interface Api{
        //account
        String LOGIN = "/api/account/login";
        String CREATE_ACCOUNT = "/api/account/create";
        String GET_ROLE = "/api/account/get-role";
        String ACCOUNT_INFORMATION = "/api/account/information";
        String ACCOUNT_UPDATE = "/api/account/update";
        //wallet
        String INFO_WALLET = "/api/wallet/info";
        //investment company
        String LIST_INVESTMENT = "/api/investment-company/list-investment-company";
        String DETAIL_INVESTMENT = "/api/investment-company/detail-investment";
        String SEARCH_INVESTMENT = "/api/investment-company/search-investment";
        String LIST_CALLING_INVESTMENT = "/api/investment-company/list-calling-investment";
        String DETAIL_INVESTED_INFORMATION = "/api/investment-company/detail-invested-information";
        //investor detail
        String VIEW_INVESTOR_DETAIL = "/api/investor-detail/information-detail";
        String INVESTOR_INVEST = "/api/investor-detail/investor-invest";
        String LIST_INVESTED = "/api/investor-detail/list-invested-company";
        //company disbursement
        String DETAIL_CALLING_INVESTMENT = "/api/investment-company/detail-calling-investment";
        String INFO_MONEY_INVESTMENT = "/api/company-disbursement/information_money_investment";
        String PAYMENT_DISBURSEMENT = "/api/company-disbursement/payment-disbursement";
        String PAYMENT_DEBT = "/api/company-disbursement/payment-debt";
        String PAYMENT_ALL = "/api/company-disbursement/payment-all";

        String LOGIN_TOKEN = "/login";
        String CALLING_INVESTMENT_DETAIL_INFORMATION = "api/company-disbursement/calling-investment-detail-information";
        String LIST_DISBURSEMENT_MONEY="api/company-disbursement/list-disbursement-money";
        String NOTIFICATION_INFORMATION = "api/notification/information";
    }
}
