package com.techelevator.controller;

import java.util.ArrayList;
import java.util.Arrays;

public class MessageHelper {
    public String[] keyWords = new String[2];
    public ArrayList<String> keyWord = new ArrayList<>();


    public String[] filterMessage(String message) {
        String[] inputArray = message.toLowerCase().split(" ");
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].contains("?") || inputArray[i].contains(".")) {
                inputArray[i] = inputArray[i].substring(0, inputArray[i].length() - 1);
            }
        }
        ArrayList<String> strList = new ArrayList<>(Arrays.asList(inputArray));
        if (strList.contains("resume")
                && (strList.contains("example") || strList.contains("examples") || strList.contains("link") || strList.contains("links"))) {
            keyWords[0] = "resume";
            keyWords[1] = "links";
            return keyWords;
        } else if (strList.contains("resume")
                && (strList.contains("parts") || strList.contains("part") || strList.contains("component") || strList.contains("components") || strList.contains("section") || strList.contains("sections"))) {
            keyWords[0] = "resume";
            keyWords[1] = "parts";
            return keyWords;
        } else if (strList.contains("interview")
                && (strList.contains("prep") || strList.contains("prepare") || strList.contains("preparation") || strList.contains("ready"))) {
            keyWords[0] = "interview";
            keyWords[1] = "prep";
            return keyWords;
        } else if (strList.contains("interview")
                && (strList.contains("follow") || strList.contains("up"))) {
            keyWords[0] = "interview";
            keyWords[1] = "follow";
            return keyWords;
        } else if (strList.contains("interview")
                && (strList.contains("outfit") || strList.contains("wear") || strList.contains("clothes") || strList.contains("clothing") || strList.contains("dress"))) {
            keyWords[0] = "interview";
            keyWords[1] = "outfit";
            return keyWords;
        } else if (strList.contains("star") || (strList.contains("interview") && strList.contains("questions"))) {
            keyWords[0] = "interview";
            keyWords[1] = "star";
            return keyWords;
        } else if (strList.contains("cover")
                && ((strList.contains("parts") || strList.contains("part") || strList.contains("component") || strList.contains("components") || strList.contains("section") || strList.contains("sections")))) {
            keyWords[0] = "cover";
            keyWords[1] = "parts";
            return keyWords;
        } else if (strList.contains("cover")
                && (strList.contains("example") || strList.contains("examples") || strList.contains("link") || strList.contains("links"))) {
            keyWords[0] = "cover";
            keyWords[1] = "links";
            return keyWords;
        } else if (strList.contains("linkedin") || strList.contains("linked")) {
            keyWords[0] = "social";
            keyWords[1] = "link";
            return keyWords;
        } else if (strList.contains("huntr") || strList.contains("hunter")) {
            keyWords[0] = "social";
            keyWords[1] = "hunt";
            return keyWords;
        } else if (strList.contains("technical")
                && (strList.contains("prep") || strList.contains("prepare") || strList.contains("preparation") || strList.contains("preparing"))) {
            keyWords[0] = "technical";
            keyWords[1] = "prep";
            return keyWords;
        } else if (strList.contains("technical")
                && strList.contains("interview")) {
            keyWords[0] = "technical";
            keyWords[1] = "explanation";
            return keyWords;
        } else if ((strList.contains("network") || strList.contains("networking"))
                && ((strList.contains("prep") || strList.contains("prepare") || strList.contains("preparation") || strList.contains("preparing")))) {
            keyWords[0] = "networking";
            keyWords[1] = "prep";
            return keyWords;
        } else if ((strList.contains("network") || strList.contains("networking"))
                && ((strList.contains("event") || strList.contains("events") || strList.contains("conference")))) {
            keyWords[0] = "networking";
            keyWords[1] = "events";
            return keyWords;
        } else if (strList.contains("matchmaking")
                && strList.contains("overview")) {
            keyWords[0] = "matchmaking";
            keyWords[1] = "overview";
            return keyWords;
        } else if (strList.contains("dao")
                && strList.contains("testing")) {
            keyWords[0] = "clientserver";
            keyWords[1] = "daotesting";
            return keyWords;
        } else if (strList.contains("matchmaking")
                && strList.contains("prep")) {
            keyWords[0] = "matchmaking";
            keyWords[1] = "prep";
            return keyWords;
        } else if ((strList.contains("database") || (strList.contains("data") && strList.contains("base")))
                && strList.contains("design")) {
            keyWords[0] = "database";
            keyWords[1] = "design";
            return keyWords;
        } else if ((strList.contains("database") || (strList.contains("data") && strList.contains("base")))
                && strList.contains("security")) {
            keyWords[0] = "database";
            keyWords[1] = "security";
            return keyWords;
        } else if (strList.contains("sql") || strList.contains("sequel")) {
            keyWords[0] = "database";
            keyWords[1] = "sql";
            return keyWords;
        } else if (strList.contains("variables") || strList.contains("variable")) {
            keyWords[0] = "java";
            keyWords[1] = "variables";
            return keyWords;
        } else if (strList.contains("arrays") || strList.contains("array")) {
            keyWords[0] = "java";
            keyWords[1] = "arrays";
            return keyWords;
        } else if (strList.contains("collections") || strList.contains("collection")) {
            keyWords[0] = "java";
            keyWords[1] = "collections";
            return keyWords;
        } else if (strList.contains("unit")) {
            keyWords[0] = "java";
            keyWords[1] = "unit";
            return keyWords;
        } else if (strList.contains("oop") || (strList.contains("object") && strList.contains("oriented") && strList.contains("programming"))) {
            keyWords[0] = "java";
            keyWords[1] = "oop";
            return keyWords;
        } else if (strList.contains("inheritance")) {
            keyWords[0] = "java";
            keyWords[1] = "inheritance";
            return keyWords;
        } else if (strList.contains("polymorphism")) {
            keyWords[0] = "java";
            keyWords[1] = "polymorphism";
            return keyWords;
        } else if (strList.contains("exceptions") || strList.contains("exception") || (strList.contains("try") && strList.contains("catch"))) {
            keyWords[0] = "java";
            keyWords[1] = "exceptions";
            return keyWords;
        } else if (strList.contains("encapsulation")) {
            keyWords[0] = "java";
            keyWords[1] = "encapsulation";
            return keyWords;
        } else if (strList.contains("api")) {
            keyWords[0] = "clientserver";
            keyWords[1] = "api";
            return keyWords;
        } else if (strList.contains("dao")) {
            keyWords[0] = "clientserver";
            keyWords[1] = "dao";
            return keyWords;
        } else if (strList.contains("http")) {
            keyWords[0] = "clientserver";
            keyWords[1] = "http";
            return keyWords;
        } else if ((strList.contains("html") && strList.contains("tags")) || strList.contains("tags"))  {
            keyWords[0] = "frontend";
            keyWords[1] = "tags";
            return keyWords;
        } else if (strList.contains("html")) {
            keyWords[0] = "web";
            keyWords[1] = "html";
            return keyWords;
        } else if (strList.contains("javascript") || (strList.contains("java") && strList.contains("script"))) {
            keyWords[0] = "web";
            keyWords[1] = "javascript";
            return keyWords;
        } else if (strList.contains("vue")) {
            keyWords[0] = "web";
            keyWords[1] = "vue";
            return keyWords;
        }  else if (strList.contains("css") || strList.contains("style") || strList.contains("styling")) {
            keyWords[0] = "frontend";
            keyWords[1] = "css";
            return keyWords;
        } else if (strList.contains("flex")) {
            keyWords[0] = "frontend";
            keyWords[1] = "flex";
            return keyWords;
        } else if (strList.contains("pathway")) {
            keyWords[0] = "pathway";
            keyWords[1] = "default";
            return keyWords;
        } else if (strList.contains("resume")) {
            keyWords[0] = "resume";
            keyWords[1] = "default";
            return keyWords;
        } else if (strList.contains("interview")) {
            keyWords[0] = "interview";
            keyWords[1] = "default";
            return keyWords;
        } else if (strList.contains("cover")) {
            keyWords[0] = "cover";
            keyWords[1] = "default";
            return keyWords;
        } else if (strList.contains("networking")) {
            keyWords[0] = "networking";
            keyWords[1] = "default";
            return keyWords;
        } else if (strList.contains("social")) {
            keyWords[0] = "social";
            keyWords[1] = "default";
            return keyWords;
        } else if (strList.contains("matchmaking")) {
            keyWords[0] = "matchmaking";
            keyWords[1] = "default";
            return keyWords;
        } else if (strList.contains("curriculum")) {
            keyWords[0] = "curriculum";
            keyWords[1] = "default";
            return keyWords;
        } else if (strList.contains("java")) {
            keyWords[0] = "java";
            keyWords[1] = "default";
            return keyWords;
        } else if (strList.contains("client")) {
            keyWords[0] = "clientserver";
            keyWords[1] = "default";
            return keyWords;
        } else if (strList.contains("web")) {
            keyWords[0] = "web";
            keyWords[1] = "default";
            return keyWords;
        } else if (strList.contains("database") || strList.contains("databases") || (strList.contains("data") && strList.contains("base"))) {
            keyWords[0] = "database";
            keyWords[1] = "default";
            return keyWords;
        } else if (strList.contains("front")) {
            keyWords[0] = "frontend";
            keyWords[1] = "default";
            return keyWords;
        } else if (strList.contains("keywords") || strList.contains("keyword")) {
            keyWords[0] = "assistance";
            keyWords[1] = "keywords";
            return keyWords;
        }
        keyWords[0] = "help";
        keyWords[1] = "default";
        return keyWords;
    }
}
