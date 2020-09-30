package wu.test;

import com.alibaba.fastjson.*;
import com.alibaba.fastjson.util.*;

public class FastJsonTest {
	public static void main(String[] args) {

		String jsonStr = "{\"JACKIE_ZHANG\":\"��ѧ��\",\"ANDY_LAU\":\"���»�\",\"LIMING\":\"����\",\"Aaron_Kwok\":\"������\"}";
		// ��5�β���
		for (int i = 0, j = 5; i < j; i++) {
			JSONObject jsonObject = JSONObject.parseObject(jsonStr);
			for (java.util.Map.Entry<String, Object> entry : jsonObject.entrySet()) 
			{
				System.out.print(entry.getKey() + "-" + entry.getValue() + "\t");
			}
			System.out.println();// ��������
		}
		
		 String jsonStr1 = "[{\"JACKIE_ZHANG\":\"��ѧ��\"},{\"ANDY_LAU\":\"���»�\"},{\"LIMING\":\"����\"},{\"Aaron_Kwok\":\"������\"}]" ;  
		//��5�β���  
        for(int i=0,j=5;i<j;i++)  
        {  
           JSONArray jsonArray = JSONArray.parseArray(jsonStr1);   
           for(int k=0;k<jsonArray.size();k++){  
               System.out.print(jsonArray.get(k) + "\t");  
           }  
            System.out.println();//��������  
        }  
	}
}
