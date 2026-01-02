package com.klu.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skill_product")
public class Product {
  
  @Id
  @GeneratedValue
  private int pid;
  
  @Column(length = 20,nullable = false)
  private String name;
  
  @Column(length = 20)
  private String desc;
  
  @Column
  private double price;
  
  @Column
  private int qty;