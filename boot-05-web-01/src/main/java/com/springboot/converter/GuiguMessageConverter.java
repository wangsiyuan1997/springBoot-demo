package com.springboot.converter;

import com.springboot.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 *
 * 自定义MessageConverter 实现多协议数据兼容。json、xml、x-guigu
 * @Date And @Time: 2022/1/10  17:23
 */
public class GuiguMessageConverter implements HttpMessageConverter<Person> {
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Person.class);
    }

    /**
     *
     * @param
     * @return
     * @author 汪思远
     * @creed: Talk is cheap,show me the code
     * @date 2022/1/10 17:25
     *
     * 将服务器要统计的MessageConverter 写入哪些内容
     */

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/x-guigu");
    }


    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        //自定义写入的数据类型
        String data = person.getUserName() + ";" + person.getAge() + ";" + person.getBirth();
        //写入
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes());

    }
}
