package com.csw.converters.impls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import com.csw.converters.XMLJSONConverterI;

public class UsingJSONLibraryImpl implements XMLJSONConverterI {

	@Override
	public void convertJSONtoXML(File json, File xml) throws IOException {
		InputStream is = new FileInputStream(json);
		String jsonTxt = IOUtils.toString(is, "UTF-8");
		JSONObject jsonObj = new JSONObject(jsonTxt);
		StringBuilder sb = new StringBuilder("<object>");
		buildXML(jsonObj,sb);
		sb.append("</object>");
		try {
			FileWriter writer = new FileWriter(xml);
			writer.write(sb.toString());
			writer.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public StringBuilder buildXML(Object passedObject,StringBuilder sb) {
		if(passedObject instanceof JSONObject) {
			JSONObject jsonObject = (JSONObject)passedObject;
			jsonObject.keySet().forEach(key -> {
				Object value = jsonObject.get(key);
				if(value instanceof JSONObject) {
					JSONObject jsonObjectValue = (JSONObject)value;
					sb.append("<object");
					sb.append(" name="+"'"+key+"'>");
					buildXML(jsonObjectValue,sb);
					sb.append("</object>");
				}
				if(value instanceof JSONArray) {
					JSONArray jsonArrayValue = (JSONArray)value;
					sb.append("<array");
					sb.append(" name="+"'"+key+"'>");
					jsonArrayValue.forEach(jav ->buildXML(jav,sb));
					sb.append("</array>");
				}
				if(value instanceof Boolean) {
					Boolean booleanValue = (Boolean)value;
					sb.append("<boolean");
					sb.append(" name="+"'"+key+"'>");
					sb.append(booleanValue);
					sb.append("</boolean>");
				}
				if(value instanceof Double) {
					Double doubleValue = (Double)value;
					sb.append("<double");
					sb.append(" name="+"'"+key+"'>");
					sb.append(doubleValue);
					sb.append("</double>");
				}
				if(value instanceof String) {
					String stringValue = (String)value;
					sb.append("<string");
					sb.append(" name="+"'"+key+"'>");
					sb.append(stringValue);
					sb.append("</string>");
				}
				if(value instanceof Integer) {
					Integer integerValue = (Integer)value;
					sb.append("<number");
					sb.append(" name="+"'"+key+"'>");
					sb.append(integerValue);
					sb.append("</number>");
				}
			});
		} else {
			if(passedObject instanceof Boolean) {
				Boolean booleanValue = (Boolean)passedObject;
				sb.append("<boolean>");
				sb.append(booleanValue);
				sb.append("</boolean>");
			}
			if(passedObject instanceof Double) {
				Double doubleValue = (Double)passedObject;
				sb.append("<double>");
				sb.append(doubleValue);
				sb.append("</double>");
			}
			if(passedObject instanceof String) {
				String stringValue = (String)passedObject;
				sb.append("<string>");
				sb.append(stringValue);
				sb.append("</string>");
			}
			if(passedObject instanceof Integer) {
				Integer integerValue = (Integer)passedObject;
				sb.append("<number>");
				sb.append(integerValue);
				sb.append("</number>");
			}
			if(passedObject instanceof JSONArray) {
				JSONArray jsonArrayValue = (JSONArray)passedObject;
				sb.append("<array>");
				sb.append("<object>");
				jsonArrayValue.forEach(jav ->buildXML(jav,sb));
				sb.append("</object>");
				sb.append("</array>");
			}
		}
		return sb;
	}
}
