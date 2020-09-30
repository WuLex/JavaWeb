package wu.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastjsonFirst {
	/*SerializeWriter：相当于StringBuffer
	JSONArray：相当于List<Object>
	JSONObject：相当于Map<String, Object>
	JSON反序列化没有真正数组，本质类型都是List<Object>*/
	private static  final SerializeConfig   config;
    static 
	{
    config = new SerializeConfig();
    config.put(java.util.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
    config.put(java.sql.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
    }

   private static  final  SerializerFeature[] features = { 
	   SerializerFeature.WriteMapNullValue, //  输出空置字段
       SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
       SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
       SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
       SerializerFeature.WriteNullStringAsEmpty // 字符类型字段如果为null，输出为""，而不是null 
	 };
 
	// 序列化为和JSON-LIB兼容的字符串
 
	public static String toCompatibleJSONString(Object object) { 
		 return JSON.toJSONString(object, config, features);
    }

}
