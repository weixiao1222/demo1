package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "student")
//與資料庫連結

public class Student {
    @Id//表示主鍵
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自動生成
    @Column(name = "id")
            //選取欄位
    Integer id;

    @Column(name = "name")
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
