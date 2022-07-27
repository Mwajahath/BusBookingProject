package com.upgrad.bookmyticket.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.upgrad.bookmyticket.enums.Destination;
import com.upgrad.bookmyticket.enums.Source;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Bus {
	@Id
	private String id = UUID.randomUUID().toString();
	private String BusName;
	@Enumerated(EnumType.STRING)
	private Source source;
	@Enumerated(EnumType.STRING)
	private Destination destination;


}
