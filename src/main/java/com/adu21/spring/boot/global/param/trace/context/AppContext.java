package com.adu21.spring.boot.global.param.trace.context;

import com.alibaba.ttl.TransmittableThreadLocal;
import org.springframework.core.NamedThreadLocal;

import java.io.Serializable;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
public class AppContext implements Serializable {
    public static final String TRACE_ID_HEADER = "Trace-Id";
    public static final String USER_ID_HEADER = "User-Id";
    public static final String KEY_TRACE_ID = "traceId";
    public static final String KEY_USER_ID = "userId";
    private static final long serialVersionUID = -979220111440953115L;

    private String traceId;
    private Long userId;

    private static final TransmittableThreadLocal<AppContext> LOCAL = new TransmittableThreadLocal<AppContext>() {
        @Override
        protected AppContext initialValue() {
            return new AppContext();
        }
    };
//    // todo test ThreadLocal
//    private static final ThreadLocal<AppContext> LOCAL = new NamedThreadLocal<AppContext>("APP_CONTEXT") {
//        @Override
//        protected AppContext initialValue() {
//            return new AppContext();
//        }
//    };

    public static AppContext getContext() {
        return LOCAL.get();
    }

    public static void setContext(AppContext context) {
        LOCAL.set(context);
    }

    public static void removeContext() {
        LOCAL.remove();
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
