package com.upgrad.bookmyconsultation.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;


//Mark it with Data, Entity, Builder, NoArgsConstructor, AllArgsConstructor
//create a class named User
	//create firstName of type String
	//create lastName of type String
	//create dob of type String
	//create mobile of type String
	//create primary key 'emailId' of type String
	//create password of type String
	//create createdDate of type String
	//create salt of type String
	//all the mentioned members must be private
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String emailId;
    private String firstName;
    private String lastName;
    private String dob;
    private String mobile;

    private String password;
    private String createdDate;
    private String salt;
}