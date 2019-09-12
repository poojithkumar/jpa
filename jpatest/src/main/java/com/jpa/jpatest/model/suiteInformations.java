package com.jpa.jpatest.model;

import javax.persistence.*;

@Entity
@Table(name = "suiteInformations", schema = "opsbridge_store")
public class suiteInformations {
    @Id
    @Column(name = "id")
    @GeneratedValue
    int id;
    @Column(name = "url")
    private String url;
    @Column(name = "pattern")
    private String  pattern;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPattern() {
        return pattern;
    }



    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "suiteInfo{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", pattern='" + pattern + '\'' +
                '}';
    }


    }

