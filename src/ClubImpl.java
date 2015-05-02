

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
public class ClubImpl  {
   
    public String getAboutUs(){
    	JSONParser parser = new JSONParser();
        
        Object obj = null;
        try {
            File f = new File(".");
            System.out.println(f.getAbsolutePath());
            File relative = new File("AboutUs.json");
            obj = parser.parse(new FileReader(relative));
        } catch (Exception ex) {
            Logger.getLogger(ClubImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
 
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject.toJSONString();
 
   }
    
    public String getEvents() throws IOException{
        JSONParser parser = new JSONParser();
        
        Object obj = null;
        try {
            File f = new File(".");
            System.out.println(f.getAbsolutePath());
            File relative = new File("Events.json");
            obj = parser.parse(new FileReader(relative));
        } catch (Exception ex) {
            Logger.getLogger(ClubImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
 
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject.toJSONString();
    }
    
    
    public String getNews() throws IOException{
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            File f = new File(".");
            System.out.println(f.getAbsolutePath());
            File relative = new File("News.json");
            obj = parser.parse(new FileReader(relative));
        } catch (Exception ex) {
            Logger.getLogger(ClubImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
 
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject.toJSONString();
    }
    
    public String getFAQ(){
    	JSONParser parser = new JSONParser();
        
        Object obj = null;
        try {
            File f = new File(".");
            System.out.println(f.getAbsolutePath());
            File relative = new File("FAQs.json");
            obj = parser.parse(new FileReader(relative));
        } catch (Exception ex) {
            Logger.getLogger(ClubImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
 
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject.toJSONString();
 
   }   public String whoAreYou(){
      return "Me, why I am the java Student Club service using json-rpc.";
   }
   
     
   
   
   
   
}
