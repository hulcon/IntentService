package in.hulum.intentservice.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Irshad on 11-03-2018.
 */

public class UdiseContract {

    public static final String AUTHORITY = "in.hulum.intentservice";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    /* One path constant for each table*/
    public static final String PATH_RAW_DATA_TABLE = RawData.TABLE_NAME;




    public static final class RawData implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_RAW_DATA_TABLE).build();

        public static final String TABLE_NAME = "rawdata";

        /*
         * Essential columns
         */
        public static final String COLUMN_AC_YEAR = "ac_year";
        public static final String COLUMN_UDISE_SCHOOL_CODE = "schcd";
        public static final String COLUMN_UNIQUE_UDISE_SCHOOL_CODE = "uschcd";
        public static final String COLUMN_SCHOOL_NAME = "schname";
        public static final String COLUMN_SCHOOL_OPERATIONAL_STATUS = "schstatus";
        public static final String COLUMN_LOWEST_CLASS = "lowclass";
        public static final String COLUMN_HIGHEST_CLASS = "highclass";
        public static final String COLUMN_SCHOOL_COEDUCATION_TYPE = "schtype";

        /*
         * Extra info columns
         */
        public static final String COLUMN_IS_RELIGIOUS_MINORITY_SCHOOL = "relminority_yn";
        public static final String COLUMN_RELIGIOUS_MINORITY_TYPE = "relminority_type";
        public static final String COLUMN_IS_RESIDENT_SCHOOL = "schres_yn";
        public static final String COLUMN_RESIDENT_SCHOOL_TYPE = "resitype";
        public static final String COLUMN_IS_SHIFT_SCHOOL = "schshi_yn";
        public static final String COLUMN_IS_CWSN_SCHOOL = "cwsnsch_yn";
        public static final String COLUMN_RURAL_OR_URBAN_CODE = "rururbcd";
        public static final String COLUMN_RURAL_OR_URBAN = "rururb";
        public static final String COLUMN_IS_SCHOOL_APPROACHABLE_BY_ALL_WEATHER_ROADS = "approachbyroad";

        /*
         * Location columns
         */
        public static final String COLUMN_STATE_NAME = "state_name";
        public static final String COLUMN_DISTRICT_CODE = "district_code";
        public static final String COLUMN_DISTRICT_NAME =  "district_name";
        public static final String COLUMN_ZONE_CODE = "blkcd";
        public static final String COLUMN_ZONE_NAME = "blkname";
        public static final String COLUMN_CLUSTER_CODE = "clucd";
        public static final String COLUMN_CLUSTER_NAME = "cluname";
        public static final String COLUMN_VILLAGE_CODE = "vilcd";
        public static final String COLUMN_VILLAGE_NAME = "vilname";
        public static final String COLUMN_ASSEMBLY_CONSTITUENCY_CODE = "aconstcd";
        public static final String COLUMN_ASSEMBLY_CONSTITUENCY_NAME = "constname";
        public static final String COLUMN_PARLIAMENTARY_CONSTITUENCY_CODE = "pconstcd";
        public static final String COLUMN_EDUCATIONAL_BLOCK_CODE = "edublkcd";
        public static final String COLUMN_EDUCATIONAL_BLOCK_NAME = "edublkname";
        public static final String COLUMN_PANCHAYAT_CODE = "pancd";
        public static final String COLUMN_PANCHAYAT_NAME = "panname";
        public static final String COLUMN_HABITATION_CODE = "habitcd";
        public static final String COLUMN_HABITATION_NAME = "habname";
        public static final String COLUMN_MUNICIPALITY_CODE = "municipalcd";
        public static final String COLUMN_MUNICIPALITY_NAME = "munname";
        public static final String COLUMN_CITY_CODE = "city";
        public static final String COLUMN_CITY_NAME = "cityname";
        public static final String COLUMN_POSTAL_ADDRESS = "address";
        public static final String COLUMN_SCHOOL_PINCODE = "pincd";

        /*
         * Geo-Location (GPS) columns
         */
        public static final String COLUMN_LATITUDE_DEGREES = "latdeg";
        public static final String COLUMN_LATITUDE_MINUTES = "latmin";
        public static final String COLUMN_LATITUDE_SECONDS = "latsec";
        public static final String COLUMN_LONGITUDE_DEGREES = "londeg";
        public static final String COLUMN_LONGITUDE_MINUTES = "lonmin";
        public static final String COLUMN_LONGITUDE_SECONDS = "lonsec";


        /*
         * Contact Info Columns
         */
        public static final String COLUMN_STD_CODE_1 = "stdcode1";
        public static final String COLUMN_LANDLINE_PHONE_1 = "phone1";
        public static final String COLUMN_STD_CODE_2 = "stdcode2";
        public static final String COLUMN_LANDLINE_PHONE_2 = "phone2";
        public static final String COLUMN_MOBILE_1 = "mobile1";
        public static final String COLUMN_MOBILE_2 = "mobile2";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_WEBSITE = "website";

        /*
         * Establishment and upgradation columns
         */
        public static final String COLUMN_SCHOOL_ESTABLISHED_YEAR = "estdyear";
        public static final String COLUMN_YEAR_OF_RECOGNITION_ELEMENTARY = "yearrecog";
        public static final String COLUMN_YEAR_OF_RECOGNITION_SECONDARY = "yearrecogs";
        public static final String COLUMN_YEAR_OF_RECOGNITION_HIGHER_SECONDARY = "yearrecogh";
        public static final String COLUMN_YEAR_OF_UPGRADATION_PRIMARY_TO_UPPER_PRIMARY = "yearupgrd";
        public static final String COLUMN_YEAR_OF_UPGRADATION_ELEMENTARY_TO_SECONDARY = "yearupgrds";
        public static final String COLUMN_YEAR_OF_UPGRADATION_SECONDARY_TO_HIGHER_SECONDARY = "yearupgrdh";

        /*
         * Pre-Primary and Anganwadi Columns
         */
        public static final String COLUMN_SCHOOL_HAS_PREPRIMARY_SECTION = "ppsec_yn";
        public static final String COLUMN_TOTAL_PREPRIMARY_ENROLMENT = "ppstudent";
        public static final String COLUMN_TOTAL_PREPRIMARY_TEACHERS = "ppteacher";
        public static final String COLUMN_ANGANWADI_CENTRE_IN_OR_AROUND_SCHOOL = "anganwadi_yn";
        public static final String COLUMN_ANGANWADI_STUDENTS = "anganwadi_stu";
        public static final String COLUMN_ANGANWADI_TEACHERS = "anganwadi_tch";

        /*
         * Board Affiliation columns
         */
        public static final String COLUMN_BOARD_AFFILIATION_TYPE_SECONDARY_LEVEL = "boardsec";
        public static final String COLUMN_BOARD_AFFILIATION_TYPE_HIGHER_SECONDARY_LEVEL = "boardhsec";
        public static final String COLUMN_BOARD_AFFILIATION_NUMBER_SECONDARY_LEVEL = "boardsec_no";
        public static final String COLUMN_BOARD_AFFILIATION_NUMBER_HIGHER_SECONDARY_LEVEL = "boardhsec_no";
        public static final String COLUMN_BOARD_OTHER_TYPE_NAME_SECONDARY_LEVEL = "boardsec_oth";
        public static final String COLUMN_BOARD_OTHER_TYPE_NAME_HIGHER_SECONDARY_LEVEL = "boardhsec_oth";

        /*
         * School Management and Category columns
         */
        public static final String COLUMN_SCHOOL_MANAGEMENT_DESCRIPTION = "schmgt_desc";
        public static final String COLUMN_SCHOOL_MANAGEMENT = "schmgt";
        public static final String COLUMN_SCHOOL_CATEGORY = "schcat";
        public static final String COLUMN_SCHOOL_CATEGORY_DESCRIPTION = "schcat_desc";

        /*
         * Boarding school related columns
         */
        public static final String COLUMN_SCHOOL_HAS_BOARDING_AT_PRIMARY = "boardingp_yn";
        public static final String COLUMN_BOARDING_PRIMARY_BOYS_ENROLMENT = "boardingp_b";
        public static final String COLUMN_BOARDING_PRIMARY_GIRLS_ENROLMENT = "boardingp_g";
        public static final String COLUMN_SCHOOL_HAS_BOARDING_AT_UPPER_PRIMARY = "boardingu_yn";
        public static final String COLUMN_BOARDING_UPPER_PRIMARY_BOYS_ENROLMENT = "boardingu_b";
        public static final String COLUMN_BOARDING_UPPER_PRIMARY_GIRLS_ENROLMENT = "boardingu_g";
        public static final String COLUMN_SCHOOL_HAS_BOARDING_AT_SECONDARY = "boardings_yn";
        public static final String COLUMN_BOARDING_SECONDARY_BOYS_ENROLMENT = "boardings_b";
        public static final String COLUMN_BOARDING_SECONDARY_GIRLS_ENROLMENT = "boardings_g";
        public static final String COLUMN_SCHOOL_HAS_BOARDING_AT_HIGHER_SECONDARY = "boardingh_yn";
        public static final String COLUMN_BOARDING_HIGHER_SECONDARY_BOYS_ENROLMENT = "boardingh_b";
        public static final String COLUMN_BOARDING_HIGHER_SECONDARY_GIRLS_ENROLMENT = "boardingh_g";


        /*
         * Inspections related columns
         */
        public static final String COLUMN_ACADEMIC_INSPECTIONS_LAST_AC_YEAR = "noinspect";
        public static final String COLUMN_VISITS_BY_CRC_COORDINATOR = "visitscrc";
        public static final String COLUMN_VISITS_BY_BRC_COORDINATOR = "visitsbrc";


        /*
         * Financial columns
         */
        public static final String COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_DEVELOPMENT_GRANT_RECEIPT = "conti_r";
        public static final String COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_DEVELOPMENT_GRANT_EXPENDITURE = "conti_e";
        public static final String COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_TLM_TEACHER_GRANT_RECEIPT = "tlm_r";
        public static final String COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_TLM_TEACHER_GRANT_EXPENDITURE = "tlm_e";
        public static final String COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_MAINTENANCE_GRANT_RECEIPT = "schmntcgrant_r";
        public static final String COLUMN_LAST_FINANCIAL_YEAR_SCHOOL_MAINTENANCE_GRANT_EXPENDITURE = "schmntcgrant_e";




        /*
         * Medium of Instruction columns
         */
        public static final String COLUMN_MEDIUM_OF_INSTRUCTION_1 = "medinstr1";
        public static final String COLUMN_MEDIUM_OF_INSTRUCTION_2 = "medinstr2";
        public static final String COLUMN_MEDIUM_OF_INSTRUCTION_3 = "medinstr3";
        public static final String COLUMN_MEDIUM_OF_INSTRUCTION_4 = "medinstr4";



        /*
         * School distance columns
         */
        public static final String COLUMN_DISTANCE_PRIMARY = "distp";
        public static final String COLUMN_DISTANCE_UPPER_PRIMARY = "distu";
        public static final String COLUMN_DISTANCE_SECONDARY = "dists";
        public static final String COLUMN_DISTANCE_HIGHER_SECONDARY = "disth";

        /*
         * No of sections columns
         */
        public static final String COLUMN_PRE_PRIMARY_SECTIONS = "cpp_sec";
        public static final String COLUMN_CLASS_1_SEC = "c1_sec";
        public static final String COLUMN_CLASS_2_SEC = "c2_sec";
        public static final String COLUMN_CLASS_3_SEC = "c3_sec";
        public static final String COLUMN_CLASS_4_SEC = "c4_sec";
        public static final String COLUMN_CLASS_5_SEC = "c5_sec";
        public static final String COLUMN_CLASS_6_SEC = "c6_sec";
        public static final String COLUMN_CLASS_7_SEC = "c7_sec";
        public static final String COLUMN_CLASS_8_SEC = "c8_sec";
        public static final String COLUMN_CLASS_9_SEC = "c9_sec";
        public static final String COLUMN_CLASS_10_SEC = "c10_sec";
        public static final String COLUMN_CLASS_11_SEC = "c11_sec";
        public static final String COLUMN_CLASS_12_SEC = "c12_sec";

        /*
         * Enrolment related columns
         */
        public static final String COLUMN_PRE_PRIMARY_BOYS_ENROLMENT = "cpp_b";
        public static final String COLUMN_PRE_PRIMARY_GIRLS_ENROLMENT = "cpp_g";
        public static final String COLUMN_CLASS_1_BOYS_ENROLMENT = "c1_b";
        public static final String COLUMN_CLASS_1_GIRLS_ENROLMENT = "c1_g";
        public static final String COLUMN_CLASS_2_BOYS_ENROLMENT = "c2_b";
        public static final String COLUMN_CLASS_2_GIRLS_ENROLMENT = "c2_g";
        public static final String COLUMN_CLASS_3_BOYS_ENROLMENT = "c3_b";
        public static final String COLUMN_CLASS_3_GIRLS_ENROLMENT = "c3_g";
        public static final String COLUMN_CLASS_4_BOYS_ENROLMENT = "c4_b";
        public static final String COLUMN_CLASS_4_GIRLS_ENROLMENT = "c4_g";
        public static final String COLUMN_CLASS_5_BOYS_ENROLMENT = "c5_b";
        public static final String COLUMN_CLASS_5_GIRLS_ENROLMENT = "c5_g";
        public static final String COLUMN_CLASS_6_BOYS_ENROLMENT = "c6_b";
        public static final String COLUMN_CLASS_6_GIRLS_ENROLMENT = "c6_g";
        public static final String COLUMN_CLASS_7_BOYS_ENROLMENT = "c7_b";
        public static final String COLUMN_CLASS_7_GIRLS_ENROLMENT = "c7_g";
        public static final String COLUMN_CLASS_8_BOYS_ENROLMENT = "c8_b";
        public static final String COLUMN_CLASS_8_GIRLS_ENROLMENT = "c8_g";
        public static final String COLUMN_CLASS_9_BOYS_ENROLMENT = "c9_b";
        public static final String COLUMN_CLASS_9_GIRLS_ENROLMENT = "c9_g";
        public static final String COLUMN_CLASS_10_BOYS_ENROLMENT = "c10_b";
        public static final String COLUMN_CLASS_10_GIRLS_ENROLMENT = "c10_g";
        public static final String COLUMN_CLASS_11_BOYS_ENROLMENT = "c11_b";
        public static final String COLUMN_CLASS_11_GIRLS_ENROLMENT = "c11_g";
        public static final String COLUMN_CLASS_12_BOYS_ENROLMENT = "c12_b";
        public static final String COLUMN_CLASS_12_GIRLS_ENROLMENT = "c12_g";


        /*
         * Teacher related columns
         */
        public static final String COLUMN_TOTAL_TEACHERS_MALE = "tch_m";
        public static final String COLUMN_TOTAL_TEACHERS_FEMALE = "tch_f";
        public static final String COLUMN_TOTAL_TEACHERS_PRIMARY = "tchpri"; //Includes regular and contract
        public static final String COLUMN_TOTAL_TEACHERS_UPPER_PRIMARY = "tchupr"; //Includes regular and contract
        public static final String COLUMN_TOTAL_TEACHERS_SECONDARY = "tchsec"; //Includes regular and contract
        public static final String COLUMN_TOTAL_TEACHERS_HIGHER_SECONDARY = "tchhsec"; //Includes regular and contract
        public static final String COLUMN_TOTAL_REGULAR_TEACHERS = "tchregu"; //UDISE calculates this from teacher table
        public static final String COLUMN_TOTAL_CONTRACT_TEACHERS = "tchcont"; //UDISE calculates this from teacher table
        public static final String COLUMN_TOTAL_PARTTIME_TEACHERS = "tchpart"; //UDISE calculates this from teacher table
        public static final String COLUMN_TEACHERS_CWSN_TRAINED = "tchcwsntrnd";
        public static final String COLUMN_TEACHERS_WITH_DISABILITIES = "tchdisable";


        /*
         * These Teacher related columns are all wrong!!
         */
        public static final String COLUMN_TEACHERS_SANCTIONED = "tchsan"; //This is misleading it contains upperprimary in position teachers
        public static final String COLUMN_TEACHERS_IN_POSITION = "tchpos"; //This is misleading it contains primary in position teachers
        public static final String COLUMN_PARA_TEAHCERS_IN_POSITION = "parapos"; //Contract Teachers
        public static final String COLUMN_NON_TEACHING_STAFF_IN_POSITION = "ntpos";//This is still not figured out

        /*
         * These columns have not been figured out yet
         */
        public static final String COLUMN_DISTRICT_HQ = "disthq";
        public static final String COLUMN_DISTRICT_CRC = "distcrc";
        public static final String COLUMN_WORK_DAYS = "workdays";
        public static final String COLUMN_FUNDS_RECEIPT = "funds_r"; //This one has not been figure out yet
        public static final String COLUMN_FUNDS_EXPENDITURE = "funds_e"; //This one has not been figure out yet
        public static final String COLUMN_OSRC_RECEIPT = "osrc_r"; //This one has not been figure out yet
        public static final String COLUMN_OSRC_EXPENDITURE = "osrc_e"; //This one has not been figure out yet
        public static final String COLUMN_TLE_RECEIPT = "tle_r";
        public static final String COLUMN_TLE_EXPENDITURE = "tle_e";

        /*
         * New columns related to time of creation and no of changes made
         */
        public static final String COLUMN_ROW_DATA_VERSION = "row_data_version";
        public static final String COLUMN_TIMESTAMP = "timeofinsertion";



        /*
         * New columns added by me for enhancement (to be implemented...)
         *
        public static final String COLUMN_IS_SCHOOL_OPENED_UNDER_SSA = "is_ssa_opened";
        public static final String COLUMN_IS_SCHOOL_OPENED_UNDER_RMSA = "is_rmsa_opened";
        public static final String COLUMN_IS_SCHOOL_UPGRADED_UNDER_SSA = "is_ssa_upgraded";
        public static final String COLUMN_IS_SCHOOL_UPGRADED_UNDER_RMSA = "is_rmsa_upgraded";
        public static final String COLUMN_SCHOOL_HAS_ICT = "has_ict";
        public static final String COLUMN_SCHOOL_HAS_CAL = "has_cal";
        public static final String COLUMN_IS_CLUBBED_SCHOOL = "is_clubbed";
        */
        /*
         * Columns not yet implemented
         *
        public static final String COLUMN_SCHOOL_BUILDING_OWNED_OR_RENTED = "building_ownership";
        public static final String COLUMN_SCHOOL_BUILDING_CONDITION = "building_condition";
        public static final String COLUMN_SCHOOL_HAS_SMC_ACCOUNT = "smcbankac_yn";
        public static final String COLUMN_SCHOOL_SMC_BANK_NAME = "smcbank";
        public static final String COLUMN_SCHOOL_SMC_BANK_BRANCH = "smcbankbranch";
        public static final String COLUMN_SCHOOL_SMC_AC_NAME = "smcacname";
        public static final String COLUMN_SCHOOL_SMC_AC_NUMBER = "smcacno";
        public static final String COLUMN_SCHOOL_SMC_IFS_CODE = "smcifscode";
        public static final String COLUMN_SCHOOL_HAS_SMDC_ACCOUNT = "smdcbankac_yn";
        public static final String COLUMN_SCHOOL_SMDC_BANK_NAME = "smdcbank";
        public static final String COLUMN_SCHOOL_SMDC_BANK_BRANCH = "smdcbankbranch";
        public static final String COLUMN_SCHOOL_SMDC_AC_NAME = "smdcacname";
        public static final String COLUMN_SCHOOL_SMDC_AC_NUMBER = "smdcacno";
        public static final String COLUMN_SCHOOL_SMDC_IFS_CODE = "smdcifscode";
        */

    }
}
