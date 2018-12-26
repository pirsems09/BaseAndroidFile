package com.arif.wifilist.Util;

import android.content.Context;

import com.arif.wifilist.Models.ModelExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GetData {

    private static final String TAG = "GetData";

    //1.function
    private String value="";
    //2.function
    private List<String> valueList = new ArrayList<>();
    //3.function
    private ModelExample modelExample = null;
    //4.function
    private List<ModelExample> modelExampleList = new ArrayList<>();
    //5.function
    //Sorter


    //return single value
    public String returnValue(Context context) {

        return value;
    }

    //return multi value
    public List<String> returnListValue(){
        valueList.add("");
        return valueList;
    }

    //return Model value
    public ModelExample returnPerson(){
        modelExample.setAddress("Adresim");
        modelExample.setName("Arif");
        modelExample.setPhotoId(12);
        return modelExample;
    }

    //return List Model value
    public List<ModelExample> returnPersonList(ModelExample p){
        modelExampleList.add(p);
        return modelExampleList;
    }


    public void Sort() {
        Collections.sort(modelExampleList,new Comparator<ModelExample>() {
            @Override
            public int compare(ModelExample o1, ModelExample o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
    }

}
