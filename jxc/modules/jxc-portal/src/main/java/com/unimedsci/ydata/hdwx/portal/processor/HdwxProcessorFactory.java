package com.unimedsci.ydata.hdwx.portal.processor;

import com.sweetw.idata.intrinsic.wx.ProcessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class HdwxProcessorFactory extends ProcessorFactory{

	public static enum TYPE{DATA};
	
	
	@Autowired
    HdwxProcessor hdwxProcessor;
	
	@Override
	public void init(){
		//System.out.println("ErasProcessorFactory 初始化");
		addProcessor(TYPE.DATA.toString(),hdwxProcessor);
	}
}
