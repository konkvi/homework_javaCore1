package worker;

public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            // смоделированна ошибка для 55 таски
            if (i == 33){
                errorCallback.onError("An error has occurred for task " + i);
            } else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }
}
