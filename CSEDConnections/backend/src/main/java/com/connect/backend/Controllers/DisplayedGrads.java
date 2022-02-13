package com.connect.backend.Controllers;

public class DisplayedGrads {
  public String name, email, company, location, img;

  public DisplayedGrads(String n, String e, Experience ex, String i) {
    name = n;
    email = e;
    company = ex.companyName;
    location = ex.location;
    img = i;
  }

  public DisplayedGrads(String n, String e, String c, String l, String i) {
    name = n;
    email = e;
    company = c;
    location = l;
    img = i;
  }

  public DisplayedGrads() {
  }

  public boolean equalsTo(DisplayedGrads other) {
    return name.equals(other.name)
        && email.equals(other.email)
        && company.equals(other.company)
        && location.equals(other.location)
        && img.equals(other.img);
  }
}
