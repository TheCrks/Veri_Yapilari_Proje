package com.example.javaproject;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Generator {

    public static boolean percentChance(int percent){
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<percent;i++){
            list.add(random.nextInt(0,100));
        }
        int number = random.nextInt(0,100);
        return indexOf(list, number);
    }

    public static boolean indexOf(ArrayList<Integer> list,int index ){
        boolean bool = false;
        for (int i=0;i<list.size();i++){
            if (index==list.get(i)){
                bool = true;
                break;
            }
        }
        return bool;
    }
    public static boolean indexOfString(ArrayList<String> list,String index ){
        boolean bool = false;
        for (int i=0;i<list.size();i++){
            if (Objects.equals(index, list.get(i))){
                bool = true;
                break;
            }
        }
        return bool;
    }

    public static boolean indexOfNode(ArrayList<Node> list, Node index ){
        boolean bool = false;
        for (int i=0;i<list.size();i++){
            if (Objects.equals(index, list.get(i))){
                bool = true;
                break;
            }
        }
        return bool;
    }



    public static String addAttributeToFile(String add){
        try{
            FileWriter writer = new FileWriter(Library.attributeFile,true);
            writer.write(add+"\n");
            writer.close();
            return "Başarılı";
        }
        catch (IOException e){
            System.out.println("Yazılamadı");
            return "Başarısız";
        }
    }
    public static String addCategoryToFile(String add){
        try{
            FileWriter writer = new FileWriter(Library.categoryFile,true);
            writer.write(add+"\n");
            writer.close();
            return "Başarılı";

        }
        catch (IOException e){
            System.out.println("Yazılamadı");
            return "Başarısız";
        }
    }
    public static String getTime(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return format.format(now);
    }
    public static Media getRandomJobPos(){
        Random random = new Random();
        ArrayList<String> attributes = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();
        ArrayList<String> chosenAttributes = new ArrayList<>();
        Library.categories.clear();
        Library.attributes.clear();
        Library.Modules.clear();

        Library.Modules.add("Filtrelenmiş");
        Library.Modules.add("Sıralanmış");
        Library.Modules.add("Alfabetik");

        try{
            Scanner scanner = new Scanner(Library.attributeFile);
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                attributes.add(data);
                Library.attributes.add(data);
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            Scanner scanner = new Scanner(Library.categoryFile);
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                categories.add(data);
                Library.categories.add(data);
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int pop = random.nextInt(0,10000);
        String time = getTime();
        String [] times = time.split(" ");
        String [] date = times[0].split("/");
        String [] strings = times[1].split(":");
        int year = Integer.parseInt(date[2]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[0]);
        int hour = Integer.parseInt(strings[0]);
        int min = Integer.parseInt(strings[1]);
        int postMon = random.nextInt(0,month)+1;
        int postDay = random.nextInt(0,day)+1;
        int postHour = random.nextInt(0,hour)+1;
        int postMin = random.nextInt(0,min)+1;
        int i = random.nextInt(0,categories.size());
        String cat = categories.get(i);
        int attCount = random.nextInt(0,5);
        ArrayList<Integer> indexes = new ArrayList<>();
        StringBuilder postText = new StringBuilder();
        for (i=0;i<attCount;i++){
            boolean bool = false;
            int j = random.nextInt(0,attributes.size());
            String att = attributes.get(j);
            for (Integer index : indexes) {
                if (j == index) {
                    bool = true;
                    break;
                }
            }
            if (!bool){
            indexes.add(j);
            postText.append(att).append(" ");
            chosenAttributes.add(att);
            }
        }
        postText.append(cat).append(" aranıyor.");
        String postDate = String.valueOf(postDay)+"/"+String.valueOf(postMon)+"/"+String.valueOf(year);
        Media media = new Media(postText.toString(),pop,postDate,postHour,postMin,cat);
        for(int a=0;a<chosenAttributes.size();a++){
            media.setAttributes(chosenAttributes.get(a));
            char key = chosenAttributes.get(a).charAt(0);       key = Character.toLowerCase(key);
            media.setHashAttributes(key, chosenAttributes.get(a));
        }
        System.out.println(media.getHashAttributes());
        return media;
    }

    public static void setRandomPosts(){
        Library.postLib.clear();
        boolean bool = true;
        Random random = new Random();
        ArrayList<String> texts = new ArrayList<>();
        try {
            Scanner reader = new Scanner(Library.postLibFile);
            while(reader.hasNextLine()){
                String text = reader.nextLine();
                texts.add(text);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int postNumber = random.nextInt(1000,10000);
        int counter = 0;
        while (bool){
            int pop = random.nextInt(0,10000);
            String time = getTime();
            String category = "nonJob";
            String [] times = time.split(" ");
            String [] date = times[0].split("/");
            String [] strings = times[1].split(":");
            int year = Integer.parseInt(date[2]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[0]);
            int hour = Integer.parseInt(strings[0]);
            int min = Integer.parseInt(strings[1]);
            int postMon = random.nextInt(0,month)+1;
            int postDay = random.nextInt(0,day)+1;
            int postHour = random.nextInt(0,hour)+1;
            int postMin = random.nextInt(0,min)+1;
            String postDate = String.valueOf(postDay)+"/"+String.valueOf(postMon)+"/"+String.valueOf(year);
            Media media = new Media(texts.get(random.nextInt(0,texts.size())),pop,postDate,postHour,postMin,category);
            if (percentChance(70)){
                Library.postLib.add(getRandomJobPos());
                counter++;
            }
            else {
                Library.postLib.add(media);
                counter++;
            }
            if (counter >= postNumber){
                bool = false;
            }
        }
    }

}
