package com.xionces.crashcatchersample;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Process;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by TayfunCesur on 22/06/16.
 */
public class CrashCatcher {

    private static Activity mActivity;

    public static void initiliazeKeeping(Activity activity){
        mActivity = activity;
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(activity));
    }

    public static void Start()
    {
        Intent intent = mActivity.getIntent();
        if (intent.getExtras() != null) {
            new AlertDialog.Builder(mActivity).
                    setTitle(mActivity.getString(R.string.dialog_title)).
                    setMessage(intent.getExtras().getString("Exception")).
                    setIconAttribute(android.R.attr.alertDialogIcon).
                    setCancelable(false).
                    setNegativeButton("Report", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            showDetailDialog();
                        }
                    }).
                    setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
        }
    }



    public static class ExceptionHandler implements Thread.UncaughtExceptionHandler {

        private final Activity mActivity;

        public ExceptionHandler(Activity activity) {
            mActivity = activity;
        }
        @Override
        public void uncaughtException(Thread thread, Throwable ex) {
            StringWriter stackTrace = new StringWriter();
            ex.printStackTrace(new PrintWriter(stackTrace));
            Intent intent = new Intent(mActivity.getApplicationContext(), mActivity.getClass());
            intent.putExtra("Exception", stackTrace.toString());
            mActivity.startActivity(intent);
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }

    private static void showDetailDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(mActivity,"Send your report whatever you want",Toast.LENGTH_SHORT).show();
            }
        });

        final AlertDialog dialog = builder.create();
        LayoutInflater inflater = mActivity.getLayoutInflater();
        final View dialogLayout = inflater.inflate(R.layout.send_report, null);

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface d) {
            }
        });

        dialog.setView(dialogLayout);
        dialog.show();
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    }



}
