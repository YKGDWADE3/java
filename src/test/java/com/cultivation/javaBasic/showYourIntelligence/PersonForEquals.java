package com.cultivation.javaBasic.showYourIntelligence;

import java.util.Objects;

@SuppressWarnings("unused")
public class PersonForEquals implements Comparable<PersonForEquals>{
    private final String name;
    private final short yearOfBirth;

    public PersonForEquals(String name, short yearOfBirth) {
        if (name == null) {
            throw new IllegalArgumentException("name is mandatory.");
        }

        if (yearOfBirth <= 1900 || yearOfBirth >= 2019) {
            throw new IllegalArgumentException("year of birth is out of range.");
        }

        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }


    public String getName() {
        return name;
    }

    public short getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        PersonForEquals that = (PersonForEquals) obj;
        return that.name.equals(name) && that.yearOfBirth == yearOfBirth;


    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfBirth);
    }

    @Override
    public int compareTo(PersonForEquals person) {
        if (person == null) {
            throw new NullPointerException();
        }
        int nameCompare = this.name.compareTo(person.name);
        if (nameCompare != 0) {
            return nameCompare;
        }
        if (this.yearOfBirth == person.yearOfBirth) return 0;
        return this.yearOfBirth - person.yearOfBirth > 0 ? 1 : -1;

    }
}
