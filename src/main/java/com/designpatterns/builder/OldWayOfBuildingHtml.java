package com.designpatterns.builder;

public class OldWayOfBuildingHtml {

    public static void main(String[] args) {

        final String hello = "hello";
        System.out.println("<p>" + hello + "</p>");

        String []words = {"hello", "world"};
        StringBuilder sb = new StringBuilder();
        sb.append("<ul>\n");
        for(String s : words){
            sb.append(String.format("  <li>%s</li>\n", s ));
        }
        sb.append("</ul>");
        System.out.println(sb);
    }
}
