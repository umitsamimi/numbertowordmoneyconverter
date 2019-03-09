package com.tr.converter.convermoneynumbertotext.service;

import com.tr.converter.convermoneynumbertotext.request.ConvertRequest;
import com.tr.converter.convermoneynumbertotext.response.MoneyResponse;

import javax.validation.Valid;

public interface ConverterService {
	MoneyResponse convertMoneyToWord(@Valid ConvertRequest request);
}
