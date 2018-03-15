package in.hulum.intentservice.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

public class UdiseContentProvider extends ContentProvider {

    public static final int CODE_RAWDATA = 100;
    public static final int CODE_RAWDATA_WITH_UDISECODE = 101;
    public static final int CODE_RAWDATA_WITH_SCHOOLNAME = 102;

    private static final String TAG = "UdiseContentProvider";


    private UdiseDbHelper mUdiseDbHelper;

    private static final UriMatcher sUriMatcher = udiseUriMatcher();

    public static UriMatcher udiseUriMatcher(){
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(UdiseContract.AUTHORITY,UdiseContract.PATH_RAW_DATA_TABLE,CODE_RAWDATA);
        uriMatcher.addURI(UdiseContract.AUTHORITY,UdiseContract.PATH_RAW_DATA_TABLE + "/#",CODE_RAWDATA_WITH_UDISECODE);
        uriMatcher.addURI(UdiseContract.AUTHORITY,UdiseContract.PATH_RAW_DATA_TABLE + "/*",CODE_RAWDATA_WITH_SCHOOLNAME);
        return uriMatcher;
    }

    public UdiseContentProvider() {
    }



    @Override
    public boolean onCreate() {
        Context context = getContext();
        mUdiseDbHelper = new UdiseDbHelper(context);
        return true;
    }


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        //Get access to the udise database
        final SQLiteDatabase dbUdise = mUdiseDbHelper.getWritableDatabase();

        int match = sUriMatcher.match(uri);
        Uri returnUri;

        switch(match){
            case CODE_RAWDATA:
                //Uri containing the name of the table appended at the end
                long id = dbUdise.insert(UdiseContract.RawData.TABLE_NAME,null,values);

                /*If insert operation was successful return uri of inserted row, else throw an exception*/
                if( id > 0 ){
                    returnUri = ContentUris.withAppendedId(UdiseContract.RawData.CONTENT_URI,id);
                } else {
                    Toast.makeText(getContext(),"Unable to insert data! Please make sure you have enough storage on your device.",Toast.LENGTH_SHORT).show();
                    Log.e(TAG,"Unable to insert data into the database." );
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                }
                break;

            default:
                //No other Uri has been implemented for insert operation
                //So other Uris should produce an exception
                Log.e(TAG,"UriMatcher returned an unknown code: " + match);
                throw new UnsupportedOperationException("Unknown Uri: " + uri);
        }

        getContext().getContentResolver().notifyChange(uri,null);
        return returnUri;
    }


    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values){
        final SQLiteDatabase dbUdise = mUdiseDbHelper.getWritableDatabase();

        int match = sUriMatcher.match(uri);
        switch (match) {

            case CODE_RAWDATA:
                dbUdise.beginTransaction();
                int rowsInserted = 0;
                try {
                    for (ContentValues value : values) {

                        long id = dbUdise.insert(UdiseContract.RawData.TABLE_NAME,null,value);
                        if( id != -1 ){
                            rowsInserted++;
                        }
                    }
                    dbUdise.setTransactionSuccessful();
                } finally {
                    dbUdise.endTransaction();
                }

                if(rowsInserted>0){
                    getContext().getContentResolver().notifyChange(uri,null);
                }

                return rowsInserted;

            default:
                return  super.bulkInsert(uri,values);
        }
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement CODE_RAWDATA_WITH_SCHOOLNAME and CODE_RAWDATA_WITH_UDISECODE
        // as well as other possible implementations
        Cursor cursor = null;

        /*
         * Determine the kind of request made
         */
        int match = sUriMatcher.match(uri);
        switch(match){
            case CODE_RAWDATA:
                cursor = mUdiseDbHelper.getReadableDatabase().query(UdiseContract.RawData.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
        }

        if (cursor != null) {
            cursor.setNotificationUri(getContext().getContentResolver(),uri);
        }
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
