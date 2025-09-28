package com.terceirinha.entity;

import jakarta.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String date; // For simplicity, string; can use LocalDate later
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] image; // store as bytes, not base64 string

    public Event() {
    }

    public Event(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public byte[] getImage() { return image; }
    public void setImage(byte[] image) { this.image = image; }
}
