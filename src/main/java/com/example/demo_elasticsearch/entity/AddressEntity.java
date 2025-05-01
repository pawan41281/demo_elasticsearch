package com.example.demo_elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String pincode;

}
