package com.jysoft.web;

import java.util.List;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.jysoft.demos.schedule.UserCountScanner;
import com.jysoft.entity.User;
import com.jysoft.service.AccountEffectiveService;
import com.jysoft.service.AccountService;

import com.google.common.collect.Lists;

@Controller
@RequestMapping(value = "/account/user")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountEffectiveService accountEffectiveService;

	//特别设定多个ReuiresRole之间为Or关系，而不是默认的And.
	@RequiresRoles(value = { "Admin", "User" }, logical = Logical.OR)
	@RequestMapping(value = { "list", "" })
	public String list(Model model) {
		List<User> users = accountService.getAllUser();
		model.addAttribute("users", users);
		logger.info("users="+accountEffectiveService.getTeamWithDetail(1l));
		return "account/userList";
	}

	@RequiresRoles("Admin")
	@RequestMapping(value = "update/{id}")
	public String updateForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", accountService.getUser(id));
		List<String> allStatus = Lists.newArrayList("enabled", "disabled");
		model.addAttribute("allStatus", allStatus);
		return "account/userForm";
	}

	@RequiresPermissions("user:edit")
	@RequestMapping(value = "save/{id}")
	public String update(@Valid @ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
		accountService.saveUser(user);
		redirectAttributes.addFlashAttribute("message", "保存用户成功");
		return "redirect:/account/user";
	}

	@RequestMapping(value = "checkLoginName")
	@ResponseBody
	public String checkLoginName(@RequestParam("oldLoginName") String oldLoginName,
			@RequestParam("loginName") String loginName) {
		if (loginName.equals(oldLoginName)) {
			return "true";
		} else if (accountService.findUserByLoginName(loginName) == null) {
			return "true";
		}

		return "false";
	}

	/**
	 * 使用@ModelAttribute, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出User对象,再把Form提交的内容绑定到该对象上。
	 * 因为仅update()方法的form中有id属性，因此本方法在该方法中执行.
	 */
	@ModelAttribute("user")
	public User getUser(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			return accountService.getUser(id);
		}
		return null;
	}

	/**
	 * 不要绑定对象中的id属性.
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}
}
