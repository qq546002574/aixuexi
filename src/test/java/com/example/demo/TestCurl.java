package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  shell写法
 */

public class TestCurl {


    public static String url = "https://jenkins.fksaas.com/job/fe_wh5_beta/buildWithParameters";
    public static void main(String[] args){
        String[] cmds={"curl","-u", "hushuai:118e30089ddf0319ef78790d8796f75a4b",
                "-XPOST", url};//必须分开写，不能有空格
        System.out.println(execCurl(cmds));
    }


    public static String execCurl(String[] cmds) {
        ProcessBuilder process = new ProcessBuilder(cmds);
        Process p;
        try {
            p = process.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            return builder.toString();

        } catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        }
        return null;

    }
}