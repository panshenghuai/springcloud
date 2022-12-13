package com.my.cloud.entities;

import java.io.Serializable;

/**
 * @author psh
 * @version 1.0
 * @date 2022/12/5 14:44
 */

public class Payment implements Serializable {
    private Long id;
    private String serial;

    public Payment() {
    }


    public Payment(Long id, String serial) {
        this.id = id;
        this.serial = serial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
