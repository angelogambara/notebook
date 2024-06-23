package com.example.serializable;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {
    private String name, streetName, postcode, town, provinceAbbr;
    private Integer streetNumber;

    public Address(
            String name,
            String streetName,
            Integer streetNumber,
            String postcode,
            String town,
            String provinceAbbr
    ) {
        setName(name);
        setStreetName(streetName);
        setStreetNumber(streetNumber);
        setPostcode(postcode);
        setTown(town);
        setProvinceAbbr(provinceAbbr);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() == 0)
            throw new IllegalArgumentException("Must not be empty");

        this.name = name;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        if (streetName.length() == 0)
            throw new IllegalArgumentException("Must not be empty");

        this.streetName = streetName;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        if (streetNumber < 1)
            throw new IllegalArgumentException("Must be a positive number");

        this.streetNumber = streetNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        for (int i = 0; i < 4; i++)
            if (postcode.charAt(i) < '0' || postcode.charAt(i) > '9' || postcode.length() != 5)
                throw new IllegalArgumentException("Must be 5 digit long");

        this.postcode = postcode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        if (town.length() == 0)
            throw new IllegalArgumentException("Must not be empty");

        this.town = town;
    }

    public String getProvinceAbbr() {
        return provinceAbbr;
    }

    public void setProvinceAbbr(String provinceAbbr) {
        if (provinceAbbr.length() != 2)
            throw new IllegalArgumentException("Must be 2 chars long");

        this.provinceAbbr = provinceAbbr;
    }

    public String getAddressLine() {
        return streetName + "  " + streetNumber;
    }

    public String getTownLine() {
        return postcode + " " + town + " " + provinceAbbr;
    }


    @Override
    public boolean equals(Object o) {
        return getClass() == o.getClass() && Objects.equals(toString(), o.toString());
    }

    @Override
    public String toString() {
        return name + "\n" + getAddressLine() + "\n" + getTownLine();
    }
}