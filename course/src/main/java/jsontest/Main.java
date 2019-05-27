package jsontest;

import com.alibaba.fastjson.JSON;

public class Main {
	public static void main(String[] args) {
        String jsonStr = "{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"sucess\",\n" +
                "  \"data\": {\n" +
                "    \"personInfo\": [\n" +
                "      {\n" +
                "        \"key\": \"name\",\n" +
                "        \"value\": \"JOECD\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"key\": \"age\",\n" +
                "        \"value\": 50\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
        Result result = JSON.parseObject(jsonStr, Result.class);
        System.out.println(JSON.toJSONString(result));
	}
}
