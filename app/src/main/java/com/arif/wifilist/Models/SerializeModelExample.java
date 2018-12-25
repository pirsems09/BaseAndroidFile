package com.arif.wifilist.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SerializeModelExample {

    @SerializedName("meta")
    @Expose
    private String meta;
    @SerializedName("modelExample")
    @Expose
    private ModelExample modelExample;

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public ModelExample getModelExample() {
        return modelExample;
    }

    public void setModelExample(ModelExample modelExample) {
        this.modelExample = modelExample;
    }
}