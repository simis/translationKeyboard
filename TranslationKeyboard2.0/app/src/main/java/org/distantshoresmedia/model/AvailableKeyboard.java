package org.distantshoresmedia.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Fechner on 12/18/14.
 */
public class AvailableKeyboard extends BaseDataClass implements Comparable<AvailableKeyboard>{

    static final private String kKeyboardKey = "keyboards";
    static final private String kIdKey = "id";
    static final private String kIsoLanguageKey = "iso_language";
    static final private String kIsoRegionKey = "iso_region";
    static final private String kLanguageNameKey = "language_name";
    static final private String kUpdatedKey = "updated_at";


    public int id;

    private String isoLanguage;

    public String getIsoLanguage() {
        return isoLanguage;
    }

    public void setIsoLanguage(String isoLanguage) {
        this.isoLanguage = isoLanguage;
    }

    private String isoRegion;

    public String getIsoRegion() {
        return isoRegion;
    }

    public void setIsoRegion(String isoRegion) {
        this.isoRegion = isoRegion;
    }

    private String languageName;

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String language) {
        this.languageName = language;
    }


    public AvailableKeyboard(double updated, int id, String isoLanguage, String isoRegion, String language) {
        super(id, updated);
        this.isoLanguage = isoLanguage;
        this.isoRegion = isoRegion;
        this.languageName = language;
        this.id = id;
    }

    public String getObjectAsJSONString(){

        String jsonString = "{\n" + kIdKey + ": " + this.id + ","
                + kIsoLanguageKey + ": \"" + this.isoLanguage + "\","
                + kIsoRegionKey + ": \"" + this.isoRegion + "\","
                + kLanguageNameKey + ": \"" + this.languageName + "\","
                + kUpdatedKey + ": " + this.updated + "},";

        return jsonString;
    }

    public Locale getKeyboardAsLocale(){
        return new Locale(isoLanguage, isoRegion);
    }

    @Override
    public String toString() {
        return "AvailableKeyboard{" +
                "id=" + id +
                ", isoLanguage='" + isoLanguage + '\'' +
                ", isoRegion='" + isoRegion + '\'' +
                ", language_name='" + languageName + '\'' +
                ", updated=" + updated +
                '}';


    }

    static public String getKeyboardNameFromJSONString(String json){

        try {
            JSONObject jObject = new JSONObject(json);
            String name = jObject.getString(kLanguageNameKey);

            return name;
        }
        catch (JSONException e){
            System.out.println("getKeyboardNameFromJSONString JSONException: " + e.toString());
        }

        return null;
    }

    static public AvailableKeyboard[] getKeyboardsFromJsonString(String json) {

        System.out.println("Got to KeyboardVariant");

        ArrayList<AvailableKeyboard> keyboardObjects = new ArrayList<AvailableKeyboard>();

        try {
            JSONObject jsonObj= new JSONObject(json);

            JSONArray keyboards = jsonObj.getJSONArray(kKeyboardKey);

            int lastIndex = keyboards.length();
            for (int i = 0; i < lastIndex; i++) {
                JSONObject rowObj = keyboards.getJSONObject(i);

                int id = rowObj.getInt(kIdKey);
                String isoLanguage = rowObj.getString(kIsoLanguageKey);
                String isoRegion = rowObj.getString(kIsoRegionKey);
                String language = rowObj.getString(kLanguageNameKey);
                double updated = rowObj.getDouble(kUpdatedKey);


                AvailableKeyboard newKeyboard = new AvailableKeyboard(updated, id, isoLanguage, isoRegion, language);
                keyboardObjects.add(newKeyboard);
            }

        } catch (JSONException e) {
            System.out.println("AvailableKeyboard JSONException: " + e.toString());
            return null;
        }

        AvailableKeyboard[] finalKeyboards = new AvailableKeyboard[keyboardObjects.size()];

        int i = 0;
        for(AvailableKeyboard keyboard : keyboardObjects){

            finalKeyboards[i] = keyboard;
            i++;
        }

        return finalKeyboards;
    }

    @Override
    public int compareTo(AvailableKeyboard another) {

        int result = this.languageName.compareTo(another.languageName);
        return result;
    }
}
