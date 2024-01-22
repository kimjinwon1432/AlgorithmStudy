package egovframework.proxyRequest;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestProxyController {
	@RequestMapping(value="/proxyTest.do")
	public HashMap<String, String> requestMethod(String user_id) {
		HashMap<String, String> map = new HashMap<>();
		map.put("user_id", user_id);
		System.out.println("user_id: "+user_id);
		return map;
	}
}
