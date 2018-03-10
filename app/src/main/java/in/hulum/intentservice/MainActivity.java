package in.hulum.intentservice;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.IOException;
import java.util.Iterator;




public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button startButton;
    private Button stopButton;
    private TextView textviewPercentage;
    private Intent serviceIntent;
    private ResponseReceiver responseReceiver = new ResponseReceiver();
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textviewPercentage = (TextView) findViewById(R.id.text_percent);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter myFilter = new IntentFilter();
        myFilter.addAction(ImportData.ACTION_FOO);
        myFilter.addAction(ImportData.ACTION_IMPORT_RAW_DATA);
        //registerReceiver(responseReceiver,new IntentFilter(SimpleIntentService.ACTION_FOO));
        LocalBroadcastManager.getInstance(this).registerReceiver(responseReceiver,myFilter);
        //registerReceiver(responseReceiver,myFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop() called!!!");
        LocalBroadcastManager.getInstance(this).unregisterReceiver(responseReceiver);
    }

    public void startButtonClicked(View view) {
        SimpleIntentService.startActionFoo(this,"First","Second");
    }

    public void stopButtonClicked(View view) {
        SimpleIntentService.startActionBaz(this,"First Parameter","Second Parameter");
    }

    public void importButtonClicked(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/vnd.ms-excel");
        //intent.setType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        //intent.setType("*/*");
        //String[] mimeTypes = {"application/vnd.ms-excel","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"};
        //intent.addCategory(Intent.CATEGORY_OPENABLE);
        //intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);

        if(isStoragePermissionGranted()){
            startActivityForResult(intent, 7);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch(requestCode){
            case 7:
                if(resultCode==RESULT_OK)
                {
                    SimpleIntentService.startActionImportRawData(this,data.getData());
                }
                break;
        }
    }

    public class ResponseReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e(TAG,"Entered onReceive intent action is " + intent.getAction());
            if(intent.getAction().equals(ImportData.ACTION_FOO)){
                int value = intent.getIntExtra("percentage",-1);
                progressBar.setProgress(value);
                textviewPercentage.setText(value + "% completed");
                if(value==100){
                    textviewPercentage.setText("Finished");
                }
            }

            else if(intent.getAction().equals(ImportData.ACTION_IMPORT_RAW_DATA)){
                boolean isError = intent.getBooleanExtra(ImportData.PARAM_ERROR,false);
                boolean isAnalyzing = intent.getBooleanExtra(ImportData.PARAM_IS_ANALYSING,false);
                boolean isImporting = intent.getBooleanExtra(ImportData.PARAM_IS_IMPORTING,false);
                boolean isUserIdentified = intent.getBooleanExtra(ImportData.PARAM_USER_IDENTIFIED,false);
                Log.d(TAG,"error is " + isError + " analysing " + isAnalyzing + " importing " + isImporting + " user identified " + isUserIdentified);
                if(isError){
                    String msg = intent.getStringExtra(ImportData.PARAM_MESSAGE);
                    textviewPercentage.setText(msg);
                }
                else if(isAnalyzing){
                    String msg = intent.getStringExtra(ImportData.PARAM_MESSAGE);
                    int value = intent.getIntExtra(ImportData.PARAM_PERCENTAGE_COMPLETED,0);
                    textviewPercentage.setText(msg);
                    progressBar.setProgress(value);
                    Log.d(TAG,"Analysing message " + msg + " and percent " + value);
                }
                else if(isImporting){
                    String msg = intent.getStringExtra(ImportData.PARAM_MESSAGE);
                    int value = intent.getIntExtra(ImportData.PARAM_PERCENTAGE_COMPLETED,0);
                    textviewPercentage.setText(msg);
                    progressBar.setProgress(value);
                }
                else if(isUserIdentified){
                    String msg = intent.getStringExtra(ImportData.PARAM_MESSAGE);
                    textviewPercentage.setText(msg);
                    Log.d(TAG,"User identified is " + intent.getStringExtra(ImportData.PARAM_USER_TYPE));
                }
                else{
                    String msg = intent.getStringExtra(ImportData.PARAM_MESSAGE);
                    textviewPercentage.setText(msg);
                    Log.d(TAG,"Percent completed is  " + intent.getIntExtra(ImportData.PARAM_PERCENTAGE_COMPLETED,-1));
                    Log.d(TAG,"Message is " + msg);
                }
            }
        }
    }


    public  boolean isStoragePermissionGranted() {

        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG,"Permission is granted");
                return true;
            } else {

                Log.v(TAG,"Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG,"Permission is granted");
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Log.v(TAG,"Permission: "+permissions[0]+ "was "+grantResults[0]);
            //resume tasks needing this permission
        }
    }
}
