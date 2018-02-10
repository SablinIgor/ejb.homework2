package com.sablin.j2ee.model;

import java.util.Date;

public class Operation implements java.io.Serializable{

    private Long id;
    private String v1;
    private String v2;
    private String operator;
    private String result;
    private Date creationDate;

    public Operation(Long id, String v1, String v2, String operator, String result, Date creationDate) {
        this.id = id;
        this.v1 = v1;
        this.v2 = v2;
        this.operator = operator;
        this.result = result;
        this.creationDate = creationDate;
    }

    public Operation(String v1, String v2, String operator, String result){
        this.v1 = v1;
        this.v2 = v2;
        this.operator = operator;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public String getV2() {
        return v2;
    }

    public void setV2(String v2) {
        this.v2 = v2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operation) {
        this.operator = operation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
