package com.softswiss.go.dev.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Package {
    private String name;
    private String publishedDate;
    private String module;
    private String version;
}