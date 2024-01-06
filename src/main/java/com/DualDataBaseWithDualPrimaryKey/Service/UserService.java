package com.DualDataBaseWithDualPrimaryKey.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.DualDataBaseWithDualPrimaryKey.Entity.UserBean;
import com.DualDataBaseWithDualPrimaryKey.Entity.UserBeanPrimaryKey;
import com.DualDataBaseWithDualPrimaryKey.Repo.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public UserBean insert(UserBean userBean) {
		if (userRepository.findById(new UserBeanPrimaryKey(userBean.getUserBeanPrimaryKey().getId(),
				userBean.getUserBeanPrimaryKey().getName())).isPresent()) {
			throw new DuplicateKeyException("Primary Key Already Exsist");
		}
		return userRepository.save(userBean);

	}

	public UserBean delete(int id, String name) throws AttributeNotFoundException {
		Optional<UserBean> user = userRepository.findById(new UserBeanPrimaryKey(id, name));
		if (id == 0 && name.equals(null)) {
			throw new AttributeNotFoundException("Please Enter Data");
		}
		if (user.isEmpty()) {
			throw new NoSuchElementException("Data Not Present");
		}
		userRepository.delete(user.get());
		return user.get();
	}

	public UserBean update(UserBean userBean) {
		Optional<UserBean> findById = userRepository.findById(new UserBeanPrimaryKey(
				userBean.getUserBeanPrimaryKey().getId(), userBean.getUserBeanPrimaryKey().getName()));
		if (findById.isEmpty()) {
			throw new NoSuchElementException("Data Not Present");
		}
		if (userBean.getNumber() == 0) {
			userBean.setNumber(findById.get().getNumber());
		}
		if (userBean.getAddress().equals(null)) {
			userBean.setAddress(findById.get().getAddress());
		}
		return userRepository.save(userBean);

	}

	public List<UserBean> showAll() {

		return userRepository.findAll();
	}

	public UserBean show(int id, String name) throws AttributeNotFoundException {
		Optional<UserBean> user = userRepository.findById(new UserBeanPrimaryKey(id, name));
		if (id == 0 && name.equals(null)) {
			throw new AttributeNotFoundException("Please Enter Data");
		}
		if (user.isEmpty()) {
			throw new NoSuchElementException("Data Not Present");
		}
		return user.get();
	}
}
