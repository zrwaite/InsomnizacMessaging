package com.insomnizac.messaging.models;

import java.util.ArrayList;

import com.insomnizac.messaging.utils.StringUtils;

public class MessageModels {
	public static class MessageRequest {
		public String to;
		public String message;
		public String InputErrors() {
			ArrayList<String> emptyFields = new ArrayList<String>();
			if (StringUtils.isEmpty(to)) {
				emptyFields.add("to");
			}
			if (StringUtils.isEmpty(message)) {
				emptyFields.add("message");
			}
			if (emptyFields.size() > 0) {
				return "Missing required fields: " + String.join(", ", emptyFields);
			}
			return null;
		}
	}

	public static class MessageMeRequest {
		public String message;
		public String InputErrors() {
			if (StringUtils.isEmpty(message)) {
				return "Missing required field: message";
			}
			return null;
		}
	}
}
