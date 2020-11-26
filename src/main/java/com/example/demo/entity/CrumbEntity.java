package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author miaoying
 * @date 4/2/18
 */
@Data
public class CrumbEntity implements Serializable {
    private String crumb;
    private String crumbRequestField;

    public CrumbEntity(String crumb, String crumbRequestField) {
        this.crumb = crumb;
        this.crumbRequestField = crumbRequestField;
    }
}
