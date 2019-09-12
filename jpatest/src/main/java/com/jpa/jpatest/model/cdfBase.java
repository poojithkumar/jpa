package com.jpa.jpatest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "cdfBaseImages", schema = "opsbridge_store")
public class cdfBase {
    @Id
    @Column(name = "imageHash")
    private String imageHash;
    @Column(name = "timeStamp")
    private int timeStamp;
    @Column(name = "tag")
    private String tag;
    @Column(name = "layers")

    private String layers;
    @Column(name = "imageName")

    private String imageName;
    @Column(name = "patchSummary")

    private String patchSummary;

    public String getImageHash() {
        return imageHash;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public String getTag() {
        return tag;
    }

    public String getLayers() {
        return layers;
    }

    public String getImageName() {
        return imageName;
    }

    public String getPatchSummary() {
        return patchSummary;
    }

    public void setImageHash(String imageHash) {
        this.imageHash = imageHash;
    }

    public void setTimeStamp(int timestamp) {
        this.timeStamp = timeStamp;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setLayers(String layers) {
        this.layers = layers;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setPatchSummary(String patchSummary) {
        this.patchSummary = patchSummary;
    }

    @Override
    public String toString() {
        return "cdfBase{" +
                "imageHash='" + imageHash + '\'' +
                ", timeStamp=" + timeStamp +
                ", tag='" + tag + '\'' +
                ", layers='" + layers + '\'' +
                ", imageName='" + imageName + '\'' +
                ", patchSummary='" + patchSummary + '\'' +
                '}';
    }
}
