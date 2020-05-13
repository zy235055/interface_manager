package com.abchina.interfacemanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_systemInfo")
public class SystemInfo {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;

    @Id
    @Column(name = "system_name_en")
    private String systemNameEN;

    @Column(name = "system_name")
    private String systemName;



    public String getSystemNameEN() {
        return systemNameEN;
    }

    public void setSystemNameEN(String systemNameEN) {
        this.systemNameEN = systemNameEN;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }
}
