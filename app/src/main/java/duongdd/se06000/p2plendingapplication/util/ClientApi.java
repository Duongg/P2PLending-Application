package duongdd.se06000.p2plendingapplication.util;

import duongdd.se06000.p2plendingapplication.repository.LendingService;

public class ClientApi extends BaseApi{

    public LendingService LendingService(){
        return this.getService(LendingService.class, ConfigApi.BASE_URL);
    }
}
