/**
 * 
 */
package com.somnus.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.OrderComparator;
import org.springframework.stereotype.Service;

@Service
public class PolyBaseLaudHouseHandlerAdapter implements InitializingBean, 
							ApplicationListener<ContextRefreshedEvent> {
	
	private boolean detectAllHandlers = true;
	
	private List<IPolyBaseLaudHouseService> listServices;
	
	public IPolyBaseLaudHouseService get(String type){
		for(int i = 0;i<listServices.size();i++){
			IPolyBaseLaudHouseService service = listServices.get(i);
			if(service.isSupport(type)){
				return service;
			}
		}
		return null;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ApplicationContext context = event.getApplicationContext();
		if(context.getParent() == null && this.detectAllHandlers){
			Map<String, IPolyBaseLaudHouseService> matchingBeans = BeanFactoryUtils.beansOfTypeIncludingAncestors(
					context, IPolyBaseLaudHouseService.class, true, false);
			if (!matchingBeans.isEmpty()) {
				listServices.addAll(matchingBeans.values());
				OrderComparator.sort(this.listServices);
			}
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		listServices = listServices == null ? 
				new ArrayList<IPolyBaseLaudHouseService>() : listServices;
	}

}
