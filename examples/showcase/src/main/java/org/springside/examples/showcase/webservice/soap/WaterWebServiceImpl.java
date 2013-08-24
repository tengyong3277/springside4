package org.springside.examples.showcase.webservice.soap;

import javax.jws.WebService;
import javax.validation.Validator;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springside.examples.showcase.entity.User;
import org.springside.examples.showcase.service.AccountEffectiveService;
import org.springside.examples.showcase.webservice.soap.response.GetUserResponse;
import org.springside.examples.showcase.webservice.soap.response.base.WSResponse;
import org.springside.examples.showcase.webservice.soap.response.dto.UserDTO;
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

	private static Logger logger = LoggerFactory.getLogger(AccountWebServiceImpl.class);

	@Autowired
	private AccountEffectiveService accountService;

	@Autowired
	private Validator validator;


	/**
	 * @see AccountWebService#getUser()
	 */
	@Override
	public GetUserResponse getMessage(Long id) {
		GetUserResponse response = new GetUserResponse();
		try {

			Validate.notNull(id, "id参数为空");

			User user = accountService.getUser(id);

			Validate.notNull(user, "用户不存在(id:" + id + ")");

			UserDTO dto = BeanMapper.map(user, UserDTO.class);
			response.setUser(dto);

			return response;

		} catch (IllegalArgumentException e) {
			return handleParameterError(response, e);
		} catch (RuntimeException e) {
			return handleGeneralError(response, e);
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
