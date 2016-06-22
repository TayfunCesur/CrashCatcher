<img src="http://i.hizliresim.com/zrM9Mj.png" align="left" />
# CrashCatcher
> This was really my need. So I decided to do sth about that because I really hate facing "Unfortunately, bla bla has stopped" dialog. Finally I created some tool for avoiding that fucking dialog and get stacktrace of the crash.
<br><br><br>

###Screenshots
<p align="center">
<img src="http://i.hizliresim.com/o7X9J7.png"/>
</p>

##Fast Usage
First, you must initiliaze the CrashCatcher like below.

    CrashCatcher.initiliazeKeeping(YOUR_ACTIVITY);
Care! YOUR_ACTIVITY is an activity which will start first after app crashes.

Second, start the CrashCatcher!

    CrashCatcher.Start();
    
That's it!. Now, you will see an AlertDialog which contains the stacktrace of crash. And do whatever you want that stacktrace!

##How it Works

The CrashCatcher class have a static class called by ExceptionHandler that implements Thread.UncaughtExceptionHandler and it has on override method called by uncaughtException(Thread thread,Throwable ex). When application crashes, then you will be in that method with a thread and a throwable.

    public static class ExceptionHandler implements Thread.UncaughtExceptionHandler {

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
In here, you must set intent for starting again and kill the process.And look CrashCatcher.Start() method if you want to know what I did after this.

Cheers!

## Download Sample Apk
[from Dropbox](https://www.dropbox.com/s/b3r5o0ubnxsfrwq/app-debug.apk?dl=0)

### Questions?
> Let me know if you have questions. Thanks














  
