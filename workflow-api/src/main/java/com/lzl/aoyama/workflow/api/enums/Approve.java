package com.lzl.aoyama.workflow.api.enums;

/**
 * @author lzl
 * @date 2021/9/7 17:13
 * @Description:
 */
public enum Approve {

    通过(0),
    打回(1),
    拒绝(2);

    private int code;

    Approve(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
