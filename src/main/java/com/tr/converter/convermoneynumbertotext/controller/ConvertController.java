package com.tr.converter.convermoneynumbertotext.controller;


import com.tr.converter.convermoneynumbertotext.request.ConvertRequest;
import com.tr.converter.convermoneynumbertotext.response.MoneyResponse;
import com.tr.converter.convermoneynumbertotext.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ConvertController extends BaseController{

	@Autowired
	ConverterService converterService;
	
	@RequestMapping(value="/convertMoneyFromNumberToText", method = RequestMethod.POST)
	public MoneyResponse showRestaurant(@Valid @RequestBody ConvertRequest request){
		return converterService.convertMoneyToWord(request);
	}
}
