package in.hulum.intentservice;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.util.Log;


public class SimpleJobIntentService extends JobIntentService {


    public static final String TAG = "SimpleJobIntentService.java";

    /*
     * Unique Job ID for this service
     */
    static final int IMPORT_JOB_ID = 1000;


    /**
     * The static method is used only as a bridge for outside classes
     * to start this JobIntentService. Since we are using other static
     * methods like startActionImportRawData(), we do not need this
     * Convenience method for enqueuing work in to this service.
     *
     *  static void enqueueWork(Context context, Intent work) {
     *       enqueueWork(context, SimpleJobIntentService.class, JOB_ID, work);
     *  }
     */




    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see JobIntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, SimpleJobIntentService.class);
        intent.setAction(ImportData.ACTION_FOO);
        intent.putExtra(ImportData.EXTRA_PARAM1, param1);
        intent.putExtra(ImportData.EXTRA_PARAM2, param2);
        enqueueWork(context,SimpleJobIntentService.class,IMPORT_JOB_ID,intent);
    }


    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see JobIntentService
     */
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, SimpleJobIntentService.class);
        intent.setAction(ImportData.ACTION_BAZ);
        intent.putExtra(ImportData.EXTRA_PARAM1, param1);
        intent.putExtra(ImportData.EXTRA_PARAM2, param2);
        enqueueWork(context,SimpleJobIntentService.class,IMPORT_JOB_ID,intent);
    }



    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see JobIntentService
     */
    public static void startActionImportRawData(Context context, Uri uriParam){
        Intent intent = new Intent(context,SimpleJobIntentService.class);
        intent.setAction(ImportData.ACTION_IMPORT_RAW_DATA);
        intent.setDataAndType(uriParam,"application/vnd.ms-excel");
        enqueueWork(context,SimpleJobIntentService.class,IMPORT_JOB_ID,intent);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        if(intent!=null){
            ImportData.executeAction(this,intent);
        }
    }

}
