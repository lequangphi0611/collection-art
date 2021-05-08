package com.collectionart.app.collectionart.role;

import java.util.Collection;

public interface HasRoles {

    <S extends Role> Collection<Role> getRoles();

}
