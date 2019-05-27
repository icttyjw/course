package jsontest;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

public class PersonDeserializer implements ObjectDeserializer {

    @Override
    public Person deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        Person result = new Person();
        Class targetClass = Person.class;
        //拿到键值对
        List<Pair> infoList = parser.parseArray(Pair.class);
        for (Pair pair : infoList) {
        	//反射赋值
            Field field;
            try {
                field = targetClass.getDeclaredField(pair.getKey());
                field.setAccessible(true);
                field.set(result, pair.getValue());
            } catch (NoSuchFieldException | IllegalAccessException ignored) {

            }
        }
        return result;
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }

    
    private static class Pair {
        private String key;
        private Object value;
		public String getKey() {
			return key;
		}
		public Object getValue() {
			return value;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public void setValue(Object value) {
			this.value = value;
		}
        
    }



}
