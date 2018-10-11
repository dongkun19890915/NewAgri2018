package com.sinosoft.agriprpall.core.process.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 节点的状态代码常量类
 *
 * @date: 2018/4/3 11:14
 * @author: 何伟东
 */
public class NodeState {

    /**
     * 未处理状态
     */
    public static final String UNPROCESSED = "0";
    /**
     * 处理中状态
     */
    public static final String PROCESSING = "1";
    /**
     * 已处理状态
     */
    public static final String PROCESSED = "2";

    public static Map<String, String> state;

    static {
        state = new HashMap<>();
        state.put(UNPROCESSED, "未处理");
        state.put(PROCESSING, "处理中");
        state.put(PROCESSED, "已处理");
    }

}
