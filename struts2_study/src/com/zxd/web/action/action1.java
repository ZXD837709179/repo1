package com.zxd.web.action;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.zxd.model.User;

public class action1 extends ActionSupport{
	
	public String execute() {
		//���ֵջ
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		//put���� ��ջ���������
		valueStack.push(new User("zxd","123"));
		valueStack.push(new User("zxd2","234"));
		
		//setvalue����
		valueStack.setValue("userName", "zxd3");
		valueStack.setValue("#userName4", "zxd4");
		//set��������ֵջ��һ��map����
		valueStack.set("user", new User("userName", "zxd5"));
		System.out.println(ActionContext.getContext().getValueStack().findValue("user"));
		return SUCCESS;
	}
	
	
}
