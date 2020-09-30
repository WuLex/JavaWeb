package wu.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastjsonFirst {
	/*SerializeWriter���൱��StringBuffer
	JSONArray���൱��List<Object>
	JSONObject���൱��Map<String, Object>
	JSON�����л�û���������飬�������Ͷ���List<Object>*/
	private static  final SerializeConfig   config;
    static 
	{
    config = new SerializeConfig();
    config.put(java.util.Date.class, new JSONLibDataFormatSerializer()); // ʹ�ú�json-lib���ݵ����������ʽ
    config.put(java.sql.Date.class, new JSONLibDataFormatSerializer()); // ʹ�ú�json-lib���ݵ����������ʽ
    }

   private static  final  SerializerFeature[] features = { 
	   SerializerFeature.WriteMapNullValue, //  ��������ֶ�
       SerializerFeature.WriteNullListAsEmpty, // list�ֶ����Ϊnull�����Ϊ[]��������null
       SerializerFeature.WriteNullNumberAsZero, // ��ֵ�ֶ����Ϊnull�����Ϊ0��������null
       SerializerFeature.WriteNullBooleanAsFalse, // Boolean�ֶ����Ϊnull�����Ϊfalse��������null
       SerializerFeature.WriteNullStringAsEmpty // �ַ������ֶ����Ϊnull�����Ϊ""��������null 
	 };
 
	// ���л�Ϊ��JSON-LIB���ݵ��ַ���
 
	public static String toCompatibleJSONString(Object object) { 
		 return JSON.toJSONString(object, config, features);
    }

}
