package com.json.examples;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

/**
 * Created by pupsprashu on 16/01/2016.
 */
@JsonIgnoreProperties({"verified"})
public class User {

    public enum Gender {MALE, FEMALE};

    public static class Name {
        private String first;
        private String last;

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        @Override
        public String toString() {
            return "Name{" +
                    "first='" + first + '\'' +
                    ", last='" + last + '\'' +
                    '}';
        }
    }

    private Gender gender;
    private Name name;
    private boolean isVerified;
    private byte[] userImage;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public byte[] getUserImage() {
        return userImage;
    }

    public void setUserImage(byte[] userImage) {
        this.userImage = userImage;
    }

    @Override
    public String toString() {
        return "User{" +
                "gender=" + gender +
                ", name=" + name +
                ", isVerified=" + isVerified +
                ", userImage=" + Arrays.toString(userImage) +
                '}';
    }
}
