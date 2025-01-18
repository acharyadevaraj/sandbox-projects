package com.learning.customlogwriter.common;

import com.learning.customlogwriter.config.LogWriter;
import com.learning.customlogwriter.config.ModuleName;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

	@GetMapping("/logInfoMsg")
	public String  logInfoMsg() {
		LogWriter.info(ModuleName.LOGGER, this, "This is the Info message");
		return "";
	}
	
	@GetMapping("/logErrorMsg")
	public String  logErrorMsg() {
		LogWriter.error(ModuleName.LOGGER, this, "This is the Error message");
		return "";
	}
	
	@GetMapping("/logWarningMsg")
	public String  logWarningMsg() {
		LogWriter.error(ModuleName.LOGGER, this, "This is the Warning message");
		return "";
	}
}
