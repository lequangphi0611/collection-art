package com.collectionart.app.collectionart.role.repositories;

import com.collectionart.app.collectionart.role.RoleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<RoleEntity, UUID> {
}
