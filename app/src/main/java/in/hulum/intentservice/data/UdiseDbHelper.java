package in.hulum.intentservice.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.JsonReader;
import android.util.Log;

import org.apache.commons.collections4.SetUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import in.hulum.intentservice.Models.NumberOfSchoolsModel;
import in.hulum.intentservice.Models.UserDataModel;

/**
 * Created by Irshad on 12-03-2018.
 */

public class UdiseDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "udise.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TAG = "UdiseDbHelper";

    public UdiseDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_TABLE_UDISE_RAW_DATA = "CREATE TABLE " +
                UdiseContract.RawData.TABLE_NAME + " (" +
                UdiseContract.RawData._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                UdiseContract.RawData.COLUMN_AC_YEAR + " TEXT NOT NULL, " +
                UdiseContract.RawData.COLUMN_UDISE_SCHOOL_CODE + " TEXT NOT NULL, " +
                UdiseContract.RawData.COLUMN_UNIQUE_UDISE_SCHOOL_CODE + " TEXT, " +
                UdiseContract.RawData.COLUMN_SCHOOL_NAME + " TEXT NOT NULL, " +
                UdiseContract.RawData.COLUMN_SCHOOL_OPERATIONAL_STATUS + " INTEGER NOT NULL, " +
                UdiseContract.RawData.COLUMN_LOWEST_CLASS + " INTEGER, " +
                UdiseContract.RawData.COLUMN_HIGHEST_CLASS + " INTEGER, " +
                UdiseContract.RawData.COLUMN_SCHOOL_COEDUCATION_TYPE + " INTEGER, " +
                UdiseContract.RawData.COLUMN_IS_RELIGIOUS_MINORITY_SCHOOL + " TEXT, " +
                UdiseContract.RawData.COLUMN_RELIGIOUS_MINORITY_TYPE + " TEXT, " +
                UdiseContract.RawData.COLUMN_IS_RESIDENT_SCHOOL + " INTEGER, " +
                UdiseContract.RawData.COLUMN_RESIDENT_SCHOOL_TYPE + " INTEGER, " +
                UdiseContract.RawData.COLUMN_IS_SHIFT_SCHOOL + " INTEGER, " +
                UdiseContract.RawData.COLUMN_IS_CWSN_SCHOOL + " INTEGER, " +
                UdiseContract.RawData.COLUMN_RURAL_OR_URBAN_CODE + " INTEGER, " +
                UdiseContract.RawData.COLUMN_RURAL_OR_URBAN + " TEXT, " +
                UdiseContract.RawData.COLUMN_IS_SCHOOL_APPROACHABLE_BY_ALL_WEATHER_ROADS + " TEXT, " +
                UdiseContract.RawData.COLUMN_STATE_NAME + " TEXT NOT NULL, " +
                UdiseContract.RawData.COLUMN_DISTRICT_CODE + " TEXT NOT NULL, " +
                UdiseContract.RawData.COLUMN_DISTRICT_NAME + " TEXT NOT NULL, " +
                UdiseContract.RawData.COLUMN_ZONE_CODE + " TEXT NOT NULL, " +
                UdiseContract.RawData.COLUMN_ZONE_NAME + " TEXT NOT NULL, " +
                UdiseContract.RawData.COLUMN_CLUSTER_CODE + " TEXT NOT NULL, " +
                UdiseContract.RawData.COLUMN_CLUSTER_NAME + " TEXT NOT NULL, " +
                UdiseContract.RawData.COLUMN_VILLAGE_CODE + " TEXT, " +
                UdiseContract.RawData.COLUMN_VILLAGE_NAME + " TEXT, " +
                UdiseContract.RawData.COLUMN_ASSEMBLY_CONSTITUENCY_CODE + " TEXT, " +
                UdiseContract.RawData.COLUMN_ASSEMBLY_CONSTITUENCY_NAME + " TEXT, " +
                UdiseContract.RawData.COLUMN_PARLIAMENTARY_CONSTITUENCY_CODE + " TEXT, " +
                UdiseContract.RawData.COLUMN_EDUCATIONAL_BLOCK_CODE + " TEXT, " +
                UdiseContract.RawData.COLUMN_EDUCATIONAL_BLOCK_NAME + " TEXT, " +
                UdiseContract.RawData.COLUMN_PANCHAYAT_CODE + " TEXT, " +
                UdiseContract.RawData.COLUMN_PANCHAYAT_NAME + " TEXT, " +
                UdiseContract.RawData.COLUMN_HABITATION_CODE + " TEXT, " +
                UdiseContract.RawData.COLUMN_HABITATION_NAME + " TEXT, " +
                UdiseContract.RawData.COLUMN_MUNICIPALITY_CODE + " TEXT, " +
                UdiseContract.RawData.COLUMN_MUNICIPALITY_NAME + " TEXT, " +
                UdiseContract.RawData.COLUMN_CITY_CODE + " TEXT, " +
                UdiseContract.RawData.COLUMN_CITY_NAME + " TEXT, " +
                UdiseContract.RawData.COLUMN_POSTAL_ADDRESS + " TEXT, " +
                UdiseContract.RawData.COLUMN_SCHOOL_PINCODE + " TEXT, " +
                UdiseContract.RawData.COLUMN_LATITUDE_DEGREES + " INTEGER, " +
                UdiseContract.RawData.COLUMN_LATITUDE_MINUTES + " INTEGER, " +
                UdiseContract.RawData.COLUMN_LATITUDE_SECONDS + " INTEGER, " +
                UdiseContract.RawData.COLUMN_LONGITUDE_DEGREES + " INTEGER, " +
                UdiseContract.RawData.COLUMN_LONGITUDE_MINUTES + " INTEGER, " +
                UdiseContract.RawData.COLUMN_LONGITUDE_SECONDS + " INTEGER, " +
                UdiseContract.RawData.COLUMN_STD_CODE_1 + " TEXT, " +
                UdiseContract.RawData.COLUMN_LANDLINE_PHONE_1 + " TEXT, " +
                UdiseContract.RawData.COLUMN_STD_CODE_2 + " TEXT, " +
                UdiseContract.RawData.COLUMN_LANDLINE_PHONE_2 + " TEXT, " +
                UdiseContract.RawData.COLUMN_MOBILE_1 + " TEXT, " +
                UdiseContract.RawData.COLUMN_MOBILE_2 + " TEXT, " +
                UdiseContract.RawData.COLUMN_EMAIL + " TEXT, " +
                UdiseContract.RawData.COLUMN_WEBSITE + " TEXT, " +
                UdiseContract.RawData.COLUMN_SCHOOL_ESTABLISHED_YEAR + " INTEGER, " +
                UdiseContract.RawData.COLUMN_YEAR_OF_RECOGNITION_ELEMENTARY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_YEAR_OF_RECOGNITION_SECONDARY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_YEAR_OF_RECOGNITION_HIGHER_SECONDARY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_YEAR_OF_UPGRADATION_PRIMARY_TO_UPPER_PRIMARY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_YEAR_OF_UPGRADATION_ELEMENTARY_TO_SECONDARY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_YEAR_OF_UPGRADATION_SECONDARY_TO_HIGHER_SECONDARY + " INTEGER, " +

                UdiseContract.RawData.COLUMN_SCHOOL_HAS_PREPRIMARY_SECTION + " INTEGER, " +
                UdiseContract.RawData.COLUMN_TOTAL_PREPRIMARY_ENROLMENT + "  INTEGER, " +
                UdiseContract.RawData.COLUMN_TOTAL_PREPRIMARY_TEACHERS + " INTEGER, " +
                UdiseContract.RawData.COLUMN_ANGANWADI_CENTRE_IN_OR_AROUND_SCHOOL + " INTEGER, " +
                UdiseContract.RawData.COLUMN_ANGANWADI_STUDENTS + " INTEGER, " +
                UdiseContract.RawData.COLUMN_ANGANWADI_TEACHERS + " INTEGER, " +

                UdiseContract.RawData.COLUMN_BOARD_AFFILIATION_TYPE_SECONDARY_LEVEL + " INTEGER, " +
                UdiseContract.RawData.COLUMN_BOARD_AFFILIATION_TYPE_HIGHER_SECONDARY_LEVEL + " INTEGER, " +
                UdiseContract.RawData.COLUMN_BOARD_AFFILIATION_NUMBER_SECONDARY_LEVEL + " TEXT, " +
                UdiseContract.RawData.COLUMN_BOARD_AFFILIATION_NUMBER_HIGHER_SECONDARY_LEVEL + " TEXT, " +
                UdiseContract.RawData.COLUMN_BOARD_OTHER_TYPE_NAME_SECONDARY_LEVEL + " TEXT, " +
                UdiseContract.RawData.COLUMN_BOARD_OTHER_TYPE_NAME_HIGHER_SECONDARY_LEVEL + " TEXT, " +

                UdiseContract.RawData.COLUMN_SCHOOL_MANAGEMENT_DESCRIPTION + " TEXT, " +
                UdiseContract.RawData.COLUMN_SCHOOL_MANAGEMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_SCHOOL_CATEGORY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_SCHOOL_CATEGORY_DESCRIPTION + " TEXT, " +

                UdiseContract.RawData.COLUMN_SCHOOL_HAS_BOARDING_AT_PRIMARY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_BOARDING_PRIMARY_BOYS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_BOARDING_PRIMARY_GIRLS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_SCHOOL_HAS_BOARDING_AT_UPPER_PRIMARY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_BOARDING_UPPER_PRIMARY_BOYS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_BOARDING_UPPER_PRIMARY_GIRLS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_SCHOOL_HAS_BOARDING_AT_SECONDARY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_BOARDING_SECONDARY_BOYS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_BOARDING_SECONDARY_GIRLS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_SCHOOL_HAS_BOARDING_AT_HIGHER_SECONDARY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_BOARDING_HIGHER_SECONDARY_BOYS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_BOARDING_HIGHER_SECONDARY_GIRLS_ENROLMENT + " INTEGER, " +

                UdiseContract.RawData.COLUMN_ACADEMIC_INSPECTIONS_LAST_AC_YEAR + " INTEGER, " +
                UdiseContract.RawData.COLUMN_VISITS_BY_CRC_COORDINATOR + " INTEGER, " +
                UdiseContract.RawData.COLUMN_VISITS_BY_BRC_COORDINATOR + " INTEGER, " +
                UdiseContract.RawData.COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_DEVELOPMENT_GRANT_RECEIPT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_DEVELOPMENT_GRANT_EXPENDITURE + " INTEGER, " +
                UdiseContract.RawData.COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_TLM_TEACHER_GRANT_RECEIPT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_TLM_TEACHER_GRANT_EXPENDITURE + " INTEGER, " +
                UdiseContract.RawData.COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_MAINTENANCE_GRANT_RECEIPT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_MAINTENANCE_GRANT_EXPENDITURE + " INTEGER, " +

                UdiseContract.RawData.COLUMN_MEDIUM_OF_INSTRUCTION_1 + " INTEGER, " +
                UdiseContract.RawData.COLUMN_MEDIUM_OF_INSTRUCTION_2 + " INTEGER, " +
                UdiseContract.RawData.COLUMN_MEDIUM_OF_INSTRUCTION_3 + " INTEGER, " +
                UdiseContract.RawData.COLUMN_MEDIUM_OF_INSTRUCTION_4 + " INTEGER, " +
                UdiseContract.RawData.COLUMN_DISTANCE_PRIMARY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_DISTANCE_UPPER_PRIMARY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_DISTANCE_SECONDARY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_DISTANCE_HIGHER_SECONDARY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_PRE_PRIMARY_SECTIONS + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_1_SEC + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_2_SEC + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_3_SEC + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_4_SEC + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_5_SEC + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_6_SEC + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_7_SEC + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_8_SEC + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_9_SEC + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_10_SEC + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_11_SEC + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_12_SEC + " INTEGER, " +

                UdiseContract.RawData.COLUMN_PRE_PRIMARY_BOYS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_PRE_PRIMARY_GIRLS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_1_BOYS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_1_GIRLS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_2_BOYS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_2_GIRLS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_3_BOYS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_3_GIRLS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_4_BOYS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_4_GIRLS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_5_BOYS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_5_GIRLS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_6_BOYS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_6_GIRLS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_7_BOYS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_7_GIRLS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_8_BOYS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_8_GIRLS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_9_BOYS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_9_GIRLS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_10_BOYS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_10_GIRLS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_11_BOYS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_11_GIRLS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_12_BOYS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_CLASS_12_GIRLS_ENROLMENT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_TOTAL_TEACHERS_MALE + " INTEGER, " +
                UdiseContract.RawData.COLUMN_TOTAL_TEACHERS_FEMALE + " INTEGER, " +
                UdiseContract.RawData.COLUMN_TOTAL_TEACHERS_PRIMARY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_TOTAL_TEACHERS_UPPER_PRIMARY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_TOTAL_TEACHERS_SECONDARY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_TOTAL_TEACHERS_HIGHER_SECONDARY + " INTEGER, " +
                UdiseContract.RawData.COLUMN_TOTAL_REGULAR_TEACHERS + " INTEGER, " +
                UdiseContract.RawData.COLUMN_TOTAL_CONTRACT_TEACHERS + " INTEGER, " +
                UdiseContract.RawData.COLUMN_TOTAL_PARTTIME_TEACHERS + " INTEGER, " +
                UdiseContract.RawData.COLUMN_TEACHERS_CWSN_TRAINED + " INTEGER, " +
                UdiseContract.RawData.COLUMN_TEACHERS_WITH_DISABILITIES + " INTEGER, " +

                UdiseContract.RawData.COLUMN_TEACHERS_SANCTIONED + " INTEGER, " +
                UdiseContract.RawData.COLUMN_TEACHERS_IN_POSITION + " INTEGER, " +
                UdiseContract.RawData.COLUMN_PARA_TEAHCERS_IN_POSITION + " INTEGER, " +
                UdiseContract.RawData.COLUMN_NON_TEACHING_STAFF_IN_POSITION + " INTEGER, " +

                UdiseContract.RawData.COLUMN_DISTRICT_HQ + " INTEGER, " +
                UdiseContract.RawData.COLUMN_DISTRICT_CRC + " INTEGER, " +
                UdiseContract.RawData.COLUMN_WORK_DAYS + " INTEGER, " +
                UdiseContract.RawData.COLUMN_FUNDS_RECEIPT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_FUNDS_EXPENDITURE + " INTEGER, " +
                UdiseContract.RawData.COLUMN_OSRC_RECEIPT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_OSRC_EXPENDITURE + " INTEGER, " +
                UdiseContract.RawData.COLUMN_TLE_RECEIPT + " INTEGER, " +
                UdiseContract.RawData.COLUMN_TLE_EXPENDITURE + " INTEGER, " +

                UdiseContract.RawData.COLUMN_ROW_DATA_VERSION + " INTEGER DEFAULT 1, " +
                UdiseContract.RawData.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +

                /*
                 * Unique constraint to ensure that a school is inserted only once per academic year
                 */
                " CONSTRAINT UNIQUE_SCHOOLS UNIQUE(" + UdiseContract.RawData.COLUMN_AC_YEAR + ", "
                + UdiseContract.RawData.COLUMN_UDISE_SCHOOL_CODE + ") ON CONFLICT REPLACE " +
                " );";

        db.execSQL(SQL_CREATE_TABLE_UDISE_RAW_DATA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    /*
     * This method accepts an ArrayList of strings containing indexed cells of one excel row
     * The method converts the ArrayList into ContentValues for later usage by
     * insert method of Content Provider
     *
     * All the columns of UDISE Excel Raw Data are not implemented in this app. So the index
     * in the oneExcelRowCellsString.get() may not be continuous
     */
    public ContentValues convertExcelRowToContentValues(ArrayList<String> oneExcelRowCellsString){
        ContentValues contentValues = new ContentValues();
        contentValues.put(UdiseContract.RawData.COLUMN_AC_YEAR,oneExcelRowCellsString.get(0));
        contentValues.put(UdiseContract.RawData.COLUMN_STATE_NAME,oneExcelRowCellsString.get(1));
        contentValues.put(UdiseContract.RawData.COLUMN_DISTRICT_CODE,oneExcelRowCellsString.get(2));
        contentValues.put(UdiseContract.RawData.COLUMN_DISTRICT_NAME,oneExcelRowCellsString.get(3));
        contentValues.put(UdiseContract.RawData.COLUMN_ZONE_CODE,oneExcelRowCellsString.get(4));
        contentValues.put(UdiseContract.RawData.COLUMN_ZONE_NAME,oneExcelRowCellsString.get(5));
        contentValues.put(UdiseContract.RawData.COLUMN_CLUSTER_CODE,oneExcelRowCellsString.get(6));
        contentValues.put(UdiseContract.RawData.COLUMN_CLUSTER_NAME,oneExcelRowCellsString.get(7));
        contentValues.put(UdiseContract.RawData.COLUMN_VILLAGE_CODE,oneExcelRowCellsString.get(8));
        contentValues.put(UdiseContract.RawData.COLUMN_VILLAGE_NAME,oneExcelRowCellsString.get(9));
        contentValues.put(UdiseContract.RawData.COLUMN_UDISE_SCHOOL_CODE,oneExcelRowCellsString.get(10));
        contentValues.put(UdiseContract.RawData.COLUMN_UNIQUE_UDISE_SCHOOL_CODE,oneExcelRowCellsString.get(11));
        contentValues.put(UdiseContract.RawData.COLUMN_SCHOOL_NAME,oneExcelRowCellsString.get(12));
        contentValues.put(UdiseContract.RawData.COLUMN_SCHOOL_OPERATIONAL_STATUS,oneExcelRowCellsString.get(13));
        contentValues.put(UdiseContract.RawData.COLUMN_PANCHAYAT_CODE,oneExcelRowCellsString.get(14));
        contentValues.put(UdiseContract.RawData.COLUMN_PANCHAYAT_NAME,oneExcelRowCellsString.get(15));
        contentValues.put(UdiseContract.RawData.COLUMN_HABITATION_CODE,oneExcelRowCellsString.get(16));
        contentValues.put(UdiseContract.RawData.COLUMN_HABITATION_NAME,oneExcelRowCellsString.get(17));
        contentValues.put(UdiseContract.RawData.COLUMN_MUNICIPALITY_CODE,oneExcelRowCellsString.get(18));
        contentValues.put(UdiseContract.RawData.COLUMN_MUNICIPALITY_NAME,oneExcelRowCellsString.get(19));
        contentValues.put(UdiseContract.RawData.COLUMN_CITY_CODE,oneExcelRowCellsString.get(20));
        contentValues.put(UdiseContract.RawData.COLUMN_CITY_NAME,oneExcelRowCellsString.get(21));
        contentValues.put(UdiseContract.RawData.COLUMN_ASSEMBLY_CONSTITUENCY_CODE,oneExcelRowCellsString.get(22));
        contentValues.put(UdiseContract.RawData.COLUMN_ASSEMBLY_CONSTITUENCY_NAME,oneExcelRowCellsString.get(23));
        contentValues.put(UdiseContract.RawData.COLUMN_EDUCATIONAL_BLOCK_CODE,oneExcelRowCellsString.get(24));
        contentValues.put(UdiseContract.RawData.COLUMN_EDUCATIONAL_BLOCK_NAME,oneExcelRowCellsString.get(25));
        contentValues.put(UdiseContract.RawData.COLUMN_SCHOOL_MANAGEMENT_DESCRIPTION,oneExcelRowCellsString.get(26));
        contentValues.put(UdiseContract.RawData.COLUMN_SCHOOL_MANAGEMENT,oneExcelRowCellsString.get(27));
        contentValues.put(UdiseContract.RawData.COLUMN_SCHOOL_CATEGORY,oneExcelRowCellsString.get(28));
        contentValues.put(UdiseContract.RawData.COLUMN_RURAL_OR_URBAN_CODE,oneExcelRowCellsString.get(29));
        contentValues.put(UdiseContract.RawData.COLUMN_SCHOOL_CATEGORY_DESCRIPTION,oneExcelRowCellsString.get(30));
        contentValues.put(UdiseContract.RawData.COLUMN_RURAL_OR_URBAN,oneExcelRowCellsString.get(31));
        contentValues.put(UdiseContract.RawData.COLUMN_SCHOOL_COEDUCATION_TYPE,oneExcelRowCellsString.get(32));
        contentValues.put(UdiseContract.RawData.COLUMN_IS_RELIGIOUS_MINORITY_SCHOOL,oneExcelRowCellsString.get(33));
        contentValues.put(UdiseContract.RawData.COLUMN_RELIGIOUS_MINORITY_TYPE,oneExcelRowCellsString.get(34));
        contentValues.put(UdiseContract.RawData.COLUMN_SCHOOL_PINCODE,oneExcelRowCellsString.get(35));
        contentValues.put(UdiseContract.RawData.COLUMN_DISTRICT_HQ,oneExcelRowCellsString.get(36));
        contentValues.put(UdiseContract.RawData.COLUMN_DISTRICT_CRC,oneExcelRowCellsString.get(37));
        contentValues.put(UdiseContract.RawData.COLUMN_SCHOOL_ESTABLISHED_YEAR,oneExcelRowCellsString.get(38));
        contentValues.put(UdiseContract.RawData.COLUMN_LOWEST_CLASS,oneExcelRowCellsString.get(39));
        contentValues.put(UdiseContract.RawData.COLUMN_HIGHEST_CLASS,oneExcelRowCellsString.get(40));
        contentValues.put(UdiseContract.RawData.COLUMN_SCHOOL_HAS_PREPRIMARY_SECTION,oneExcelRowCellsString.get(41));
        contentValues.put(UdiseContract.RawData.COLUMN_TOTAL_PREPRIMARY_ENROLMENT,oneExcelRowCellsString.get(42));
        contentValues.put(UdiseContract.RawData.COLUMN_TOTAL_PREPRIMARY_TEACHERS,oneExcelRowCellsString.get(43));
        contentValues.put(UdiseContract.RawData.COLUMN_WORK_DAYS,oneExcelRowCellsString.get(44));
        contentValues.put(UdiseContract.RawData.COLUMN_IS_RESIDENT_SCHOOL,oneExcelRowCellsString.get(45));
        contentValues.put(UdiseContract.RawData.COLUMN_RESIDENT_SCHOOL_TYPE,oneExcelRowCellsString.get(46));
        contentValues.put(UdiseContract.RawData.COLUMN_IS_SHIFT_SCHOOL,oneExcelRowCellsString.get(47));
        contentValues.put(UdiseContract.RawData.COLUMN_ACADEMIC_INSPECTIONS_LAST_AC_YEAR,oneExcelRowCellsString.get(48));
        contentValues.put(UdiseContract.RawData.COLUMN_VISITS_BY_CRC_COORDINATOR,oneExcelRowCellsString.get(49));
        contentValues.put(UdiseContract.RawData.COLUMN_VISITS_BY_BRC_COORDINATOR,oneExcelRowCellsString.get(50));
        contentValues.put(UdiseContract.RawData.COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_DEVELOPMENT_GRANT_RECEIPT,oneExcelRowCellsString.get(51));
        contentValues.put(UdiseContract.RawData.COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_DEVELOPMENT_GRANT_EXPENDITURE,oneExcelRowCellsString.get(52));
        contentValues.put(UdiseContract.RawData.COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_TLM_TEACHER_GRANT_RECEIPT,oneExcelRowCellsString.get(53));
        contentValues.put(UdiseContract.RawData.COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_TLM_TEACHER_GRANT_EXPENDITURE,oneExcelRowCellsString.get(54));
        contentValues.put(UdiseContract.RawData.COLUMN_FUNDS_EXPENDITURE,oneExcelRowCellsString.get(55));
        contentValues.put(UdiseContract.RawData.COLUMN_FUNDS_RECEIPT,oneExcelRowCellsString.get(56));
        contentValues.put(UdiseContract.RawData.COLUMN_OSRC_EXPENDITURE,oneExcelRowCellsString.get(57));
        contentValues.put(UdiseContract.RawData.COLUMN_OSRC_RECEIPT,oneExcelRowCellsString.get(58));
        contentValues.put(UdiseContract.RawData.COLUMN_TEACHERS_SANCTIONED,oneExcelRowCellsString.get(59));
        contentValues.put(UdiseContract.RawData.COLUMN_TEACHERS_IN_POSITION,oneExcelRowCellsString.get(60));
        contentValues.put(UdiseContract.RawData.COLUMN_PARA_TEAHCERS_IN_POSITION,oneExcelRowCellsString.get(61));
        contentValues.put(UdiseContract.RawData.COLUMN_NON_TEACHING_STAFF_IN_POSITION,oneExcelRowCellsString.get(62));
        contentValues.put(UdiseContract.RawData.COLUMN_MEDIUM_OF_INSTRUCTION_1,oneExcelRowCellsString.get(63));
        contentValues.put(UdiseContract.RawData.COLUMN_MEDIUM_OF_INSTRUCTION_2,oneExcelRowCellsString.get(64));
        contentValues.put(UdiseContract.RawData.COLUMN_MEDIUM_OF_INSTRUCTION_3,oneExcelRowCellsString.get(65));
        contentValues.put(UdiseContract.RawData.COLUMN_MEDIUM_OF_INSTRUCTION_4,oneExcelRowCellsString.get(66));
        contentValues.put(UdiseContract.RawData.COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_MAINTENANCE_GRANT_RECEIPT,oneExcelRowCellsString.get(72));
        contentValues.put(UdiseContract.RawData.COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_MAINTENANCE_GRANT_EXPENDITURE,oneExcelRowCellsString.get(73));
        contentValues.put(UdiseContract.RawData.COLUMN_TLE_RECEIPT,oneExcelRowCellsString.get(74));
        contentValues.put(UdiseContract.RawData.COLUMN_TLE_EXPENDITURE,oneExcelRowCellsString.get(75));
        contentValues.put(UdiseContract.RawData.COLUMN_POSTAL_ADDRESS,oneExcelRowCellsString.get(76));
        contentValues.put(UdiseContract.RawData.COLUMN_STD_CODE_1,oneExcelRowCellsString.get(77));
        contentValues.put(UdiseContract.RawData.COLUMN_LANDLINE_PHONE_1,oneExcelRowCellsString.get(78));
        contentValues.put(UdiseContract.RawData.COLUMN_MOBILE_1,oneExcelRowCellsString.get(79));
        contentValues.put(UdiseContract.RawData.COLUMN_STD_CODE_2,oneExcelRowCellsString.get(80));
        contentValues.put(UdiseContract.RawData.COLUMN_LANDLINE_PHONE_2,oneExcelRowCellsString.get(81));
        contentValues.put(UdiseContract.RawData.COLUMN_MOBILE_2,oneExcelRowCellsString.get(82));
        contentValues.put(UdiseContract.RawData.COLUMN_EMAIL,oneExcelRowCellsString.get(83));
        contentValues.put(UdiseContract.RawData.COLUMN_WEBSITE,oneExcelRowCellsString.get(84));
        contentValues.put(UdiseContract.RawData.COLUMN_ANGANWADI_CENTRE_IN_OR_AROUND_SCHOOL,oneExcelRowCellsString.get(103));
        contentValues.put(UdiseContract.RawData.COLUMN_ANGANWADI_STUDENTS,oneExcelRowCellsString.get(104));
        contentValues.put(UdiseContract.RawData.COLUMN_ANGANWADI_TEACHERS,oneExcelRowCellsString.get(105));
        contentValues.put(UdiseContract.RawData.COLUMN_LATITUDE_DEGREES,oneExcelRowCellsString.get(106));
        contentValues.put(UdiseContract.RawData.COLUMN_LATITUDE_MINUTES,oneExcelRowCellsString.get(107));
        contentValues.put(UdiseContract.RawData.COLUMN_LATITUDE_SECONDS,oneExcelRowCellsString.get(108));
        contentValues.put(UdiseContract.RawData.COLUMN_LONGITUDE_DEGREES,oneExcelRowCellsString.get(109));
        contentValues.put(UdiseContract.RawData.COLUMN_LONGITUDE_MINUTES,oneExcelRowCellsString.get(110));
        contentValues.put(UdiseContract.RawData.COLUMN_LONGITUDE_SECONDS,oneExcelRowCellsString.get(111));
        contentValues.put(UdiseContract.RawData.COLUMN_IS_SCHOOL_APPROACHABLE_BY_ALL_WEATHER_ROADS,oneExcelRowCellsString.get(112));
        contentValues.put(UdiseContract.RawData.COLUMN_YEAR_OF_RECOGNITION_ELEMENTARY,oneExcelRowCellsString.get(113));
        contentValues.put(UdiseContract.RawData.COLUMN_YEAR_OF_UPGRADATION_PRIMARY_TO_UPPER_PRIMARY,oneExcelRowCellsString.get(114));
        contentValues.put(UdiseContract.RawData.COLUMN_IS_CWSN_SCHOOL,oneExcelRowCellsString.get(116));
        contentValues.put(UdiseContract.RawData.COLUMN_DISTANCE_PRIMARY,oneExcelRowCellsString.get(117));
        contentValues.put(UdiseContract.RawData.COLUMN_DISTANCE_UPPER_PRIMARY,oneExcelRowCellsString.get(118));
        contentValues.put(UdiseContract.RawData.COLUMN_DISTANCE_SECONDARY,oneExcelRowCellsString.get(119));
        contentValues.put(UdiseContract.RawData.COLUMN_DISTANCE_HIGHER_SECONDARY,oneExcelRowCellsString.get(120));
        contentValues.put(UdiseContract.RawData.COLUMN_BOARD_AFFILIATION_TYPE_SECONDARY_LEVEL,oneExcelRowCellsString.get(129));
        contentValues.put(UdiseContract.RawData.COLUMN_BOARD_AFFILIATION_TYPE_HIGHER_SECONDARY_LEVEL,oneExcelRowCellsString.get(130));
        contentValues.put(UdiseContract.RawData.COLUMN_YEAR_OF_RECOGNITION_SECONDARY,oneExcelRowCellsString.get(131));
        contentValues.put(UdiseContract.RawData.COLUMN_YEAR_OF_RECOGNITION_HIGHER_SECONDARY,oneExcelRowCellsString.get(132));
        contentValues.put(UdiseContract.RawData.COLUMN_YEAR_OF_UPGRADATION_ELEMENTARY_TO_SECONDARY,oneExcelRowCellsString.get(133));
        contentValues.put(UdiseContract.RawData.COLUMN_YEAR_OF_UPGRADATION_SECONDARY_TO_HIGHER_SECONDARY,oneExcelRowCellsString.get(134));
        contentValues.put(UdiseContract.RawData.COLUMN_PARLIAMENTARY_CONSTITUENCY_CODE,oneExcelRowCellsString.get(138));
        contentValues.put(UdiseContract.RawData.COLUMN_PRE_PRIMARY_SECTIONS,oneExcelRowCellsString.get(139));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_1_SEC,oneExcelRowCellsString.get(140));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_2_SEC,oneExcelRowCellsString.get(141));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_3_SEC,oneExcelRowCellsString.get(142));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_4_SEC,oneExcelRowCellsString.get(143));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_5_SEC,oneExcelRowCellsString.get(144));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_6_SEC,oneExcelRowCellsString.get(145));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_7_SEC,oneExcelRowCellsString.get(146));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_8_SEC,oneExcelRowCellsString.get(147));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_9_SEC,oneExcelRowCellsString.get(148));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_10_SEC,oneExcelRowCellsString.get(149));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_11_SEC,oneExcelRowCellsString.get(150));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_12_SEC,oneExcelRowCellsString.get(151));
        contentValues.put(UdiseContract.RawData.COLUMN_SCHOOL_HAS_BOARDING_AT_PRIMARY,oneExcelRowCellsString.get(152));
        contentValues.put(UdiseContract.RawData.COLUMN_BOARDING_PRIMARY_GIRLS_ENROLMENT,oneExcelRowCellsString.get(153));
        contentValues.put(UdiseContract.RawData.COLUMN_BOARDING_PRIMARY_BOYS_ENROLMENT,oneExcelRowCellsString.get(154));
        contentValues.put(UdiseContract.RawData.COLUMN_SCHOOL_HAS_BOARDING_AT_UPPER_PRIMARY,oneExcelRowCellsString.get(155));
        contentValues.put(UdiseContract.RawData.COLUMN_BOARDING_UPPER_PRIMARY_GIRLS_ENROLMENT,oneExcelRowCellsString.get(156));
        contentValues.put(UdiseContract.RawData.COLUMN_BOARDING_UPPER_PRIMARY_BOYS_ENROLMENT,oneExcelRowCellsString.get(157));
        contentValues.put(UdiseContract.RawData.COLUMN_SCHOOL_HAS_BOARDING_AT_SECONDARY,oneExcelRowCellsString.get(158));
        contentValues.put(UdiseContract.RawData.COLUMN_BOARDING_SECONDARY_GIRLS_ENROLMENT,oneExcelRowCellsString.get(159));
        contentValues.put(UdiseContract.RawData.COLUMN_BOARDING_SECONDARY_BOYS_ENROLMENT,oneExcelRowCellsString.get(160));
        contentValues.put(UdiseContract.RawData.COLUMN_SCHOOL_HAS_BOARDING_AT_HIGHER_SECONDARY,oneExcelRowCellsString.get(161));
        contentValues.put(UdiseContract.RawData.COLUMN_BOARDING_HIGHER_SECONDARY_GIRLS_ENROLMENT,oneExcelRowCellsString.get(162));
        contentValues.put(UdiseContract.RawData.COLUMN_BOARDING_HIGHER_SECONDARY_BOYS_ENROLMENT,oneExcelRowCellsString.get(163));
        contentValues.put(UdiseContract.RawData.COLUMN_BOARD_AFFILIATION_NUMBER_SECONDARY_LEVEL,oneExcelRowCellsString.get(164));
        contentValues.put(UdiseContract.RawData.COLUMN_BOARD_OTHER_TYPE_NAME_SECONDARY_LEVEL,oneExcelRowCellsString.get(165));
        contentValues.put(UdiseContract.RawData.COLUMN_BOARD_AFFILIATION_NUMBER_HIGHER_SECONDARY_LEVEL,oneExcelRowCellsString.get(166));
        contentValues.put(UdiseContract.RawData.COLUMN_BOARD_OTHER_TYPE_NAME_HIGHER_SECONDARY_LEVEL,oneExcelRowCellsString.get(167));
        contentValues.put(UdiseContract.RawData.COLUMN_PRE_PRIMARY_BOYS_ENROLMENT,oneExcelRowCellsString.get(172));
        contentValues.put(UdiseContract.RawData.COLUMN_PRE_PRIMARY_GIRLS_ENROLMENT,oneExcelRowCellsString.get(173));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_1_BOYS_ENROLMENT,oneExcelRowCellsString.get(174));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_1_GIRLS_ENROLMENT,oneExcelRowCellsString.get(175));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_2_BOYS_ENROLMENT,oneExcelRowCellsString.get(176));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_2_GIRLS_ENROLMENT,oneExcelRowCellsString.get(177));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_3_BOYS_ENROLMENT,oneExcelRowCellsString.get(178));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_3_GIRLS_ENROLMENT,oneExcelRowCellsString.get(179));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_4_BOYS_ENROLMENT,oneExcelRowCellsString.get(180));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_4_GIRLS_ENROLMENT,oneExcelRowCellsString.get(181));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_5_BOYS_ENROLMENT,oneExcelRowCellsString.get(182));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_5_GIRLS_ENROLMENT,oneExcelRowCellsString.get(183));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_6_BOYS_ENROLMENT,oneExcelRowCellsString.get(184));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_6_GIRLS_ENROLMENT,oneExcelRowCellsString.get(185));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_7_BOYS_ENROLMENT,oneExcelRowCellsString.get(186));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_7_GIRLS_ENROLMENT,oneExcelRowCellsString.get(187));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_8_BOYS_ENROLMENT,oneExcelRowCellsString.get(188));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_8_GIRLS_ENROLMENT,oneExcelRowCellsString.get(189));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_9_BOYS_ENROLMENT,oneExcelRowCellsString.get(190));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_9_GIRLS_ENROLMENT,oneExcelRowCellsString.get(191));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_10_BOYS_ENROLMENT,oneExcelRowCellsString.get(192));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_10_GIRLS_ENROLMENT,oneExcelRowCellsString.get(193));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_11_BOYS_ENROLMENT,oneExcelRowCellsString.get(194));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_11_GIRLS_ENROLMENT,oneExcelRowCellsString.get(195));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_12_BOYS_ENROLMENT,oneExcelRowCellsString.get(196));
        contentValues.put(UdiseContract.RawData.COLUMN_CLASS_12_GIRLS_ENROLMENT,oneExcelRowCellsString.get(197));
        contentValues.put(UdiseContract.RawData.COLUMN_TOTAL_TEACHERS_MALE,oneExcelRowCellsString.get(198));
        contentValues.put(UdiseContract.RawData.COLUMN_TOTAL_TEACHERS_FEMALE,oneExcelRowCellsString.get(199));
        contentValues.put(UdiseContract.RawData.COLUMN_TOTAL_TEACHERS_PRIMARY,oneExcelRowCellsString.get(201));
        contentValues.put(UdiseContract.RawData.COLUMN_TOTAL_TEACHERS_UPPER_PRIMARY,oneExcelRowCellsString.get(202));
        contentValues.put(UdiseContract.RawData.COLUMN_TOTAL_TEACHERS_SECONDARY,oneExcelRowCellsString.get(203));
        contentValues.put(UdiseContract.RawData.COLUMN_TOTAL_TEACHERS_HIGHER_SECONDARY,oneExcelRowCellsString.get(204));
        contentValues.put(UdiseContract.RawData.COLUMN_TEACHERS_CWSN_TRAINED,oneExcelRowCellsString.get(206));
        contentValues.put(UdiseContract.RawData.COLUMN_TEACHERS_WITH_DISABILITIES,oneExcelRowCellsString.get(207));
        contentValues.put(UdiseContract.RawData.COLUMN_TOTAL_REGULAR_TEACHERS,oneExcelRowCellsString.get(208));
        contentValues.put(UdiseContract.RawData.COLUMN_TOTAL_CONTRACT_TEACHERS,oneExcelRowCellsString.get(209));
        contentValues.put(UdiseContract.RawData.COLUMN_TOTAL_PARTTIME_TEACHERS,oneExcelRowCellsString.get(210));

        return contentValues;
    }



    /**
     * This method takes district code, district name, academic year and returns a list of type NumberOfSchoolsModel
     * The first item in the list contains the summary of the district and each subsequent item in the list
     * contains details of the respective zones.
     * Each item in the list contains number of primary, middle, high and higher secondary schools for each management type
     *
     * @param context the context from which called
     * @param districtCode four digit district UDISE code passed as a {@link String}.
     * @param districtName name of the district for which zone wise number of schools is to be found
     * @param academicYear academic year passed as a {@link String} e.g., 2017-18
     *
     * @return a list of type {@link NumberOfSchoolsModel} which contains number of each category of schools for each management
     *         The first item in the list contains the summary of the district. Rest of the items contain details, one for each zone
     *
     */

    public List<NumberOfSchoolsModel> zonewiseNumberOfSchools(Context context,String districtCode, String districtName, String academicYear){

        Cursor returnedCursor;

        List<NumberOfSchoolsModel> numberOfSchoolsModelList = new ArrayList<NumberOfSchoolsModel>();

        String[] projection = {
                UdiseContract.RawData.COLUMN_UDISE_SCHOOL_CODE,
                UdiseContract.RawData.COLUMN_ZONE_CODE,
                UdiseContract.RawData.COLUMN_ZONE_NAME,
                UdiseContract.RawData.COLUMN_SCHOOL_MANAGEMENT,
                UdiseContract.RawData.COLUMN_SCHOOL_MANAGEMENT_DESCRIPTION,
                UdiseContract.RawData.COLUMN_SCHOOL_CATEGORY
        };

        String selectionString = UdiseContract.RawData.COLUMN_DISTRICT_CODE + " = ? and " + UdiseContract.RawData.COLUMN_AC_YEAR + " = ?";

        String[] selectionArguments = {districtCode, academicYear};

        returnedCursor = context.getContentResolver().query(UdiseContract.RawData.CONTENT_URI,projection,selectionString,selectionArguments,null);

        if(returnedCursor!=null){

            Set<String> schoolManagementSet = new HashSet<String>();
            Set<String> zoneCodeSet = new HashSet<String>();

            ArrayList<ContentValues> zoneInfoList = new ArrayList<ContentValues>();
            ArrayList<ContentValues> managementInfoList = new ArrayList<ContentValues>();

            int indexColumnZoneName = returnedCursor.getColumnIndex(UdiseContract.RawData.COLUMN_ZONE_NAME);
            int indexColumnZoneCode = returnedCursor.getColumnIndex(UdiseContract.RawData.COLUMN_ZONE_CODE);
            int indexColumnSchoolManagementCode = returnedCursor.getColumnIndex(UdiseContract.RawData.COLUMN_SCHOOL_MANAGEMENT);
            int indexColumnSchoolManagementDescription = returnedCursor.getColumnIndex(UdiseContract.RawData.COLUMN_SCHOOL_MANAGEMENT_DESCRIPTION);
            int indexColumnSchoolCategoryCode = returnedCursor.getColumnIndex(UdiseContract.RawData.COLUMN_SCHOOL_CATEGORY);

            /*
             * Iterate over all the rows of the cursor and
             * Create a list of distinct values of zones and school managements
             * We only create distinct values of school managements for the whole district, not for each zone
             * So, if a zone has 4 managements and other one has only 2 managements we take into account the
             * 4 managements as it will show up in the district data.
             * Later while creating the returning list, we take steps to include only respective managements
             * in the corresponding zones
             */
            while(returnedCursor.moveToNext()){
                /*
                 * Try to add the zone code to the zoneCodeSet
                 * If the set accepts the zone code, it means it is a distinct value
                 * In that case we put the values of zone code and zone name in
                 * a content value list to use it later as values of sets cannot be directly
                 * used.
                 */
                if(zoneCodeSet.add(returnedCursor.getString(indexColumnZoneCode))){
                    ContentValues zoneInfo = new ContentValues();
                    zoneInfo.put(UdiseContract.RawData.COLUMN_ZONE_NAME,returnedCursor.getString(indexColumnZoneName));
                    zoneInfo.put(UdiseContract.RawData.COLUMN_ZONE_CODE,returnedCursor.getString(indexColumnZoneCode));
                    /*Add the above value to an array list*/
                    zoneInfoList.add(zoneInfo);
                }
                /*
                 * As with zones, try adding school management values to the Set and
                 * check if it succeeds. If the set accepts it (returns true) then it
                 * is a distinct value. So store it in a Content Value List for later use.
                 */
                if(schoolManagementSet.add(returnedCursor.getString(indexColumnSchoolManagementDescription))){
                    ContentValues managementInfo = new ContentValues();
                    managementInfo.put(UdiseContract.RawData.COLUMN_SCHOOL_MANAGEMENT,returnedCursor.getInt(indexColumnSchoolManagementCode));
                    managementInfo.put(UdiseContract.RawData.COLUMN_SCHOOL_MANAGEMENT_DESCRIPTION,returnedCursor.getString(indexColumnSchoolManagementDescription));
                    /*Add the above value to an array list*/
                    managementInfoList.add(managementInfo);
                }
            }

            /*
             * First, we count the number of schools for the whole district
             * and make it the first entry in the return list
             * Here we will count the number of primary, middle, high and higher secondary schools
             * for each management for the whole district
             */
            NumberOfSchoolsModel districtNumberOfSchoolsModel = new NumberOfSchoolsModel();
            districtNumberOfSchoolsModel.setModelType(NumberOfSchoolsModel.MODEL_TYPE_DISTRICT);
            districtNumberOfSchoolsModel.setDistrictCode(districtCode);
            districtNumberOfSchoolsModel.setDistrictName(districtName);
            List<NumberOfSchoolsModel.Management> districtManagementList = new ArrayList<NumberOfSchoolsModel.Management>();
            for(int mgmtCounter=0;mgmtCounter<managementInfoList.size();mgmtCounter++){
                NumberOfSchoolsModel.Management districtManagement = new NumberOfSchoolsModel.Management();

                districtManagement.setManagementName(managementInfoList.get(mgmtCounter).getAsString(UdiseContract.RawData.COLUMN_SCHOOL_MANAGEMENT_DESCRIPTION));
                for(int cursorRow=0;cursorRow<returnedCursor.getCount();cursorRow++){

                    returnedCursor.moveToPosition(cursorRow);
                    if(returnedCursor.getInt(indexColumnSchoolManagementCode)==managementInfoList.get(mgmtCounter).getAsInteger(UdiseContract.RawData.COLUMN_SCHOOL_MANAGEMENT)){
                        int schoolType = NumberOfSchoolsModel.determineSchoolType(returnedCursor.getInt(indexColumnSchoolCategoryCode));
                        switch (schoolType){
                            case NumberOfSchoolsModel.PRIMARY_SCHOOL:
                                /*
                                 * Increment total of each category grossly as well as management wise
                                 * e.g., total primary schools in the district as well as management wise
                                 * primary schools for each management in the district
                                 */
                                districtManagement.incrementPrimarySchools();
                                districtNumberOfSchoolsModel.incrementTotalPrimarySchools();
                                break;
                            case NumberOfSchoolsModel.MIDDLE_SCHOOL:
                                districtManagement.incrementMiddleSchools();
                                districtNumberOfSchoolsModel.incrementTotalMiddleSchools();
                                break;
                            case NumberOfSchoolsModel.HIGH_SCHOOL:
                                districtManagement.incrementHighSchools();
                                districtNumberOfSchoolsModel.incrementTotalHighSchools();
                                break;
                            case NumberOfSchoolsModel.HIGHER_SECONDARY_SCHOOL:
                                districtManagement.incrementHigherSecondarySchools();
                                districtNumberOfSchoolsModel.incrementTotalHigherSecondarySchools();
                                break;
                        }
                    }
                }
                /*
                 * Add this management to list if and only if there are any schools of this management type
                 * Otherwise just ignore this management type
                 */
                if(districtManagement.getPrimarySchools()>0 || districtManagement.getMiddleSchools()>0 || districtManagement.getHighSchools()>0 || districtManagement.getHigherSecondarySchools()>0){
                    districtManagementList.add(districtManagement);
                }
            }
            /*
             * Add this district entry to the return list
             * This will be the first list item in the return list
             */
            districtNumberOfSchoolsModel.setManagementList(districtManagementList);
            numberOfSchoolsModelList.add(districtNumberOfSchoolsModel);

            /*
             * District Entry ends here **********************
             */


            /*
             * Now we calculate number of schools for each zone for each management
             * Iterate for each management for each zone
             *
             */

            for(int zoneCounter=0;zoneCounter<zoneInfoList.size();zoneCounter++){
                NumberOfSchoolsModel numberOfSchoolsModel = new NumberOfSchoolsModel();

                numberOfSchoolsModel.setModelType(NumberOfSchoolsModel.MODEL_TYPE_ZONE);
                numberOfSchoolsModel.setDistrictCode(districtCode);
                numberOfSchoolsModel.setDistrictName(districtName);
                numberOfSchoolsModel.setZoneCode(zoneInfoList.get(zoneCounter).getAsString(UdiseContract.RawData.COLUMN_ZONE_CODE));
                numberOfSchoolsModel.setZoneName(zoneInfoList.get(zoneCounter).getAsString(UdiseContract.RawData.COLUMN_ZONE_NAME));


                List<NumberOfSchoolsModel.Management> managementList = new ArrayList<NumberOfSchoolsModel.Management>();
                for(int mgmtCounter=0;mgmtCounter<managementInfoList.size();mgmtCounter++){
                    NumberOfSchoolsModel.Management management = new NumberOfSchoolsModel.Management();

                    management.setManagementName(managementInfoList.get(mgmtCounter).getAsString(UdiseContract.RawData.COLUMN_SCHOOL_MANAGEMENT_DESCRIPTION));
                    for(int cursorRow=0;cursorRow<returnedCursor.getCount();cursorRow++){

                        returnedCursor.moveToPosition(cursorRow);
                        if(returnedCursor.getString(indexColumnZoneCode).equals(zoneInfoList.get(zoneCounter).getAsString(UdiseContract.RawData.COLUMN_ZONE_CODE))
                                && returnedCursor.getInt(indexColumnSchoolManagementCode)==managementInfoList.get(mgmtCounter).getAsInteger(UdiseContract.RawData.COLUMN_SCHOOL_MANAGEMENT)){
                            int schoolType = NumberOfSchoolsModel.determineSchoolType(returnedCursor.getInt(indexColumnSchoolCategoryCode));
                            switch (schoolType){
                                case NumberOfSchoolsModel.PRIMARY_SCHOOL:
                                    management.incrementPrimarySchools();
                                    numberOfSchoolsModel.incrementTotalPrimarySchools();
                                    break;
                                case NumberOfSchoolsModel.MIDDLE_SCHOOL:
                                    management.incrementMiddleSchools();
                                    numberOfSchoolsModel.incrementTotalMiddleSchools();
                                    break;
                                case NumberOfSchoolsModel.HIGH_SCHOOL:
                                    management.incrementHighSchools();
                                    numberOfSchoolsModel.incrementTotalHighSchools();
                                    break;
                                case NumberOfSchoolsModel.HIGHER_SECONDARY_SCHOOL:
                                    management.incrementHigherSecondarySchools();
                                    numberOfSchoolsModel.incrementTotalHigherSecondarySchools();
                                    break;
                            }
                        }
                    }

                    /*
                     * Add this management to list if and only if there are any schools of this management type
                     * Otherwise just ignore this management type
                     */
                    if(management.getPrimarySchools()>0 || management.getMiddleSchools()>0 || management.getHighSchools()>0 || management.getHigherSecondarySchools()>0){
                        managementList.add(management);
                    }
                }
                numberOfSchoolsModel.setManagementList(managementList);
                numberOfSchoolsModelList.add(numberOfSchoolsModel);
            }
            returnedCursor.close();
        }
        return numberOfSchoolsModelList;
    }


    /**
     * This method analyses the SQLite database and fills the {@link UserDataModel}
     * with the following data
     *  - Type of user (National/State/District/User)
     *  - List of Academic Years
     *  - List of States
     *  - List of Districts
     *  - List of Zones
     * @param context the context from which called
     * @return Returns the filled in UserDataModel containing information about the type of user
     * as well as the lists of academic years, states, districts and zones
     */

    public UserDataModel determineUserTypeAndDataModel(Context context){

        String[] projection = {
                UdiseContract.RawData.COLUMN_AC_YEAR,
                UdiseContract.RawData.COLUMN_STATE_NAME,
                UdiseContract.RawData.COLUMN_DISTRICT_CODE,
                UdiseContract.RawData.COLUMN_DISTRICT_NAME,
                UdiseContract.RawData.COLUMN_ZONE_CODE,
                UdiseContract.RawData.COLUMN_ZONE_NAME
        };

        //String selectionString = UdiseContract.RawData.COLUMN_DISTRICT_CODE + " = ? and " + UdiseContract.RawData.COLUMN_AC_YEAR + " = ?";
        String sortOrder = UdiseContract.RawData.COLUMN_AC_YEAR;
        //String[] selectionArguments = {districtCode, academicYear};
        Cursor cursor = context.getContentResolver().query(UdiseContract.RawData.CONTENT_URI,projection,null,null,sortOrder);

        if(cursor == null){
            Log.e(TAG,"Cursor is null!!!");
            return null;
        }

        Set<String> stateSet = new HashSet<String>();
        Set<String> districtSet = new HashSet<String>();
        Set<String> zoneSet = new HashSet<String>();
        Set<String> acyearSet = new HashSet<String>();

        int columnIndexStateName = cursor.getColumnIndex(UdiseContract.RawData.COLUMN_STATE_NAME);
        int columnIndexDistrictCode = cursor.getColumnIndex(UdiseContract.RawData.COLUMN_DISTRICT_CODE);
        int columnIndexDistrictName = cursor.getColumnIndex(UdiseContract.RawData.COLUMN_DISTRICT_NAME);
        int columnIndexZoneCode = cursor.getColumnIndex(UdiseContract.RawData.COLUMN_ZONE_CODE);
        int columnIndexZoneName = cursor.getColumnIndex(UdiseContract.RawData.COLUMN_ZONE_NAME);
        int columnIndexAcYear = cursor.getColumnIndex(UdiseContract.RawData.COLUMN_AC_YEAR);



        List<UserDataModel.States> statesList = new ArrayList<UserDataModel.States>();
        List<UserDataModel.Districts> districtsList = new ArrayList<UserDataModel.Districts>();
        List<UserDataModel.Zones> zonesList = new ArrayList<UserDataModel.Zones>();
        List<UserDataModel.AcademicYears> academicYearsList = new ArrayList<UserDataModel.AcademicYears>();

        UserDataModel userDataModel = new UserDataModel();

        while(cursor.moveToNext()){

            if(stateSet.add(cursor.getString(columnIndexStateName))){
                UserDataModel.States states = new UserDataModel.States();
                states.setStateName(cursor.getString(columnIndexStateName));
                statesList.add(states);
            }

            if(acyearSet.add(cursor.getString(columnIndexAcYear))){
                UserDataModel.AcademicYears academicYears = new UserDataModel.AcademicYears();
                academicYears.setAc_year(cursor.getString(columnIndexAcYear));
                academicYearsList.add(academicYears);
            }

            if(districtSet.add(cursor.getString(columnIndexDistrictCode))){
                UserDataModel.Districts districts = new UserDataModel.Districts();
                districts.setDistrictCode(cursor.getString(columnIndexDistrictCode));
                districts.setDistrictName(cursor.getString(columnIndexDistrictName));
                districtsList.add(districts);
            }

            if(zoneSet.add(cursor.getString(columnIndexZoneCode))){
                UserDataModel.Zones zones = new UserDataModel.Zones();
                zones.setZoneCode(cursor.getString(columnIndexZoneCode));
                zones.setZoneName(cursor.getString(columnIndexZoneName));
                zonesList.add(zones);
            }
        }


        /*
         * Determine user type based on number of states, districts and zones
         * - If there are more than 1 state then it's a national user
         * - If there are more than 1 districts then it's a state user
         * - If there are more than 1 zones then it's a district user
         * - If there is only one zone then it's a zone user
         * - Everything else is not a valid user
         */
        int numberOfStates = statesList.size();
        int numberOfDistricts = districtsList.size();
        int numberOfZones = zonesList.size();
        Log.e(TAG,"States " + numberOfStates + " districts " + numberOfDistricts + " zones " + numberOfZones);

        int userType = UserDataModel.USER_TYPE_UNKNOWN;

        if(numberOfStates>1){
            userType = UserDataModel.USER_TYPE_NATIONAL;
        }
        else if(numberOfStates==1) {
            if(numberOfDistricts>1){
                userType = UserDataModel.USER_TYPE_STATE;
            }
            else if(numberOfDistricts==1){
                if(numberOfZones>1){
                    userType = UserDataModel.USER_TYPE_DISTRICT;
                }
                else if(numberOfZones==1){
                    userType = UserDataModel.USER_TYPE_ZONE;
                }
                else {
                    userType = UserDataModel.USER_TYPE_UNKNOWN;
                }
            }
            else{
                userType = UserDataModel.USER_TYPE_UNKNOWN;
            }
        }
        else{
                /*
                 * This case is only possible if numberOfStates is equal to zero
                 * If that's the case this issue will need to be tackled afterwards
                 */
            userType = UserDataModel.USER_TYPE_UNKNOWN;
        }
        Log.e(TAG,"States " + numberOfStates + " districts " + numberOfDistricts + " zones " + numberOfZones + " user type " + userType);
        userDataModel.setAcademicYearsList(academicYearsList);
        userDataModel.setStatesList(statesList);
        userDataModel.setDistrictsList(districtsList);
        userDataModel.setZoneList(zonesList);
        userDataModel.setUserType(userType);

        /*
         * Clean-up
         */
        cursor.close();


        /*
         * Return the user data model
         */
        return userDataModel;
    }
}
