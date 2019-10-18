package duongdd.se06000.p2plendingapplication.presenters;

import java.util.List;

import duongdd.se06000.p2plendingapplication.model.Notification;
import duongdd.se06000.p2plendingapplication.repository.LendingRepository;
import duongdd.se06000.p2plendingapplication.repository.LendingRepositoryImp;
import duongdd.se06000.p2plendingapplication.util.CallBackData;
import duongdd.se06000.p2plendingapplication.view.NotificationView;

public class NotificationPresenters {
    NotificationView notificationView;
    LendingRepository lendingRepository;
    public NotificationPresenters(NotificationView notificationView){
        this.notificationView = notificationView;
        this.lendingRepository =new LendingRepositoryImp();
    }
    public void getNotification(String token){
        lendingRepository.getNotification(token, new CallBackData<List<Notification>>() {
            @Override
            public void onSuccess(List<Notification> notifications) {
                notificationView.onSuccess(notifications);
            }

            @Override
            public void onFail(String message) {
                notificationView.onFail(message);
            }
        });
    }
}
