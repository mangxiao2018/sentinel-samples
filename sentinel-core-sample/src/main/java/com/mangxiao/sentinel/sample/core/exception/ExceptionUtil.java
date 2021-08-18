package com.mangxiao.sentinel.sample.core.exception;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

@Slf4j(topic = "c.ExceptionUtil")
public class ExceptionUtil {
    /**
     * 默认构造器
     */
    public ExceptionUtil(){
        //todo...
    }

    /**
     * 异常处理函数
     * @param request
     * @param body
     * @param execution
     * @param ex
     * @return
     */
    public static SentinelClientHttpResponse handleException(HttpRequest request,
                                                             byte[] body, ClientHttpRequestExecution execution,
                                                             BlockException ex) {
        log.debug("Oops: " + ex.getClass().getCanonicalName());
        return new SentinelClientHttpResponse("custom block info");
    }
}
