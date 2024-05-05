package com.example.minishop_backend.discount;

import java.util.Date;

public class Discoount {
    private Long id;
    private float percentage;
    private Date startDate;
    private Date endDate;

    public Discoount(Long id, float percentage, Date startDate, Date endDate) {
        this.id = id;
        this.percentage = percentage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Discoount(float percentage, Date startDate, Date endDate) {
        this.percentage = percentage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Discoount{" +
                "id=" + id +
                ", percentage=" + percentage +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}