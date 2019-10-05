package duongdd.se06000.p2plendingapplication.util;

public class ConfigApi {

    public static final String BASE_URL = "https://lending-app-fu.herokuapp.com";

    public interface Api{
        //account
        String LOGIN = "/api/account/login";
        String CREATE_ACCOUNT = "/api/account/create";
        String ACCOUNT_UPDATE = "/api/account/update";
        //wallet
        String INFO_WALLET = "/api/wallet/info";
        //investment company
        String LIST_INVESTMENT = "/api/investment-company/list-investment-company";
        String DETAIL_INVESTMENT = "/api/investment-company/detail-investment";
        String SEARCH_INVESTMENT = "/api/investment-company/search-investment";
        String LIST_CALLING_INVESTMENT = "/api/investment-company/list-calling-investment";
        //investor detail
        String VIEW_INVESTOR_DETAIL = "/api/investor-detail/information-detail";
        String INVESTOR_INVEST = "/api/investor-detail/investor-invest";
        //company disbursement
        String CALLING_INVESTMENT_DETAIL = "/api/company-disbursement/calling-investment-detail";
        String INFO_MONEY_INVESTMENT = "/api/company-disbursement/information_money_investment";
        String PAYMENT_DISBURSEMENT = "/api/company-disbursement/payment-disbursement";
        String PAYMENT_DEBT = "/api/company-disbursement/payment-debt";
        String PAYMENT_ALL = "/api/company-disbursement/payment-all";

        String LOGIN_TOKEN = "/login";


    }
}
