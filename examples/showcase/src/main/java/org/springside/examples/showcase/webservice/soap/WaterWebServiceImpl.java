package org.springside.examples.showcase.webservice.soap;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springside.examples.showcase.entity.Message;
import org.springside.examples.showcase.service.AccountEffectiveService;
import org.springside.examples.showcase.webservice.soap.response.SearchMessageResponse;
import org.springside.examples.showcase.webservice.soap.response.base.WSResponse;
import org.springside.examples.showcase.webservice.soap.response.dto.MessageDTO;
import org.springside.modules.mapper.BeanMapper;

/**
 * WebService服务端实现类.
 * 
 * 为演示方便，直接调用了Dao层.客户端实现见功能测试用例.
 * 
 * @author calvin
 */
//serviceName指明WSDL中的名称, endpointInterface属性指向Interface定义类.
@WebService(serviceName = "WaterService", endpointInterface = "org.springside.examples.showcase.webservice.soap.WaterWebService", targetNamespace = WsConstants.NS)
public class WaterWebServiceImpl implements WaterWebService {

	private static Logger logger = LoggerFactory.getLogger(WaterWebServiceImpl.class);

	@Autowired
	private AccountEffectiveService accountService;

	@Autowired
	private Validator validator;


	/**
	 * @see AccountWebService#getUser()
	 */
	public List searchMessage(String loginName, String name) {
		SearchMessageResponse response = new SearchMessageResponse();
		try {
			List<Message>  userList = accountService.searchMessage(loginName, name);
			logger.info("userList"+userList.size());
			List<MessageDTO> dtoList = BeanMapper.mapList(userList, MessageDTO.class);
			response.setMessageList(dtoList);
			logger.info("****************************5**" );
			 
			return new ArrayList();
		} catch (RuntimeException e) {

			e.printStackTrace();
			logger.info("****************************6**" );
			return null;
		}
	}

	private <T extends WSResponse> T handleParameterError(T response, Exception e, String message) {
		logger.error(message, e.getMessage());
		response.setError(WSResponse.PARAMETER_ERROR, message);
		return response;
	}

	private <T extends WSResponse> T handleParameterError(T response, Exception e) {
		logger.error(e.getMessage());
		response.setError(WSResponse.PARAMETER_ERROR, e.getMessage());
		return response;
	}

	private <T extends WSResponse> T handleGeneralError(T response, Exception e) {
		logger.error(e.getMessage());
		response.setDefaultError();
		return response;
	}
}
