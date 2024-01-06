package com.DualDataBaseWithDualPrimaryKey.Controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DualDataBaseWithDualPrimaryKey.Entity.UserBean;
import com.DualDataBaseWithDualPrimaryKey.Service.UserService;

@RestController
public class UserControler {
	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<UserBean> insert(@RequestBody UserBean userBean) {
		return new ResponseEntity<UserBean>(userService.insert(userBean), HttpStatus.OK);
	}

	@DeleteMapping("/user")
	public ResponseEntity<UserBean> delete(@RequestParam(required = false) int id,
			@RequestParam(required = false) String name) throws AttributeNotFoundException {
		return new ResponseEntity<UserBean>(userService.delete(id, name), HttpStatus.OK);
	}

	@PutMapping("/user")
	public ResponseEntity<UserBean> update(@RequestBody UserBean userBean) {
		return new ResponseEntity<UserBean>(userService.update(userBean), HttpStatus.OK);
	}

	@GetMapping("/user")
	public ResponseEntity<List<UserBean>> showAll() {
		return new ResponseEntity<List<UserBean>>(userService.showAll(), HttpStatus.OK);
	}

	@GetMapping("/user1")
	public ResponseEntity<UserBean> show(@RequestParam(required = false) String name,
			@RequestParam(required = false) int id) throws AttributeNotFoundException {
		return new ResponseEntity<UserBean>(userService.show(id, name), HttpStatus.OK);

	}
}
