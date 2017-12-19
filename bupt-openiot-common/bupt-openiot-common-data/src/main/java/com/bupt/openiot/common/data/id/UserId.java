package com.bupt.openiot.common.data.id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UserId extends UUIDBased {

    @JsonCreator
	public UserId(@JsonProperty("id") UUID id){
		super(id);
	}
}
