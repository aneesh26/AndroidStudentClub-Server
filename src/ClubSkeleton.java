

import java.net.*;
import java.io.*;
import java.util.*;
import org.json.JSONObject;
import org.json.JSONArray;
import java.text.NumberFormat;

/**
 * Copyright 2015 Aneesh Shastry
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Purpose: This is a Student Club App to enable Clubs to share information with its members.
 *          This is the server code to implement the backend logic 
 *
 * @author : Aneesh Shastry  mailto:ashastry@asu.edu
 *           MS Computer Science, CIDSE, IAFSE, Arizona State University
 * @version : May 1, 2015
 */
public class ClubSkeleton extends Object {

   ClubImpl ci; 

   public ClubSkeleton (){
      super();
      ci = new ClubImpl();
   }

   public String callMethod(String request){
      JSONObject result = new JSONObject();
      NumberFormat nf = NumberFormat.getInstance();
      nf.setMaximumFractionDigits(2);
      try{
         JSONObject theCall = new JSONObject(request);
         String method = theCall.getString("method");
         int id = theCall.getInt("id");
         JSONArray params = null;
         if(!theCall.isNull("params")){
            params = theCall.getJSONArray("params");
         }
         result.put("id",id);
         result.put("jsonrpc","2.0");
         double left = 0;
         double right = 0;
         if(params.length()>0){
            left = params.getDouble(0);
         } if(params.length()>1){
            right = params.getDouble(1);
         }
         if(method.equals("getAboutUs")){
             //code to return the About Us page
            System.out.println("request: "+nf.format(left)+" + "
                               + nf.format(right));
            String res = ci.getAboutUs();
            result.put("result", res);
         }else if(method.equals("getEvents")){
             //code to return the About Us page
            System.out.println("request: "+nf.format(left)+" + "
                               + nf.format(right));
            String res = ci.getEvents();
            result.put("result", res);
         }else if(method.equals("getNews")){
             //code to return the About Us page
            System.out.println("request: "+nf.format(left)+" + "
                               + nf.format(right));
            String res = ci.getNews();
            result.put("result", res);
         }else if(method.equals("getFAQ")){
             //code to return the About Us page
            System.out.println("request: "+nf.format(left)+" + "
                               + nf.format(right));
            String res = ci.getFAQ();
            result.put("result", res);
         }else if(method.equals("whoAreYou")){
            System.out.println("request: whoAreYou");
            result.put("result",ci.whoAreYou());
         }
      }catch(Exception ex){
         System.out.println("exception in callMethod: "+ex.getMessage());
      }
      return "HTTP/1.0 200 Data follows\nServer:localhost:8080\nContent-Type:text/plain\nContent-Length:"+(result.toString()).length()+"\n\n"+result.toString();
   }
}

