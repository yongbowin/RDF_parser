package com.eckg.parse.naf;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class ParseNaf {
	public static void main(String[] args) throws Exception {
		System.out.println("��ʼ����JSON���ݣ�");
		
		String relativelyPath=System.getProperty("user.dir");
		
		String path = relativelyPath + "/WebContent/files/demo";
		
		JsonParser parse =new JsonParser();  //����json������
		
		String encoding="utf8";
		
		
//		try {
			//һ���Զ�ȡ�����ļ�
			/*StringBuilder result = new StringBuilder();
				
			InputStreamReader read = new InputStreamReader(new FileInputStream(path), encoding);//���ǵ������ʽ
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			while((lineTxt = bufferedReader.readLine()) != null){
				result.append(System.lineSeparator()+lineTxt);
			}
			System.out.println(result.toString());
			String file_content = result.toString();
			read.close();*/
			
			
			
			JsonObject json =(JsonObject) parse.parse(new FileReader(path));  //����jsonObject����
			System.out.println((json.get("srl")).getClass().getName());
			System.out.println(json.get("srl"));
			
			JsonArray jsonArray = (JsonArray) json.get("srl");
			
			JsonObject jsonObject_array = null;
			
			String str1=json.get("srl").toString();
			str1=new String(str1.getBytes("GBK"),"8859_1");
			System.out.println(str1);
			
			for(int i=0; i<jsonArray.size(); i++) {
				jsonObject_array = (JsonObject) jsonArray.get(i);
				String result_str = jsonObject_array.get("str").toString();
				
				String encode_str = URLEncoder.encode(result_str, "utf8");
				String decode_str = URLDecoder.decode(encode_str, "utf8");

				System.out.println(decode_str);
			}
			
			
//			System.out.println("resultcode:"+json.get("resultcode").getAsInt());  //��json����תΪΪint�͵�����
//			System.out.println("reason:"+json.get("reason").getAsString());     //��json����תΪΪString�͵�����
//			
//			JsonObject result=json.get("result").getAsJsonObject();
//			JsonObject today=result.get("today").getAsJsonObject();
//			System.out.println("temperature:"+today.get("temperature").getAsString());
//			System.out.println("weather:"+today.get("weather").getAsString());
		
//		} catch (JsonIOException e) {
//			e.printStackTrace();
//		} catch (JsonSyntaxException e) {
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
	}
}
