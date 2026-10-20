package com.scc.model;

public class ScenarioEntity {
    private int id;
    private String modelName;
    private String plateNo;
    private double dailyRate;
    private String status;

    // Constructor for fetching from DB (includes ID)
    public ScenarioEntity(int id, String modelName, String plateNo, double dailyRate, String status) {
        this.id = id;
        this.modelName = modelName;
        this.plateNo = plateNo;
        this.dailyRate = dailyRate;
        this.status = status;
    }

    // Constructor for inserting new records (ID is auto-generated)
    public ScenarioEntity(String modelName, String plateNo, double dailyRate, String status) {
        this.modelName = modelName;
        this.plateNo = plateNo;
        this.dailyRate = dailyRate;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }

    public String getPlateNo() { return plateNo; }
    public void setPlateNo(String plateNo) { this.plateNo = plateNo; }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}