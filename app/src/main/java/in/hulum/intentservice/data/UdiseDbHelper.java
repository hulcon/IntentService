package in.hulum.intentservice.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Irshad on 12-03-2018.
 */

public class UdiseDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "udise.db";
    private static final int DATABASE_VERSION = 1;

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

                UdiseContract.RawData.COLUMN_ROW_DATA_VERSION + " INTEGER, " +
                UdiseContract.RawData.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP " +
                " );";

        db.execSQL(SQL_CREATE_TABLE_UDISE_RAW_DATA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
