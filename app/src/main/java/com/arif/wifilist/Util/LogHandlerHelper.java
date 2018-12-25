package com.arif.wifilist.Util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.StrictMode;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogHandlerHelper extends Activity implements UncaughtExceptionHandler {

    String mTAG = LogHandlerHelper.class.getSimpleName();
    String CURRENT_KEY="CURRENT_KEY";
    String CURRENT_USER_EMAIL = "CURRENT_USER_EMAIL";

    Date dateTime;
    Activity activity;
    String logs, fileName, report = null;

    private UncaughtExceptionHandler defaultUEH;

    File myFile;
    File externalStorageDir = Environment.getExternalStorageDirectory();

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy hh:mm:ss");

    private SimpleDateFormat getFormat = new SimpleDateFormat("yyyy-MM-dd");

    public LogHandlerHelper(Activity activity) {
        this.defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
        this.activity = activity;
    }

    public void uncaughtException(Thread t, Throwable e) {

        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);

        e.printStackTrace(printWriter);
        printWriter.close();

        StackTraceElement[] arr = e.getStackTrace();

        report = e.toString().concat("\n");

        report += "-----" + "------- Stack trace ------------\n";
        for (int i = 0; i < arr.length; i++) {
            report += "    " + arr[i].toString().concat("\n");
        }

        report += "------------ Cause ------------------\n";
        Throwable cause = e.getCause();

        if (cause != null) {
            report += cause.toString().concat("\n");
            arr = cause.getStackTrace();
            for (int i = 0; i < arr.length; i++) {
                report += "    " + arr[i].toString().concat("\n");
            }
        }
        report += "-------------------------------------\n\n";

        WriteLogs();

        //SendMail(this);

        Gmail();

        defaultUEH.uncaughtException(t, e);
    }

    public void WriteLogs() {

        if (report == null)
            return;

        dateTime = new Date();

        logs = format.format(dateTime).concat(" --> ").concat(report);
        fileName = ("Log-Pollyfy-").concat(getFormat.format(dateTime)).concat(".txt");
        //fileName = ("Log-").concat(getString(R.string.app_name)).concat("-").concat(getFormat.format(dateTime)).concat(".txt");

        myFile = new File(externalStorageDir + File.separator + "Pollyfy", fileName);

        if (!myFile.exists()) {
            try {
                myFile.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {

            FileOutputStream fostream = new FileOutputStream(myFile, true);
            OutputStreamWriter oswriter = new OutputStreamWriter(fostream);
            BufferedWriter bwriter = new BufferedWriter(oswriter);
            bwriter.write(logs);
            bwriter.newLine();
            bwriter.close();
            oswriter.close();
            fostream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void SendMail(Context context) {
        /*

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        GmailSenderModel sender = new GmailSenderModel("yasaminat@gmail.com", "741+852+963+2122");
        try {
            sender.sendMail(fileName,
                    logs,
                    "yasaminat@gmail.com",
                    "yasaminat@gmail.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ShowMessageToast("Hata Mesajı iletildi...");
        System.exit(1);

        */
    }

    void Gmail(){

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        i.putExtra(Intent.EXTRA_TEXT   , "body of email");

        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }
}