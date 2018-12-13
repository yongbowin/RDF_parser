package com.eckg.parse.naf;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * 用途：
 * Administrator:yongbo.wang
 * ClassName:com.eckg.parse.naf.Test
 * 2017年5月3日 下午9:49:52
 *
 */
public class Test {
	public static String ReadFile(String Path){
		BufferedReader reader = null;
		String laststr = "";
		
		try{
			FileInputStream fileInputStream = new FileInputStream(Path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while((tempString = reader.readLine()) != null){
				laststr += tempString;
			}
			reader.close();
		} catch(IOException e){
			e.printStackTrace();
		} finally {
			if(reader != null){
				try{
					reader.close();
				} catch (IOException e){
					e.printStackTrace();
				}
			}
		}
		return laststr;
	}
	
	public static void main(String[] args) {
		
		String relativelyPath=System.getProperty("user.dir");
		
		String path = relativelyPath + "/WebContent/files/development.seg";
		
		String JsonContext = ReadFile(path);
		
		JSONArray jsonArray = JSONArray.fromObject(JsonContext);
		int size = jsonArray.size();
		System.out.println("Size: " + size);
		for(int  i = 0; i < size; i++){
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			System.out.println("[" + i + "]str=" + jsonObject.get("str"));
		}
	}
}
