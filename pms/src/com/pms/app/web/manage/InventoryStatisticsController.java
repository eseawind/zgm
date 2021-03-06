package com.pms.app.web.manage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pms.app.entity.vo.InventoryShow;
import com.pms.app.service.InventoryStatisticsService;
import com.pms.app.service.WarehouseService;

@Controller
@RequestMapping(value = "/manage/inventoryStatistics")

public class InventoryStatisticsController {
	
	@Autowired WarehouseService warehouseService;
	@Autowired InventoryStatisticsService inventoryStatisticsService;
	
	@InitBinder  
	public void initBinder(WebDataBinder binder) throws Exception {  
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    CustomDateEditor dateEditor = new CustomDateEditor(df, true);
	    binder.registerCustomEditor(Date.class, dateEditor);
	} 
	
	@RequestMapping(value = { "/list", "" })
	public String list(Model model, Date beginDate, Date endDate) {
		
		model.addAttribute("beginDate", new DateTime(beginDate).toString("yyyy-MM-dd"));
		model.addAttribute("endDate", new DateTime(endDate).toString("yyyy-MM-dd"));
		//model.addAttribute("warehouseList", warehouseService.findAll());
		if(beginDate!=null && endDate!=null){
			model.addAttribute("inventoryShowList", inventoryStatisticsService.findDailySvgWeightAndPrice(beginDate, endDate));
		}else{
			beginDate = new Date();
			endDate=new Date();
			List<InventoryShow> inventoryShowlist=inventoryStatisticsService.findDailySvgWeightAndPrice(beginDate, endDate);
			if(inventoryShowlist.isEmpty()&& inventoryShowlist.size()==0){
				model.addAttribute("messageErr", "录入价格，请先录入价格！");
			}else{
				model.addAttribute("inventoryShowList", inventoryShowlist);
			}
		}
		
		//model.addAttribute("delegator", delegatorService.findById(delegatorId));
		//model.addAttribute("delegatorId", delegatorId);
		//model.addAttribute("inoutsMap", inOutsRecordService.queryByDelegatorAndDateBetween(delegatorId, supervisionCustomerId, beginDate, endDate));
		return "manage/InventoryStatistics/list";
	}
	
}
