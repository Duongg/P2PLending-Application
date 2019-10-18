package duongdd.se06000.p2plendingapplication.view;

import java.util.List;

import duongdd.se06000.p2plendingapplication.model.Notification;

public interface NotificationView {
    public void onSuccess(List<Notification> notificationList);
    public void onFail(String message);
}
