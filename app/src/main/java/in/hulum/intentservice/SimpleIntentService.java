package in.hulum.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import org.apache.commons.collections4.SetUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class SimpleIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String ACTION_FOO = "in.hulum.intentservice.action.FOO";
    private static final String ACTION_BAZ = "in.hulum.intentservice.action.BAZ";
    public static final String ACTION_IMPORT_RAW_DATA = "in.hulum.intentservice.action.IMPORT_RAW_DATA";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "in.hulum.intentservice.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "in.hulum.intentservice.extra.PARAM2";
    private static final String EXTRA_PARAM_URI = "in.hulum.intentservice.extra.PARAM_URI";

    public static final String PARAM_ERROR = "in.hulum.intentservice.extra.PARAM_ERROR";
    public static final String PARAM_MESSAGE = "in.hulum.intentservice.extra.PARAM_ERROR_MESSAGE";
    public static final String PARAM_IS_ANALYSING = "in.hulum.intentservice.extra.PARAM_IS_ANALYSING";
    public static final String PARAM_IS_IMPORTING = "in.hulum.intentservice.extra.PARAM_IS_IMPORTING";
    public static final String PARAM_PERCENTAGE_COMPLETED = "in.hulum.intentservice.extra.PARAM_PERCENTAGE_COMPLETED";
    public static final String PARAM_USER_IDENTIFIED = "in.hulum.intentservice.extra.PARAM_USER_IDENTIFIED";
    public static final String PARAM_USER_TYPE = "in.hulum.intentservice.extra.PARAM_USER_TYPE";

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
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);

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
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    public static void startActionImportRawData(Context context, Uri uriParam){
        Intent intent = new Intent(context,SimpleIntentService.class);
        intent.setAction(ACTION_IMPORT_RAW_DATA);
        intent.putExtra(EXTRA_PARAM_URI,uriParam.toString());
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
            else if(ACTION_IMPORT_RAW_DATA.equals(action)){
                final String uriString = intent.getStringExtra(EXTRA_PARAM_URI);
                final Uri importFileUri = Uri.parse(uriString);
                handleActionImportRawData(importFileUri);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        //throw new UnsupportedOperationException("Not yet implemented");
        Log.d(SimpleIntentService.class.getName().toString(),"This is action Fooo using Start Button. Parameters are " + param1 +" and " + param2);
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(SimpleIntentService.ACTION_FOO);
        for(int i=0;i<=100;i++){
            broadcastIntent.putExtra("percentage",i);
            sendBroadcast(broadcastIntent);
            SystemClock.sleep(100);
            Log.d("IntentService","Loop is running i value is " + i);
        }
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        //throw new UnsupportedOperationException("Not yet implemented");
        Log.d(SimpleIntentService.class.getName().toString(),"This is action Baz using Stop!! Button. Parameters are " + param1 +" and " + param2);
    }

    /**
     * Import an Excel file (.XLS) into SQLite
     * This method does check the validity of the excel file
     * It looks at certain markers to validate the file before importing
     * @param uriExcelFile
     */

    private void handleActionImportRawData(Uri uriExcelFile){

        Workbook workbook = null;

        sendProgressBroadcast(SimpleIntentService.ACTION_IMPORT_RAW_DATA,false,false,false,false,"Loading file...",0,"");

        try {
            workbook = WorkbookFactory.create(getContentResolver().openInputStream(uriExcelFile));
            int sheets = 0 ;
            if(workbook!=null){
                sheets = workbook.getNumberOfSheets();
            }


            /* Read the first worksheet from the excel file */
            Sheet firstSheet = workbook.getSheetAt(0);

            int firstRowNum,lastRowNum,firstColNum,lastColNum;
            DataFormatter dataFormatter = new DataFormatter();
            String rowString;
            firstRowNum = firstSheet.getFirstRowNum();
            lastRowNum = firstSheet.getLastRowNum();

            /*
              If it is an empty file, return
             */
            if(lastRowNum<2){
                sendProgressBroadcast(SimpleIntentService.ACTION_IMPORT_RAW_DATA,true,false,false,false,"The imported excel file does not contain any data. Please choose a valid file.",0,"");
                Log.e(TAG,"Imported excel file contains less than two rows");
                return;
            }

            /**
             * First check if it is a valid udise data excel file
             * A file may be considered valid if it contains certain header names in the first row
             */
            Row firstRow = firstSheet.getRow(0);
            firstColNum = firstRow.getFirstCellNum();
            lastColNum = firstRow.getLastCellNum();

            Resources res = getResources();
            String[] excelHeaders = res.getStringArray(R.array.excel_headers);

            if(lastColNum<excelHeaders.length){
                sendProgressBroadcast(SimpleIntentService.ACTION_IMPORT_RAW_DATA,true,false,false,false,"The imported excel file does not contain UDISE data in a valid format. Please export the raw data in a valid format.",0,"");
                Log.e(TAG,"Imported excel file contains only " + lastColNum + " columns which is lesser than standard " + excelHeaders.length + " columns.");
                return;
            }

            /**
             * Send a broadcast that the imported file is being analysed for a valid data format
             */
            sendProgressBroadcast(SimpleIntentService.ACTION_IMPORT_RAW_DATA,false,true,false,false,"Analyzing data, please wait...",0,"");
            Log.i(TAG,"Analysing headers...");


            /**
             * Check all the headers present in the string array 'excelHeader' are also present in the excel file
             */
            for(int i=firstColNum;i<excelHeaders.length;i++){
                Cell cell = firstRow.getCell(i);
                String cellString = dataFormatter.formatCellValue(cell);
                if(!excelHeaders[i].equals(cellString)){
                    sendProgressBroadcast(SimpleIntentService.ACTION_IMPORT_RAW_DATA,true,false,false,false,"The imported excel file does not contain UDISE data in a valid format. Please export the raw data to excel with headers and then save the file as xls file using MS-Excel software",0,"");
                    Log.e(TAG,"Imported excel file contains unknown header labels");
                    return;
                }
            }


            /**
             * Determine the number of Academic Years, States, Districts, Zones and Schools
             */
            String[] acYears;
            String[] stateNames;
            String[] districtNames;
            String[] zoneNames;
            String[] schoolCodes;
            Set<String> acYearsSet = new HashSet<String>();
            Set<String> stateNamesSet = new HashSet<String>();
            Set<String> districtNamesSet = new HashSet<String>();
            Set<String> zoneNamesSet = new HashSet<String>();
            Set<String> schoolCodesSet = new HashSet<String>();
            String cellString;
            Cell cell;
            Row row;
            int numberOfStates=0,numberOfDistricts=0,numberOfAcademicYears=0,numberOfZones=0,numberOfSchools=0;
            int percentageCompleted=0;

            for(int rowIndex=firstRowNum+1;rowIndex<lastRowNum+1;rowIndex++){
                row = firstSheet.getRow(rowIndex);
                firstColNum = row.getFirstCellNum();
                for(int colIndex=firstColNum;colIndex<excelHeaders.length;colIndex++){
                    cell = row.getCell(colIndex);
                    cellString = dataFormatter.formatCellValue(cell);
                    if(colIndex==0){
                        acYearsSet.add(cellString);
                    }
                    else if(colIndex==1){
                        stateNamesSet.add(cellString);
                    }
                    else if(colIndex==3){
                        districtNamesSet.add(cellString);
                    }
                    else if(colIndex==5){
                        zoneNamesSet.add(cellString);
                    }
                    else if(colIndex==10){
                        schoolCodesSet.add(cellString);
                    }
                }
                percentageCompleted = (rowIndex*100/lastRowNum);
                String progressMessage = "Analysing imported file, " + percentageCompleted+ " % complete ...";
                sendProgressBroadcast(SimpleIntentService.ACTION_IMPORT_RAW_DATA,false,true,false,false,progressMessage,percentageCompleted,"");
                Log.d(TAG,"Analysing imported file, " + percentageCompleted+ " % complete ...");
            }

            Log.d(TAG,"First Row " + firstRowNum + " and Last Row " + lastRowNum);
            Log.d(TAG,"First Column " + firstColNum + " and Last Row " + excelHeaders.length);

            if(workbook != null){
                workbook.close();
            }
            acYears = acYearsSet.toArray(new String[acYearsSet.size()]);
            stateNames = stateNamesSet.toArray(new String[stateNamesSet.size()]);
            districtNames = districtNamesSet.toArray(new String[districtNamesSet.size()]);
            zoneNames = zoneNamesSet.toArray(new String[zoneNamesSet.size()]);
            schoolCodes = schoolCodesSet.toArray(new String[schoolCodesSet.size()]);
            numberOfAcademicYears = acYears.length;
            numberOfStates = stateNames.length;
            numberOfDistricts = districtNames.length;
            numberOfZones = zoneNames.length;
            numberOfSchools = schoolCodes.length;

            String userType;
            if(numberOfStates>1){
                userType = "National";
            }
            else if(numberOfStates==1) {
                if(numberOfDistricts>1){
                    userType = "State";
                }
                else if(numberOfDistricts==1){
                    if(numberOfZones>1){
                        userType = "District";
                    }
                    else if(numberOfZones==1){
                        userType = "Zone";
                    }
                    else {
                        userType = "Unknown";
                    }
                }
                else{
                    userType = "Unknown";
                }
            }
            else{
                userType = "Unknown";
            }
            String analysisMessage = "Analysis Complete \n" +
                                     "Number of Academic Years " + numberOfAcademicYears + "\n" +
                                     "Number of States " + numberOfStates +  "\n" +
                                     "Number of Districts " + numberOfDistricts +  "\n" +
                                     "Number of Zones " + numberOfZones +  "\n" +
                                     "Number of Schools " + numberOfSchools +  "\n" +
                                     "User Type " + userType;
            sendProgressBroadcast(SimpleIntentService.ACTION_IMPORT_RAW_DATA,false,false,false,true,analysisMessage,100,userType);

            Log.d(TAG,analysisMessage);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }

    }



    void sendProgressBroadcast(String action,boolean errorFlag,boolean isAnalysing,boolean isImporting,boolean isUserIdentified,String message,int percentageCompleted,String userType){
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(action);
        broadcastIntent.putExtra(PARAM_ERROR,errorFlag);
        broadcastIntent.putExtra(PARAM_IS_ANALYSING,isAnalysing);
        broadcastIntent.putExtra(PARAM_IS_IMPORTING,isImporting);
        broadcastIntent.putExtra(PARAM_USER_IDENTIFIED,isUserIdentified);
        broadcastIntent.putExtra(PARAM_MESSAGE,message);
        broadcastIntent.putExtra(PARAM_PERCENTAGE_COMPLETED,percentageCompleted);
        broadcastIntent.putExtra(PARAM_USER_TYPE,userType);
        sendBroadcast(broadcastIntent);
    }
}
