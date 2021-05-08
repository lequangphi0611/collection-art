package com.collectionart.app.collectionart.email;

import com.collectionart.app.collectionart.entity.BaseEntity;
import com.collectionart.app.collectionart.entity.IdObject;
import com.collectionart.app.collectionart.entity.UuidEntity;
import com.collectionart.app.collectionart.user.UserEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = EmailConstants.EMAIL)
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class EmailEntity implements Email, IdObject<Integer> {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 20)
    private String value;

    private boolean available;

    @OneToOne(mappedBy = EmailConstants.EMAIL)
    private UserEntity user;

}
