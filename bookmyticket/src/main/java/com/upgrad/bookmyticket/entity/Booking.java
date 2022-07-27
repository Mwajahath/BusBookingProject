package com.upgrad.bookmyticket.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
	@Id
	private String bookingId = UUID.randomUUID().toString();
	private String BusId;
	private String BusName;
	private String userId;
	private String userName;

}
