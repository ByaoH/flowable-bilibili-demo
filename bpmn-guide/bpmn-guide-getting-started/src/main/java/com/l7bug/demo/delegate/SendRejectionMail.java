package com.l7bug.demo.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class SendRejectionMail implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        System.err.println("################################执行的处理逻辑################################");
        System.err.println("发送邮件给用户");
        System.err.println(execution.getVariables());
    }
}
