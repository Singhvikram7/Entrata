package main.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.stream.Collectors;

public class test {
    public static void main(String[]args) throws IOException {
        URL url = new URL("https://public.karat.io/content/test/test_file.txt");
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        List<Map<String,Object>> li=new ArrayList<>();
        while ((inputLine = in.readLine()) != null){
            Map<String,Object> map=new HashMap<>();
            String []data=inputLine.split(",");
            map.put("ID",data[0]);
            map.put("reader",data[1]);
            map.put("book",data[2]);
            map.put("pages",data[3]);
            li.add(map);
        }
        in.close();
      //  System.out.println(li);

        int bookCount=li.stream().map(e->e.get("book")).collect(Collectors.toList()).size();
        List<Integer>page= li.stream().map(e ->Integer.parseInt(e.get("pages").toString())).collect(Collectors.toList());
        int pageCount=0;
        for(int i=0;i<page.size();i++){
            pageCount=pageCount+page.get(i);
        }
        System.out.println(bookCount);
        System.out.println(pageCount);
    }
}
