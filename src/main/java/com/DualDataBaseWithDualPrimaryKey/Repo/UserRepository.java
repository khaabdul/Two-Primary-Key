package com.DualDataBaseWithDualPrimaryKey.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DualDataBaseWithDualPrimaryKey.Entity.UserBean;
import com.DualDataBaseWithDualPrimaryKey.Entity.UserBeanPrimaryKey;

public interface UserRepository extends JpaRepository<UserBean, UserBeanPrimaryKey> {
}
