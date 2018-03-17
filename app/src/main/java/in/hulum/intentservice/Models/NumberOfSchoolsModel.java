package in.hulum.intentservice.Models;

import java.util.List;

/**
 * Created by Irshad on 15-03-2018.
 * This class acts as a model to hold the number of schools
 * for each management per zone
 */



public class NumberOfSchoolsModel {

    /*
     * These constants along with the modelType variable will
     * help in determining whether the object is holding
     * state, district or zone details
     *
     * Typically, we will present this data in a recycler card view
     * and the first card will present the summary of district or state
     * while the rest of the cards will provide details of subclasses
     * like zones etc.
     */
    public static final int MODEL_TYPE_STATE = 100;
    public static final int MODEL_TYPE_DISTRICT = 200;
    public static final int MODEL_TYPE_ZONE = 300;
    public static final int MODEL_TYPE_CLUSTER = 400;

    public static final int PRIMARY_SCHOOL = 1000;
    public static final int MIDDLE_SCHOOL = 2000;
    public static final int HIGH_SCHOOL = 3000;
    public static final int HIGHER_SECONDARY_SCHOOL = 4000;


    private int modelType;

    private String stateCode;
    private String stateName;
    private String districtCode;
    private String districtName;
    private String zoneCode;
    private String zoneName;

    private int totalPrimarySchools;
    private int totalMiddleSchools;
    private int totalHighSchools;
    private int totalHigherSecondarySchools;

    /*Inner Class definition of managementList is below the getters and setters*/
    private List<Management> managementList;

    public int getModelType() {
        return modelType;
    }

    public void setModelType(int modelType) {
        this.modelType = modelType;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public List<Management> getManagementList() {
        return managementList;
    }

    public void setManagementList(List<Management> managementList) {
        this.managementList = managementList;
    }

    public int getTotalPrimarySchools() {
        return totalPrimarySchools;
    }

    public void setTotalPrimarySchools(int totalPrimarySchools) {
        this.totalPrimarySchools = totalPrimarySchools;
    }

    public int getTotalMiddleSchools() {
        return totalMiddleSchools;
    }

    public void setTotalMiddleSchools(int totalMiddleSchools) {
        this.totalMiddleSchools = totalMiddleSchools;
    }

    public int getTotalHighSchools() {
        return totalHighSchools;
    }

    public void setTotalHighSchools(int totalHighSchools) {
        this.totalHighSchools = totalHighSchools;
    }

    public int getTotalHigherSecondarySchools() {
        return totalHigherSecondarySchools;
    }

    public void setTotalHigherSecondarySchools(int totalHigherSecondarySchools) {
        this.totalHigherSecondarySchools = totalHigherSecondarySchools;
    }

    public void incrementTotalPrimarySchools(){
        totalPrimarySchools = totalPrimarySchools + 1;
    }

    public void incrementTotalMiddleSchools(){
        totalMiddleSchools = totalMiddleSchools + 1;
    }

    public void incrementTotalHighSchools(){
        totalHighSchools = totalHighSchools + 1;
    }

    public void incrementTotalHigherSecondarySchools(){
        totalHigherSecondarySchools = totalHigherSecondarySchools + 1;
    }

    /*
         * Since we are calculating number of each category of schools for
         * every management for every zone, we need to create an inner class
         * for the management
         */
    public static class Management{
        private String managementName;
        private int primarySchools;
        private int middleSchools;
        private int highSchools;
        private int higherSecondarySchools;

        public String getManagementName() {
            return managementName;
        }

        public void setManagementName(String managementName) {
            this.managementName = managementName;
        }

        public int getPrimarySchools() {
            return primarySchools;
        }

        public void setPrimarySchools(int primarySchools) {
            this.primarySchools = primarySchools;
        }
        public void incrementPrimarySchools(){
            this.primarySchools = this.primarySchools + 1;
        }

        public int getMiddleSchools() {
            return middleSchools;
        }

        public void setMiddleSchools(int middleSchools) {
            this.middleSchools = middleSchools;
        }

        public void incrementMiddleSchools(){
            this.middleSchools = this.middleSchools + 1;
        }

        public int getHighSchools() {
            return highSchools;
        }

        public void setHighSchools(int highSchools) {
            this.highSchools = highSchools;
        }

        public void incrementHighSchools(){
            this.highSchools = this.highSchools + 1;
        }

        public int getHigherSecondarySchools() {
            return higherSecondarySchools;
        }

        public void setHigherSecondarySchools(int higherSecondarySchools) {
            this.higherSecondarySchools = higherSecondarySchools;
        }

        public void incrementHigherSecondarySchools(){
            this.higherSecondarySchools = this.higherSecondarySchools + 1;
        }

        public void clearAllDAta(){
            this.managementName = "";
            this.primarySchools = 0;
            this.middleSchools = 0;
            this.highSchools = 0;
            this.higherSecondarySchools = 0;
        }
    }

    /*
     * This method determines the type of school based on the category
     * of the school as per the schcat column of UDISE
     *
     */
    public static int determineSchoolType(int schoolCategory){
        int category;
        switch (schoolCategory){
            case 1:
                category = PRIMARY_SCHOOL;
                break;

            case 2:
            case 4:
                category = MIDDLE_SCHOOL;
                break;

            case 6:
            case 7:
            case 8:
                category = HIGH_SCHOOL;
                break;

            case 3:
            case 5:
            case 10:
            case 11:
            case 12:
                category = HIGHER_SECONDARY_SCHOOL;
                break;

            default:
                category = 0;
                break;
        }

        return category;
    }
}
