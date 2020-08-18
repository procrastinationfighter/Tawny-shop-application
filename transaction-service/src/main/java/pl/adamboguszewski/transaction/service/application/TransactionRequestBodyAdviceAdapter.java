package pl.adamboguszewski.transaction.service.application;

import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;
import com.google.gson.Gson;

import java.lang.reflect.Type;

@Slf4j
@ControllerAdvice
public class TransactionRequestBodyAdviceAdapter extends RequestBodyAdviceAdapter {

    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return false;
    }

    @Override
    public Object afterBodyRead(Object body,
                                HttpInputMessage inputMessage,
                                MethodParameter parameter,
                                Type targetType,
                                Class<? extends HttpMessageConverter<?>> converterType) {
        Gson gsonBuilder = new GsonBuilder().create();
        String bodyJson = gsonBuilder.toJson(body);
        log.info("Request received: " + bodyJson);
        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }
}
