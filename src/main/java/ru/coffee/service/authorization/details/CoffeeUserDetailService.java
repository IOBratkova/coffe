package ru.coffee.service.authorization.details;

import ru.coffee.exceptions.user.CoffeeRoleNotFoundException;

import javax.management.relation.RoleNotFoundException;

public interface CoffeeUserDetailService {
    UserPrincipal loadByUsername(String username) throws RoleNotFoundException, CoffeeRoleNotFoundException;
}
