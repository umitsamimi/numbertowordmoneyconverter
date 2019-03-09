package com.tr.converter.convermoneynumbertotext;

import com.tr.converter.convermoneynumbertotext.request.ConvertRequest;
import com.tr.converter.convermoneynumbertotext.response.MoneyResponse;
import com.tr.converter.convermoneynumbertotext.service.ConverterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.Valid;

import static javafx.beans.binding.Bindings.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConverMoneyNumberToTextApplicationTests {

	@Autowired
	ConverterService converterService;

	ConverterService converterMockService;

	@Before
	public void contextLoads() {
		converterMockService = Mockito.mock(ConverterService.class);
	}

	@Test
	public void whenGivenDollars() {
		ConvertRequest convertRequest = new ConvertRequest();
		convertRequest.setMoneyAmount("1");
		assertEquals("one dolar",converterService.convertMoneyToWord(convertRequest).getMoney().getAmountText());

		convertRequest.setMoneyAmount("2");
		assertEquals("two dolar",converterService.convertMoneyToWord(convertRequest).getMoney().getAmountText());

		convertRequest.setMoneyAmount("11");
		assertEquals("eleven dolar",converterService.convertMoneyToWord(convertRequest).getMoney().getAmountText());

		convertRequest.setMoneyAmount("120");
		assertEquals("one hundred twenty dolar",converterService.convertMoneyToWord(convertRequest).getMoney().getAmountText());

		convertRequest.setMoneyAmount("1230");
		assertEquals("one thousand two hundred thirty dolar",converterService.convertMoneyToWord(convertRequest).getMoney().getAmountText());

		convertRequest.setMoneyAmount("12340");
		assertEquals("twelve thousand three hundred forty dolar",converterService.convertMoneyToWord(convertRequest).getMoney().getAmountText());

		convertRequest.setMoneyAmount("123450");
		assertEquals("one hundred twenty three thousand four hundred fifty dolar",converterService.convertMoneyToWord(convertRequest).getMoney().getAmountText());

		convertRequest.setMoneyAmount("123456789");
		assertEquals("one hundred twenty three millions four hundred fifty six thousand seven hundred eighty nine dolar",converterService.convertMoneyToWord(convertRequest).getMoney().getAmountText());

	}

	@Test
	public void whenGivenDollarsWithCents() {
		ConvertRequest convertRequest = new ConvertRequest();
		convertRequest.setMoneyAmount("1.1");
		assertEquals("one dolar and one cent", converterService.convertMoneyToWord(convertRequest).getMoney().getAmountText());

		convertRequest.setMoneyAmount("11.1");
		assertEquals("eleven dolar and one cent", converterService.convertMoneyToWord(convertRequest).getMoney().getAmountText());

		convertRequest.setMoneyAmount("123.21");
		assertEquals("one hundred twenty three dolar and twenty one cent", converterService.convertMoneyToWord(convertRequest).getMoney().getAmountText());

		convertRequest.setMoneyAmount("1234.21");
		assertEquals("one thousand two hundred thirty four dolar and twenty one cent", converterService.convertMoneyToWord(convertRequest).getMoney().getAmountText());

		convertRequest.setMoneyAmount("12345.44");
		assertEquals("twelve thousand three hundred forty five dolar and forty four cent", converterService.convertMoneyToWord(convertRequest).getMoney().getAmountText());

		convertRequest.setMoneyAmount("123456789.37");
		assertEquals("one hundred twenty three millions four hundred fifty six thousand seven hundred eighty nine dolar and thirty seven cent",converterService.convertMoneyToWord(convertRequest).getMoney().getAmountText());
	}
}
