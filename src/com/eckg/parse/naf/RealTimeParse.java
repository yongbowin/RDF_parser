package com.eckg.parse.naf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RealTimeParse {
	/**
	 * ��http����Ľ����jsonArray���д������ؽ����json����
	 * @param responseTxt
	 * @return
	 */
	public static String parseNafJson(String responseTxt){
		String JsonContext = responseTxt;

		JSONArray jsonArray = JSONArray.fromObject(JsonContext);
		int size = jsonArray.size();
		System.out.println("Size: " + size);
		for(int  i = 0; i < size; i++){
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String sub_str = "";
			sub_str = (String) jsonObject.get("str");
			String[] sub_str_array = sub_str.split(":");
			//��ȡ����
			System.out.println("�����ǣ�" + (sub_str_array[0].split(" "))[1]);
			//��ȡ����
			String[] sub_str_array_sub = sub_str_array[1].split("]");
			for(int k=0; k<sub_str_array_sub.length; k++){
				System.out.println("��־λ");
				System.out.println("����ĳ��ȣ�" + sub_str_array_sub.length);
				String str2 = sub_str_array_sub[k].trim();
				//�ж��±��ַ���ʱ��A0Ϊ���A1Ϊ����
				if(str2.indexOf("A0") != -1){
					//��ȡ����
					System.out.println("�����ǣ�" + (str2.split(" "))[1]);
				} else if(str2.indexOf("A1") != -1){
					//��ȡ����
					System.out.println("�����ǣ�" + (str2.split(" "))[1]);
				}
				System.out.println("--------------------");
			}
					
			System.out.println("[" + i + "]str=" + jsonObject.get("str"));
		}
		return null;
	}
	
	public static List<Map<String, Object>> list_new;
	public static Map<String, Object> map_new;
	/**
	 * ֱ�ӽ���json�еĸ�����ֵ��
	 * @param responseTxt
	 * @return
	 */
	public static List<Map<String,Object>> parseNafJson2(String responseTxt){
		String JsonContext = responseTxt;
		
		list_new = new ArrayList<Map<String, Object>>();
		
//		map1.put("ks", "01");
//		map1.put("js", "10");
//		list_new.add(map1);

		JSONArray jsonArray = JSONArray.fromObject(JsonContext);
		System.out.println("Size: " + jsonArray.size());
		
		for(int  i = 0; i < jsonArray.size(); i++){
			map_new = new HashMap<String, Object>();
			
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			
			//1.��ȡν�� pr-span-firstTarget-lemma
			JSONObject jsonObject1 = (JSONObject) ((JSONObject) jsonObject.get("span")).get("firstTarget");
			String predicate_str = (String) jsonObject1.get("lemma");
			System.out.println("ν���ǣ�" + predicate_str);
			//����map��
			map_new.put("predicate_str", predicate_str);
			
			//2.��ȡ����A0������A1�����ж�semRole��A0��A1��TMP
			//jsonObject.get("roles")��ȡ����һ��JSONArray����
			JSONArray semRole_array = (JSONArray) jsonObject.get("roles");
			int subject_flag = 0;
			int object_flag = 0;
			int time_flag = 0;
			for(int k=0; k<semRole_array.size(); k++){
				
				JSONObject semRole_jsonObject = semRole_array.getJSONObject(k);
				String semRole_val = (String) semRole_jsonObject.get("semRole");
				String semRole_str = (String) semRole_jsonObject.get("str");
				
				//������A0��A1�Ķ�ɾ��
				
				if(semRole_val.equals("A0")){
					subject_flag++;
					//����
					System.out.println("�����ǣ�" + semRole_str);
					//����map�У����ж�map��֮ǰ��û������
					/*if(subject_flag == 0){
						map_new.put("subject_str", semRole_str);
					} else {
						
					}*/
					map_new.put("subject_str", semRole_str);
				} else if(semRole_val.equals("A1")){
					object_flag++;
					//����
					System.out.println("�����ǣ�" + semRole_str);
					//����map�У����ж�map��֮ǰ��û�б���
					map_new.put("object_str", semRole_str);
				} else if(semRole_val.equals("TMP")){
					time_flag++;
					//����
					System.out.println("ʱ���ǣ�" + semRole_str);
					//����map�У����ж�map��֮ǰ��û��ʱ��
					map_new.put("time_str", semRole_str);
				}
			}
			list_new.add(map_new);
			System.out.println("---------------");
		}
		System.out.println("list_new�ǣ�" + list_new);
		return list_new;
	}
	
	public static List<Map<String, Object>> getList_new() {
		return list_new;
	}
	public static void setList_new(List<Map<String, Object>> list_new) {
		RealTimeParse.list_new = list_new;
	}
	public static Map<String, Object> getMap_new() {
		return map_new;
	}
	public static void setMap_new(Map<String, Object> map_new) {
		RealTimeParse.map_new = map_new;
	}
}
