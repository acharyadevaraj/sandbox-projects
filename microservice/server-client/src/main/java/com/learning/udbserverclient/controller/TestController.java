package com.learning.udbserverclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.udb.udbserverclient.config.DbConfigProp;

@RestController
@RequestMapping("/api/clientServer")
public class TestController {

	@Autowired
	private DbConfigProp dbConfigProp;

	/**
	 * This method is Retrieves the value of the "DB Configuration" property from
	 * the Config Server and returns it as a string.
	 *
	 */
	@GetMapping("/dbConfigPropValue")
	@ResponseStatus(HttpStatus.OK)
	public String getDbConfigPropValue() {
		return dbConfigProp.toString();
	}
}
