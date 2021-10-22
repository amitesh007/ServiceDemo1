package com.finastra.sme;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finastra.sme.request.data.Objects;
import com.finastra.sme.request.data.RequestData;
import com.finastra.sme.response.data.ResponseData;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
            title = "Servicing",
            version = "0.0"
    )
)
public class Application {

    public static void main(String[] args) throws IOException {
        //Micronaut.run(Application.class, args);
    	
//		RequestData uiRequestGet = getObjectFromJson(getContent("request_GET_from_ui_to_ms.json"),RequestData.class);
//		Map<String,ResponseData> mapResponseData=doGetOrechestration(uiRequestGet);
//		ResponseData responseCashflowData = invokeCashflow();
//		mapResponseData.put("cashflow",responseCashflowData);
		
		getObjectFromJson(getContent("loan_scheduleItems.json"),ResponseData.class);
    }
    
    private static ResponseData invokeCashflow() throws IOException {
		
		return getObjectFromJson(getContent("cashflow.json"),ResponseData.class);
	}

	final static Map<String,ResponseData> mapReqData = new ConcurrentHashMap<>();
    
    public static Map<String,ResponseData> doGetOrechestration(RequestData requestData) {
    	Objects requestObjects = requestData.getObjects();
    	Map<String,ResponseData> mapRequest = null;
    	List<com.finastra.sme.request.data.Object> listOReqObj=requestObjects.getObject();
    	listOReqObj.parallelStream().forEach(reqObject -> {
    		try {
				mapReqData.put(reqObject.getType(),invokeQueryAction(reqObject.getId(),reqObject.getType()));
			} catch (IOException e) {
				e.printStackTrace();
			}
    	});
    	mapRequest = mapReqData;
    	return mapRequest;
    }
    
    private static ResponseData invokeQueryAction(String id,String type) throws IOException {
		if("OST".equals(type)) {
			return getObjectFromJson(getContent("loan.json"),ResponseData.class);
		}else {
			return getObjectFromJson(getContent("scheduleItems.json"),ResponseData.class);
		}
	}

	public static String getContent(String fileName) throws IOException {
    	String path ="C:\\Professional\\SME"+fileName;
    	return Files.readString(Paths.get(path), StandardCharsets.UTF_8);
    }
    
    public static <T> T getObjectFromJson(String jsonInString,Class<T> type) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		T responseObj = mapper.readValue(jsonInString, type);
	    return responseObj;
	}
    
    public static <T> String getJsonFromObject(T type) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(type);
	    return jsonInString;
	}
}
