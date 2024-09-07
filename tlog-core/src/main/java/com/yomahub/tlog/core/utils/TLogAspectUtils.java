package com.yomahub.tlog.core.utils;

import com.yomahub.tlog.core.annotation.TLogAspect;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 注解切面工具类
 *
 * @author pengchao
 * @since 2024/9/5
 */
public class TLogAspectUtils {

    private TLogAspectUtils() {
    }

    private static final ThreadLocal<Deque<TLogAspect>> TLOG_ASPECT_THREAD_LOCAL = ThreadLocal.withInitial(LinkedList::new);

    /**
     * 获取当前TLogAspect
     *
     * @return 当前TLogAspect
     */
    public static TLogAspect peek() {
        return TLOG_ASPECT_THREAD_LOCAL.get().peek();
    }

    /**
     * 添加TLogAspect
     *
     * @param tLogAspect TLogAspect
     */
    public static void push(TLogAspect tLogAspect) {
        TLOG_ASPECT_THREAD_LOCAL.get().push(tLogAspect);
    }

    /**
     * 弹出TLogAspect
     */
    public static void pop() {
        TLOG_ASPECT_THREAD_LOCAL.get().pop();
        if (TLOG_ASPECT_THREAD_LOCAL.get().isEmpty()) {
            TLOG_ASPECT_THREAD_LOCAL.remove();
        }
    }
}
