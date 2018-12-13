package com.eckg.parse.run;

import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.eckg.parse.naf.RealTimeParse;

/**
 * 
 * ��;��ִ�н���naf
 * Administrator:yongbo.wang
 * ClassName:com.eckg.parse.run.ExecuteParse
 * 2017��5��3�� ����9:49:20
 *
 */
public class ExecuteParse {
	//�ı�����
	private String contentTxt;
	
	/**
	 * ��ҳ��ת����
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception {
		
		return "success";
	}
	
	public static List<Map<String,Object>> list_map;
	/**
	 * ����ǰ���ύ�������ı�
	 * @return
	 * @throws Exception
	 */
	public String submitTxt() throws Exception {
		
		// http://neofung.ngrok.cc/demo?q=
		System.out.println("�ύ���ı���" + contentTxt);
		String contentTxt_encode = URLEncoder.encode(contentTxt, "utf-8");
//		String paramString = "q=" + contentTxt_encode;
		String paramString = contentTxt_encode;
//		String paramString = "q=" + contentTxt;
		System.out.println("����ȫ��Ϊ��" + paramString);
		
		
		//���� GET ����
//        String responseTxt = HttpRequest.sendGet("http://neofung.ngrok.cc/demo", paramString);
//        System.out.println(responseTxt);
       
        //���� POST ����
//		String responseTxt = HttpRequest.sendPost("http://192.168.100.251:8000/demo", paramString);
		String responseTxt = HttpRequest.sendPost("http://www.chaorder.cn:11000/demo", paramString);
//		String contentTxt_encode1 = URLEncoder.encode(contentTxt, "utf-8");
//		String contentTxt_encode1 = URLDecoder.decode(contentTxt, "utf-8");
		System.out.println(responseTxt);
        
//        RealTimeParse.parseNafJson(responseTxt);
        list_map = RealTimeParse.parseNafJson2(responseTxt);
        
        //�����ݷ��ص�ǰ��
        HttpServletResponse response = ServletActionContext.getResponse();
        PrintWriter outer = response.getWriter();
        JSONArray list_map_arr = JSONArray.fromObject(list_map);
        outer.write(list_map_arr.toString());
        
        //���� POST ����
//        String sr=HttpRequest.sendPost("http://neofung.ngrok.cc/demo", "key=123&v=456");
//        System.out.println(sr);
		
		return null;
	}

	public String getContentTxt() {
		return contentTxt;
	}

	public void setContentTxt(String contentTxt) {
		this.contentTxt = contentTxt;
	}

	public static List<Map<String, Object>> getList_map() {
		return list_map;
	}

	public static void setList_map(List<Map<String, Object>> list_map) {
		ExecuteParse.list_map = list_map;
	}
	
}
