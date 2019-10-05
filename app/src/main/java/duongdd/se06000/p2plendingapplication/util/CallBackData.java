package duongdd.se06000.p2plendingapplication.util;

public interface CallBackData<T> {
    void onSuccess(T t);
    void onFail(String message);
}
