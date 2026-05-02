package com.klef.fsad.exam;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoice")
public class Invoice 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String status;
    private double amount;

    @Temporal(TemporalType.DATE)
    private Date date;

    // Default Constructor
    public Invoice() {}

    // Parameterized Constructor
    public Invoice(String name, Date date, String status, double amount) 
    {
        this.name = name;
        this.date = date;
        this.status = status;
        this.amount = amount;
    }

    // Getters and Setters
    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}