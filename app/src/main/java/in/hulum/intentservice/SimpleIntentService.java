package in.hulum.intentservice;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class SimpleIntentService extends IntentService {


    public static final String TAG = "SimpleIntentService.java";


    public SimpleIntentService() {
        super("SimpleIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, SimpleIntentService.class);
        intent.setAction(ImportData.ACTION_FOO);
        intent.putExtra(ImportData.EXTRA_PARAM1, param1);
        intent.putExtra(ImportData.EXTRA_PARAM2, param2);

        context.startService(intent);
    }
    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, SimpleIntentService.class);
        intent.setAction(ImportData.ACTION_BAZ);
        intent.putExtra(ImportData.EXTRA_PARAM1, param1);
        intent.putExtra(ImportData.EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    public static void startActionImportRawData(Context context, Uri uriParam){
        Intent intent = new Intent(context,SimpleIntentService.class);
        intent.setAction(ImportData.ACTION_IMPORT_RAW_DATA);
        intent.setDataAndType(uriParam,"application/vnd.ms-excel");
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if(intent!=null){
            ImportData.executeAction(this,intent);
        }

    }
}
