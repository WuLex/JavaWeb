package wu.conversion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import org.apache.commons.lang.ObjectUtils.Null;
import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map param, String[] paraValues, Class type) {
		//客户端请求传递到服务端使用的方法
		 String formatstr = "yyyy-MM-dd HH:mm:ss";  
		  
		 String DATE_TIME_FOMART_FF = "yy/MM/dd hh:mm:ss";  
		
		if(type.getName().equals("java.sql.Date"))
		{
			 if(paraValues!=null&&paraValues.length>0)
			 {
				 String datestr=paraValues[0];
				 DateFormat dateFormat=new SimpleDateFormat(formatstr);
				 try {
					java.util.Date utilDate=dateFormat.parse(datestr);
				    return new java.sql.Date(utilDate.getTime());
				 } catch (ParseException e) {
					 return null;
				}
				 
			 }
		}
		else if (type.getName().equals("java.util.Date")) 
		{
			if(paraValues!=null&&paraValues.length>0)
			 {
				 String datestr=paraValues[0];
				 DateFormat dateFormat=new SimpleDateFormat(formatstr);
				 try {
					java.util.Date utilDate=dateFormat.parse(datestr);
				    return utilDate;
				 } catch (ParseException e) {
					 return null;
				}
				 
			 }
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object value) {
		 String formatstr = "yyyy-MM-dd HH:mm:ss";  
		 DateFormat dateFormat=new SimpleDateFormat(formatstr);
		if(value instanceof java.sql.Date)
		{
		   return dateFormat.format(value);
		}
		else if (value instanceof java.util.Date) {
			return dateFormat.format(value);
		}
		return value.toString();
	}

}
