package com.mycompany.myapp.controller;

import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.service.SensingCarService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SensingCarController {
	
	@Autowired
	private SensingCarService sensingCarService;
	
	private static final Logger logger = LoggerFactory.getLogger(SensingCarController.class);


	
	@RequestMapping("/ultrasonicsensor")
	public void ultrasonicsensor(@RequestParam(defaultValue="90") int angle, HttpServletResponse response) throws Exception{
		sensingCarService.changeUltrasonicSensorAngle(angle);
		Thread.sleep(500);
		int distance = sensingCarService.getUltrasonicSensorDistance();
		//int distance=100;
//		return "ultrasonicsensor";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("distance", distance);
		String json = jsonObject.toString();
		
		//클라이언트에게 보내기
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();
	}
	
	@RequestMapping("/gassensor")
	public void gassensor(HttpServletResponse response) throws Exception{
		double value = sensingCarService.getGasSensorValue();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("gas", value);
		String json = jsonObject.toString();
		
		//클라이언트에게 보내기
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();
		
	}

	
}
