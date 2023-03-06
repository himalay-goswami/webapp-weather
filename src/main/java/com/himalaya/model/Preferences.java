package com.himalaya.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_pref")
public class Preferences {
    @Id
    private String cityName;

    private double minValuePreferred;

    private double maxValuePreferred;


}
