package rsatm.mymapapp;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 *
 * Created by Yashar.P on 6/27/2018.
 */

public class ThreadExample {
    private static final String TAG = "rsatm";

    public void start() {
        asyncTaskExample();
        handlerExample();
        executerServiceExample();
        futureTask();
    }

    private void futureTask() {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                        Log.e(TAG, "call: " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return Thread.currentThread().getName();
            }
        };
        FutureTask<String> futureTask = new FutureTask<String>(callable);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(futureTask);
    }

    private void executerServiceExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                        Log.e(TAG, "run: " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void asyncTaskExample() {
        LogTask logTask = new LogTask();
        logTask.execute("Hello Wrold");
    }

    public void handlerExample() {
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                        Log.e(TAG, "handleMessage: " + msg);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        Message message = new Message();
        message.obj = "new message";
        handler.sendMessage(message);
    }

    class LogTask extends AsyncTask<String, Integer, Boolean> {

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.e(TAG, "onProgressUpdate: " + values[0] + " second");
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            Log.e(TAG, "doInBackground: " + strings[0]);
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    publishProgress(i + 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            Log.e(TAG, "onPostExecute: " + aBoolean);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.e(TAG, "onPreExecute: Start");
        }
    }
}
