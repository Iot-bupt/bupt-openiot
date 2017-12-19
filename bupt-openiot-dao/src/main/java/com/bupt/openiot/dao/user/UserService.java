package com.bupt.openiot.dao.user;


import com.bupt.openiot.common.data.User;
import com.bupt.openiot.common.data.id.UserId;
import com.bupt.openiot.common.data.security.UserCredentials;

import java.util.List;

public interface UserService {

	public List<User> getAll();
	
	public User findUserById(UserId userId);

	public User findUserByEmail(String email);
	
	/*public User saveUser(User user);*/

	public UserCredentials findUserCredentialsByUserId(UserId userId);
	
	/*public UserCredentials findUserCredentialsByActivateToken(String activateToken);

	public UserCredentials findUserCredentialsByResetToken(String resetToken);

	public UserCredentials saveUserCredentials(UserCredentials userCredentials);
	
	public UserCredentials activateUserCredentials(String activateToken, String password);
	
	public UserCredentials requestPasswordReset(String email);

	public void deleteUser(UserId userId);
	
	public TextPageData<User> findTenantAdmins(TenantId tenantId, TextPageLink pageLink);
	
	public void deleteTenantAdmins(TenantId tenantId);
	
	public TextPageData<User> findCustomerUsers(TenantId tenantId, CustomerId customerId, TextPageLink pageLink);
	    
	public void deleteCustomerUsers(TenantId tenantId, CustomerId customerId);*/
	
}
