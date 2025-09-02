package in.anubhav.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.anubhav.db1.entity.ResultFull;
import in.anubhav.service.IResultService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private IResultService resultsrcv;

	@PostMapping("/saving-data")
	public String data(@RequestBody ResultFull result) {
		System.out.println("reslut data rcv is ::" + result);
		// resultsrcv.save(result);
		resultsrcv.saveResult(result);
		return "success";

	}

	@GetMapping("/test")
	public String data() {

		return "success";

	}

}
