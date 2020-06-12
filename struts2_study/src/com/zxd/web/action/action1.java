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
		//获得值栈
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		//put方法 往栈顶添加数据
		valueStack.push(new User("zxd","123"));
		valueStack.push(new User("zxd2","234"));
		
		//setvalue方法
		valueStack.setValue("userName", "zxd3");
		valueStack.setValue("#userName4", "zxd4");
		//set方法，往值栈存一个map数据
		valueStack.set("user", new User("userName", "zxd5"));
		System.out.println(ActionContext.getContext().getValueStack().findValue("user"));
		return SUCCESS;
	}
	
	
}
